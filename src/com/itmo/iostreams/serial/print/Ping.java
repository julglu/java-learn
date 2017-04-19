package com.itmo.iostreams.serial.print;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Юлия on 18.04.2017.
 */
public class Ping implements Command, Externalizable {
    CommandCode code = CommandCode.PING;
    String sender;
    long roundTripTime;
    long startTime;

    public Ping() {
        startTime = System.nanoTime();
    }
    public Ping(String sender) {
        startTime = System.nanoTime();
        this.sender=sender;
    }

    @Override
    public CommandCode getCode() {
        return code;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(sender);
        out.writeLong(roundTripTime);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        sender=(String)in.readObject();
        roundTripTime = in.readLong();
    }

    public void setSender(String name) {
        sender = name;
    }

    public void setRoundTripTime(long time) {
        roundTripTime = time;
    }

    public String getSender() {
        return sender;
    }

    public long getRoundTripTime() {
        return roundTripTime;
    }

    public long getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "ping {StartTime: " + startTime + ", round trip time: " + roundTripTime + "}";
    }
}
