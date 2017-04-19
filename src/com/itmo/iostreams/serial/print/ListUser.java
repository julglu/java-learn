package com.itmo.iostreams.serial.print;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * Created by Юлия on 18.04.2017.
 */
public class ListUser implements Command,Externalizable {
    private CommandCode code=CommandCode.LIST_USERS;
    private String sender;
    private List<User> users;


    public ListUser(){
        users=new ArrayList<>();
    }

    public ListUser(String name){
        users=new ArrayList<>();
        sender=name;
    }

    @Override
    public String toString() {
        return "UserList: "+ users.toString();
    }

    @Override
    public CommandCode getCode() {
        return code;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(sender);
        out.writeObject(users);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        sender=in.readObject().toString();
        users= (List<User>) in.readObject();
    }

    public String getSender(){
        return sender;
    }

    public void add(User newUser){
        Iterator<User> iter=users.iterator();
        while(iter.hasNext()){
           User u=iter.next();
            if(u.getUserName().equals(newUser.getUserName())) {
                u.setLogCnt(u.getLogCnt() + 1);
                u.setLastLogIn(newUser.getLastLogIn());
                return;
            }
        }

        users.add(newUser);

    }
}
