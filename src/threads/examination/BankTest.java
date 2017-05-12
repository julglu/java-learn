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

        Bank bank=new Bank();

        for (int i = 0; i <10 ; i++) {
            int source, dest;
            while(true) {
                 source = new Random().nextInt(10);
                 dest = new Random().nextInt(10);
                if(source!=dest)
                    break;
            }
            bank.transferMoney(accounts.get(source),accounts.get(dest), (new Random().nextInt(4)+1)*1000);

        }
    }


}
