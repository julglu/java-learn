package Objects.collections;

import Objects.collections.inner.Message;
import Objects.collections.inner.MessageGenerator;
import Objects.collections.inner.MessagePriority;
import Objects.collections.inner.User;

import java.util.*;

import static Objects.collections.inner.UserGenerator.generate;

public class Tasks2 {
    public static void main(String[] args) {
        List<User> users = generate(10);
        System.out.println(users);
        System.out.println(sortedByCompanyAndName(users));
        System.out.println(sortedBySalaryAndName(users));
        System.out.println(sortedBySalaryAgeCompanyAndName(users));
        MessageGenerator generator = new MessageGenerator();
        List<Message> messages = generator.generate(10);
        sortByPriority(messages, MessagePriority.URGENT);

        List<Message> m1=new ArrayList<>();
        List<Message> m2=new ArrayList<>();
        m1.add(new Message(MessagePriority.LOW,9));
        m1.add(new Message(MessagePriority.LOW,6));
        m2.add(new Message(MessagePriority.URGENT,8));
        m2.add(new Message(MessagePriority.URGENT,6));
        Iterator<Message> iterator=viewIterator(m1,m2);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static void sortByPriority(List<Message> messages, MessagePriority priority) {

        messages.sort(new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                int rez;
                if (m1.getPriority() == priority && m2.getPriority() == priority)
                    rez = -10 + (m1.getCode() - m2.getCode());
                else if (m1.getPriority() == priority)
                    rez = -10;
                else if (m2.getPriority() == priority)
                    rez = 10;
                else rez = m1.getPriority().compareTo(m2.getPriority());
                return rez;
            }
        });
        System.out.println(messages);
    }

    private static NavigableSet<User> sortedByCompanyAndName(List<User> users) {
        NavigableSet<User> ns = new TreeSet<>(User.CompanyAndNameComparator);
        ns.addAll(users);
        return ns;
    }

    private static NavigableSet<User> sortedBySalaryAndName(List<User> users) {
        NavigableSet<User> ns = new TreeSet<>(User.SalaryAndNameComparator);
        ns.addAll(users);
        return ns;
    }

    private static NavigableSet<User> sortedBySalaryAgeCompanyAndName(List<User> users) {
        NavigableSet<User> ns = new TreeSet<>(User.SalaryAgeCompanyAndNameComparator);
        ns.addAll(users);
        return ns;
    }

    private static <T> Iterator<T> viewIterator(Iterable<T> it1, Iterable<T> it2) {
        Iterator<T> newIterator = new Iterator<T>() {
            Iterator<T> i1 = it1.iterator();
            Iterator<T> i2 = it2.iterator();
            @Override
            public boolean hasNext() {
                if (i1.hasNext())
                    return true;
                else if (i2.hasNext())
                    return true;
                return false;
            }

            @Override
            public T next() {
                if (i1.hasNext())
                    return i1.next();
                else if (i2.hasNext())
                    return i2.next();
                return null;
            }

            @Override
            public void remove() {
            }
        };
        return newIterator;
    }


}
