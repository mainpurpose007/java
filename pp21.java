import java.util.*;
public class pp21 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of subjects: ");
int n = scanner.nextInt();
LinkedList<String> list = new LinkedList<>();
for (int i = 0; i < n; i++) {
System.out.print("Enter subject " + (i+1) + ": ");
String subject = scanner.next();
list.add(subject);
}
System.out.println("Subject names:");
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
}
}


program 2

import java.util.LinkedList;

public class ProducerConsumer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity = 1;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
            
                while (buffer.size() == capacity)
                    wait();

                System.out.println("Producer produced: " + value);
                buffer.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.size() == 0)
                    wait();
                int consumedValue = buffer.removeFirst();
                System.out.println("Consumer consumed: " + consumedValue);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        final ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
