package com.itmo.iostreams.serial.print;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * Created by Юлия on 18.04.2017.
 */
public class ServerTime implements Command,Externalizable {
    CommandCode code = CommandCode.SERVER_TIME;
    Date serverTime;
    String sender;



    public ServerTime(String sender){
        this.sender=sender;
    }
    public ServerTime(){}


    @Override
    public CommandCode getCode() {
        return code;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        serverTime=(Date)in.readObject();
        sender=(String)in.readObject();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(serverTime);
        out.writeObject(sender);
    }

    @Override
    public String toString() {
        return "ServerTime: "+serverTime;
    }

    public void setServerTime(Date time){
        serverTime=time;
    }
    public void setSender(String name){
        sender=name;
    }
    public String getSender(){
        return sender;
    }
}
