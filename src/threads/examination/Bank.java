package threads.examination;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * Created by Юлия on 10.05.2017.
 */
public class Bank {
    private ExecutorService execute = Executors.newFixedThreadPool(4);

    private BlockingQueue<Message> messages = new LinkedBlockingQueue<>();


    public Bank() {
        MailerThread mailer = new MailerThread();
        mailer.start();
    }


    public void transferMoney(Account source, Account dest, int amount) {

        execute.submit(new Transaction(source, dest, amount));

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
                    if (source.account.getBalance() - amount < 0) {
                        messages.offer(new Message(source.account, dest.account, amount, false));
                        return false;
                    }
                    if (dest.lock.tryLock()) {
                        try {
                            dest.account.setBalance(dest.account.getBalance() + amount);
                            source.account.setBalance(source.account.getBalance() - amount);

                            isSucseded = true;
                            messages.offer(new Message(source.account, dest.account, amount, true));
                            sleep(2000);
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

    private class MailerThread extends Thread {

        @Override
        public void run() {
            while (true) {

                Message m;
                while ((m = messages.poll()) != null) {
                    System.out.println("Transaction: " +
                            "\n\t\tSource account: " + m.source.getId() +
                            "\n\t\t\t\t balance:  " + m.source.getBalance() +
                            "\n\t\tDestin account: " + m.destination.getId() +
                            "\n\t\t\t\t balance:  " + m.destination.getBalance() +
                            "\n\tTransfer amount: " + m.amount);
                    if (m.result) {
                        System.out.println("\tTransaction succeeded\n");
                    } else {
                        System.out.println("\tTransaction failed\n");

                    }
                }
            }
        }
    }

    static class TranzAcc {
        Account account;
        ReentrantLock lock;

        TranzAcc(Account a) {
            account = a;
            lock = new ReentrantLock();
        }
    }

    static class Message {
        Account source;
        Account destination;
        int amount;
        boolean result;

        Message(Account a1, Account a2, int amount, boolean result) {
            source = a1;
            destination = a2;
            this.amount = amount;
            this.result = result;
        }

    }

}
