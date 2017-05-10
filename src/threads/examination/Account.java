package threads.examination;

import java.util.Random;

/**
 * Created by Юлия on 10.05.2017.
 */
public class Account {
    private int id;
    private String userName;
    private int balance;
    private static int startID=0;

    public Account(String userName, int balance){
        this.userName=userName;
        this.balance=balance;
        if(startID==0){
            startID=new Random().nextInt();
        }
        this.id=startID++;
    }

    public void setBalance(int balance){
        this.balance=balance;
    }

    public int getBalance(){
        return balance;
    }
}
