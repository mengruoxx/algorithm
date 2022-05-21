package demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mengruo
 * @date 2022/4/15 20:01
 */
public class Demo {

    public static void demo() {
        AtomicInteger sessionIdSeed = new AtomicInteger();

        int sessionId = sessionIdSeed.incrementAndGet();

        if (sessionId >= Integer.MAX_VALUE) {

        }

    }

    static class Symbol {

        private Integer index;

        private BigDecimal winChips;
    }

    public static void main(String[] args) {
        List<Symbol> list = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            list.add(null);
        }
        list.set(3, new Symbol());
        System.out.println(list);
        System.out.println(list.size());
    }
}
