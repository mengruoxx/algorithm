package concurrent;

/**
 * 实现一个阻塞队列
 * 1.采用循环数组
 */
public class MyBlockingQueue {
    private int[] queue;
    private volatile int size = 0;
    private int front = 0;
    private int rear = 0;

    public MyBlockingQueue(int length){
        queue = new int[length];
    }

    public synchronized void push(int element) throws InterruptedException {
        while (size >= queue.length) {
            wait();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        size ++;
    }

    public synchronized int pop() {
        notifyAll();
        return queue[rear];
    }
}
