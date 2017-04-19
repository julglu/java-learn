package com.itmo.iostreams.serial.print;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xmitya on 28.08.16.
 */
public class PrintServer {

    private int port;

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    public PrintServer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        try (ServerSocket ssocket = new ServerSocket(port)) {
            System.out.println("Server started on " + ssocket);

            while (true) {
                Socket sock = ssocket.accept();

                try {
                    process(sock);
                } catch (ClassNotFoundException e) {
                    System.err.println("Wrong message was received");

                    e.printStackTrace();
                } finally {
                    sock.close();
                }
            }
        }
    }

    private void process(Socket sock) throws IOException, ClassNotFoundException {
        String host = sock.getInetAddress().getHostAddress();


        try (ObjectInputStream objIn = new ObjectInputStream(sock.getInputStream());
             OutputStream out = sock.getOutputStream()) {

            Object obj = objIn.readObject();
            System.out.println(obj);
            OutputStream fout = new FileOutputStream("users.bin", true);
            ObjectOutputStream objFout = new ObjectOutputStream(fout);

            if (obj instanceof Message) {
                printMessage((Message) obj, host);
                User u = new User(((Message) obj).getSender(), host);

                objFout.writeObject(u);
                objFout.flush();
                objFout.close();
            } else {
                ObjectOutputStream objOut = new ObjectOutputStream(out);
                User u;
                switch (((Command) obj).getCode()) {
                    case PING:
                        Ping ping = (Ping) obj;
                        System.out.printf("%s (%s) send command: /ping\n", ping.getSender(), host);
                        objOut.writeObject(ping);
                        objOut.flush();

                        u = new User(ping.getSender(), host);
                        objFout.writeObject(u);
                        objFout.flush();
                        objFout.close();
                        break;

                    case LIST_USERS:
                        ListUser lu = (ListUser) obj;
                        System.out.printf("%s (%s) send command: /list_users\n", lu.getSender(), host);

                        u = new User(lu.getSender(), host);
                        System.out.println(u);
                        objFout.writeObject(u);
                        objFout.flush();
                        objFout.close();


                        InputStream fin = new FileInputStream("users.bin");
                        System.out.println("users.bin opened");
                        ObjectInputStream oin;


                        while (fin.available() > 0) {
                            oin = new ObjectInputStream(fin);
                            User user = (User) oin.readObject();
                            System.out.println(user);
                            lu.add(user);

                        }
                        objOut.writeObject(lu);
                        objOut.flush();

                        break;

                    case SERVER_TIME:
                        ServerTime st = (ServerTime) obj;
                        System.out.printf("%s (%s) send command: /server_time\n", st.getSender(), host);
                        st.setServerTime(new Date());
                        objOut.writeObject(st);
                        objOut.flush();

                        u = new User(st.getSender(), host);
                        objFout.writeObject(u);
                        objFout.flush();
                        objFout.close();
                        break;

                }
            }

        } catch (IOException | ClassNotFoundException | RuntimeException e) {
            System.err.println("Failed process connection from: " + host);

            e.printStackTrace();

            throw e;
        }

    }

    private void printMessage(Message msg, String senderAddr) {
        System.out.printf("%s (%s) at %s wrote: %s\n", msg.getSender(), senderAddr, format.format(new Date(msg.getTimestamp())), msg.getText());
    }

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0)
            throw new IllegalArgumentException("Port must be specified");

        int port = Integer.parseInt(args[0]);

        PrintServer printServer = new PrintServer(port);

        printServer.start();
    }
}
