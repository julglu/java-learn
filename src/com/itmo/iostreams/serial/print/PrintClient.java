package com.itmo.iostreams.serial.print;

import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by xmitya on 28.08.16.
 */
public class PrintClient {

    private SocketAddress serverAddr;

    private String name;

    private Scanner scanner;

    public PrintClient(SocketAddress serverAddr, Scanner scanner) {
        this.serverAddr = serverAddr;
        this.scanner = scanner;
    }

    private void start() throws IOException, ClassNotFoundException {
        System.out.println("Enter your name: ");

        name = scanner.nextLine();

        while (true) {
            System.out.println("Enter message to send: ");

            String msg = scanner.nextLine();

            if ("/exit".equals(msg))
                break;
            else if ("/nick".equals(msg)) {
                System.out.println("Enter new name:");

                name = scanner.nextLine();

                continue;
            } else if ("/myaddr".equals(msg)) {
                printAddresses();

                continue;
            } else if ("/list_users".equals(msg)) {
                sendReceiveCommand(new ListUser(name));
                continue;

            } else if ("/server_time".equals(msg)) {
                sendReceiveCommand(new ServerTime(name));
                continue;

            } else if ("/ping".equals(msg)) {
                sendReceiveCommand(new Ping(name));
                continue;
            }


            buildAndSendMessage(msg);
        }
    }

    private void printAddresses() throws SocketException {
        Enumeration e = NetworkInterface.getNetworkInterfaces();

        while (e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();

            Enumeration ee = n.getInetAddresses();

            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();

                System.out.println(i.getHostAddress());
            }
        }
    }

    private void buildAndSendMessage(String msg) throws IOException {
        Message message = new Message(System.currentTimeMillis(), name, msg);

        sendPrintMessage(message);

        System.out.println("Sent: " + message);
    }

    private void sendPrintMessage(Message msg) throws IOException {
        try (Socket sock = new Socket()) {
            sock.connect(serverAddr);

            try (OutputStream out = sock.getOutputStream()) {
                ObjectOutputStream objOut = new ObjectOutputStream(out);

                objOut.writeObject(msg);

                objOut.flush();
            }
        }
    }

    private void sendReceiveCommand(Command command) throws IOException, ClassNotFoundException {
        try (Socket sock = new Socket()) {
            sock.connect(serverAddr);

            try (InputStream in = sock.getInputStream();
                 OutputStream out = sock.getOutputStream()) {
                ObjectOutputStream objOut = new ObjectOutputStream(out);

                objOut.writeObject(command);
                objOut.flush();

                Object o=new ObjectInputStream(in).readObject();
                CommandCode code=((Command)o).getCode();
                switch (code){
                    case PING:
                        Ping ping=(Ping)o;
                        ping.setRoundTripTime(System.nanoTime()-ping.getStartTime());
                        System.out.println(ping);
                        break;
                    case LIST_USERS:
                        ListUser listUser=(ListUser)o;
                        System.out.println(listUser);
                        break;
                    case SERVER_TIME:
                        ServerTime st=(ServerTime)o;
                        System.out.println(st);
                        break;
                }
            }
        }
    }

    private static SocketAddress parseAddress(String addr) {
        String[] split = addr.split(":");
        return new InetSocketAddress(split[0], Integer.parseInt(split[1]));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String addr = null;

        if (args != null && args.length > 0)
            addr = args[0];

        Scanner scanner = new Scanner(System.in);

        if (addr == null) {
            System.out.println("Enter server address");

            addr = scanner.nextLine();
        }

        PrintClient client = new PrintClient(parseAddress(addr), scanner);

        client.start();
    }
}
