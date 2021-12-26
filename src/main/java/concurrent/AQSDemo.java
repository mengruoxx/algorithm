package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class AQSDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // 主线程 等待被唤醒，有三个线程执行了countDown才可以被唤醒
        countDownLatch.await();

        // 线程5
        countDownLatch.await();

        // 线程1
        countDownLatch.countDown();
        // 线程2
        countDownLatch.countDown();
        // 线程3，此时线程5和主线程一起被唤醒
        countDownLatch.countDown();

        /**
         * 信号量
         */
        Semaphore semaphore = new Semaphore(3);

        // 线程1
        semaphore.acquire();
        // 线程2
        semaphore.acquire();
        // 线程3
        semaphore.acquire();

        // 线程4再acquire时就会失败, 会阻塞，在AQS队列里排队
        semaphore.acquire();

        // 线程1释放掉一个信号量，线程4会被唤醒
        semaphore.release();

    }
}
