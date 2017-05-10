package threads.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Юлия on 10.05.2017.
 */
public class Bank {
    private List<TranzAcc> accounts = new ArrayList<>();
    ExecutorService execute = Executors.newFixedThreadPool(4);


    public Bank(List<Account> accounts) {
        for (Account acc : accounts) {
            this.accounts.add(new TranzAcc(acc));
        }
    }


    public void transferMoney(Account source, Account dest, int amount) {
        Future<Boolean> task = execute.submit(new Transaction(source, dest, amount));
        try {
            if (task.get()) {
                System.out.println(source.getBalance() + " " + dest.getBalance());
                //оповестить Mailer
            } else {
                System.out.println("transaction failed");

            }

        } catch (Exception e) {

        }
    }

    private class Transaction implements Callable<Boolean> {
        boolean isSucseded = false;
        TranzAcc source;
        TranzAcc dest;
        int amount;

        public Transaction(Account s, Account d, int amount) {
            source = new TranzAcc(s);
            dest = new TranzAcc(d);
            this.amount = amount;
        }

        @Override
        public Boolean call() throws Exception {
            if (source.lock.tryLock()) {
                try {
                    if (source.account.getBalance() - amount < 0)
                        return false;
                    if (dest.lock.tryLock()) {
                        try {
                            dest.account.setBalance(dest.account.getBalance() + amount);
                            source.account.setBalance(source.account.getBalance() - amount);
                            System.out.println(Thread.currentThread().getName() + " transaction");
                            isSucseded = true;
                            Thread.currentThread().sleep(1000);
                        } finally {
                            dest.lock.unlock();
                        }
                    }

                } catch (Exception e) {
                    isSucseded = false;
                } finally {
                    source.lock.unlock();

                }
            }


            return isSucseded;
        }
    }

    private class MailerThread implements Runnable {
        @Override
        public void run() {

        }
    }

    private static class TranzAcc {
        Account account;
        ReentrantLock lock;

        public TranzAcc(Account a) {
            account = a;
            lock = new ReentrantLock();
        }
    }

}
