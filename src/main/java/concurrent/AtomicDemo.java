package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicDemo {

    public static class User {
        String name;
        int age;
    }

    public static void main(String[] args) {
        // 原子整型
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(100);
        atomicInteger.compareAndSet(100, 105);

        // 原子引用
        new User();
        AtomicReference<User> atomicReference = new AtomicReference<>();

        // 版本号原子引用
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
        atomicStampedReference.compareAndSet(100, 101, 1, 2);
    }
}
