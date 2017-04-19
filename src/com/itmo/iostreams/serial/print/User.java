package com.itmo.iostreams.serial.print;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

/**
 * Created by Юлия on 18.04.2017.
 */
public class User implements Externalizable {
    private String userName;
    private String host;
    private int logCnt;
    private Date lastLogIn;

    private static String path = ".\\users.txt";

    public User(){}
    public User(String name, String host) {
        userName = name;
        this.host = host;
        logCnt = 1;
        lastLogIn = new Date();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(userName);
        out.writeObject(host);
        out.writeInt(logCnt);
        out.writeObject(lastLogIn);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        userName = in.readObject().toString();
        host = in.readObject().toString();
        logCnt = in.readInt();
        lastLogIn = (Date) in.readObject();

    }
    public String getUserName(){
        return userName;
    }
    public int getLogCnt(){
        return logCnt;
    }

    public Date getLastLogIn(){
        return lastLogIn;
    }
    public void setLogCnt(int cnt){
        logCnt=cnt;
    }

    public void setLastLogIn(Date date){
        lastLogIn=date;
    }

    @Override
    public String toString() {
        return "User {userName: " + userName +
                "(" + host +
                "), logCnt: " + logCnt +
                ", lastLogIn: " + lastLogIn +
                "}";
    }


}
