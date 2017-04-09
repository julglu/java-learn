package Objects.collections;

import Objects.collections.inner.MessageGenerator;
import Objects.collections.inner.Message;
import Objects.collections.inner.MessagePriority;

import java.util.*;

public class Tasks1 {

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(100);

        countEachPriority(messages);
        countEachCode(messages);
        countUniqueMessages(messages);

        System.out.println(messages);
        System.out.println("Genuine messages in natural order: \n" + genuineMessagesInOriginalOrder(messages));

        removeEach(generator.generate(100), MessagePriority.LOW);
        removeOther(generator.generate(100), MessagePriority.URGENT);
    }

    private static void countEachPriority(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого приоритета.
        // Ответ необходимо вывести в консоль.
        int[] cntPriority = new int[MessagePriority.values().length];
        for (Message m : messages) {
            cntPriority[m.getPriority().ordinal()]++;
        }
        for (int i = 0; i < cntPriority.length; i++) {
            System.out.println(MessagePriority.fromOrdinal(i) + ": " + cntPriority[i]);
        }

    }

    private static void countEachCode(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого кода сообщения.
        // Ответ необходимо вывести в консоль.
        List<Integer> cntCodes = new ArrayList<>(10);
        for (Message m : messages) {
            if (cntCodes.size() <= m.getCode()) {
                for (int i = cntCodes.size(); i < m.getCode() + 1; i++) {
                    cntCodes.add( 0);
                }
            }
            cntCodes.set(m.getCode(), cntCodes.get(m.getCode()) + 1);
        }
        for (int i = 0; i < cntCodes.size(); i++) {
            System.out.println(i + ": " + cntCodes.get(i));
        }
        // TODO implement
    }

    private static void countUniqueMessages(List<Message> messages) {
        // Сосчитайте количество уникальных сообщений.
        // Ответ необходимо вывести в консоль.
        Set<Message> uniqueMessages = new HashSet<>();
        for (Message m : messages) {
            uniqueMessages.add(m);
        }
        System.out.println(uniqueMessages.size());

    }

    private static List<Message> genuineMessagesInOriginalOrder(List<Message> messages) {
        // Здесь необходимо вернуть только неповторяющиеся сообщения и в том порядке, в котором
        // они встречаются в первоначальном списке. Например, мы на входе имеем такие сообщения:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}],
        // то на выходе должны получить:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}].
        // Т.е. остались только уникальные значения, и порядок их поступления сохранен.

        List<Message> genuineOrderM = new ArrayList<>();
        for (Message m : messages) {
            if (!genuineOrderM.contains(m))
                genuineOrderM.add(m);
        }

        return genuineOrderM;
    }

    private static void removeEach(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции каждое сооющение с заданным приоритетом.
        System.out.printf("Before remove each: %s, %s\n", priority, messages);
        Iterator<Message> iter = messages.iterator();
        while (iter.hasNext()) {
            if (iter.next().getPriority() == priority)
                iter.remove();
        }

        System.out.printf("After remove each: %s, %s\n", priority, messages);
    }

    private static void removeOther(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет.
        System.out.printf("Before remove other: %s, %s\n", priority, messages);
        Iterator<Message> iter = messages.iterator();
        while (iter.hasNext()) {
            if (iter.next().getPriority() != priority)
                iter.remove();
        }
        // TODO implement

        System.out.printf("After remove other: %s, %s\n", priority, messages);
    }
}
