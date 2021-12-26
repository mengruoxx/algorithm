package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mengruo
 * @date 2021/12/15
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 ***************************************************************************************************
 * 双向链表 + 哈希表。
 * 哈希表的key是关键字，value是关键字所对应的双向链表node，因为get和put都需要O(1)复杂度，那么就需要通过key直接得到双向链表中的这个节点，
 * 不然还需要O(n)复杂度定位到这个节点之后，再进行删除这个节点的操作。
 * 要在这个类里表达一个双向链表：属性里有首指针和尾指针。（如果是单链表，就一个Node类型的head就能表示了）
 * 双向链表的Node包含key和value，和prev和next指针
 *
 * 注意Map的key和value是什么
 * XXX private Map<Integer, Integer> map;
 */
public class L146LRUCache {

    private Map<Integer, DoubleLinkedNode> map;

    /**
     * 首节点和尾节点，用于定位双向链表和在头部插入元素的，本身并不是意义节点。
     */
    private DoubleLinkedNode head;

    private DoubleLinkedNode tail;

    private volatile int capacity;

    private volatile int size;

    static class DoubleLinkedNode {
        private int key;
        private int value;
        private DoubleLinkedNode prev;
        private DoubleLinkedNode next;

        DoubleLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }

        DoubleLinkedNode(){

        }
    }

    /**
     * 初始化时需要创建首节点和尾结点，并相互指向
     * @param capacity
     */
    public L146LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get操作首先在哈希表中获取节点，如果获取不到直接返回-1，如果获取得到，返回该值，并维护双向链表。
     *
     * @param key
     * @return
     */
    public synchronized int get(int key) {
        DoubleLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 将该节点移到链表头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DoubleLinkedNode node) {
        // 移除元素
        removeNode(node);
        // 添加到头部
        addToHead(node);
    }

    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * @param key
     * @param value
     */
    public synchronized void put(int key, int value) {
        DoubleLinkedNode node = map.get(key);
        if (node == null) {
            node = new DoubleLinkedNode(key, value);
            // 不存在则判断链表size是否超过最大容量
            if (size == capacity) {
                // 删除尾部元素，别忘了在哈希表中和链表中都要删除
                DoubleLinkedNode tailNode = tail.prev;
                // 从哈希表中删除
                map.remove(tailNode.key);
                // 从双向链表中删除
                removeNode(tailNode);
                // size
                size --;
            }
            map.put(key, node);
            addToHead(node);
            size ++;
        } else {
            //如果存在则修改值并维护
            node.value = value;
            map.put(key, node);
            // 将该节点移到链表头部
            moveToHead(node);
        }
    }

    private void addToHead(DoubleLinkedNode node) {
        // 添加到头部
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public static void main(String[] args) {
//        L146LRUCache obj = new L146LRUCache(capacity);
//        int param_1 = obj.get(key);
//        obj.put(key,value);
    }
}
