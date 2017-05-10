package threads.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Created by Юлия on 10.05.2017.
 */
public class BankTest {
    public static void main(String[] args) {
        List<Account> accounts=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account("user"+i,(new Random().nextInt(9)+1)*1000));
        }

        Bank bank=new Bank(accounts);
        System.out.println(accounts.get(0).getBalance()+" "+accounts.get(1).getBalance());
        System.out.println(accounts.get(2).getBalance()+" "+accounts.get(3).getBalance());
        bank.transferMoney(accounts.get(0),accounts.get(1), 500);
        bank.transferMoney(accounts.get(0),accounts.get(3), 3500);
        bank.transferMoney(accounts.get(2),accounts.get(3), 3500);


    }


}
