package algorithm.linkedlist;

/**
 * 707. 设计链表
 * 中等
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 *
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 *
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 *
 * 实现 MyLinkedList 类：
 *
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 *
 * 需要有一个假头, 需要保存链表的长度，需要f一个尾部指针tail
 *
 * @author mengruo
 * @date 2024/1/24 15:56
 */
public class L707MyLinkedList {

    /**
     * 假头
     */
    private Node preHead;
    /**
     * tail指针
     */
    private Node tail;
    /**
     * 长度
     */
    private int size;

    class Node {
        private int val;
        private Node next;
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public L707MyLinkedList() {
        // 初始化假头,tail指向假头
        preHead = new Node(0, null);
        tail = preHead;
        size = 0;
    }

    /**
     * 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
     * @param index
     * @return
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node result = preHead;
        for (int i = 0; i <= index; i++) {
            result = result.next;
        }
        return result.val;
    }

    /**
     * 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点
     * @param val
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val, preHead.next);
        preHead.next = newNode;
        if (size == 0) {
            // 更新tail
            tail = newNode;
        }
        size++;
    }

    /**
     * 将一个值为 val 的节点追加到链表中作为链表的最后一个元素
     * @param val
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val, null);
        tail.next = newNode;
        tail = tail.next;
        size++;
    }

    /**
     * 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
     * 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node targetNode = preHead;
        for (int i = 0; i <= index - 1; i++) {
            targetNode = targetNode.next;
        }
        Node newNode = new Node(val, targetNode.next);
        targetNode.next = newNode;
        size++;

    }

    /**
     * 如果下标有效，则删除链表中下标为 index 的节点
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node targetNode = preHead;
        Node pre = null;
        for (int i = 0; i <= index; i++) {
            pre = targetNode;
            targetNode = targetNode.next;
        }
        pre.next = targetNode.next;
        // 维护tail
        if (pre.next == null) {
            tail = pre;
        }
        size--;

    }

    public static void main(String[] args) {
        L707MyLinkedList l707MyLinkedList = new L707MyLinkedList();
        // "addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get"
        l707MyLinkedList.addAtHead(7);
        l707MyLinkedList.addAtHead(2);
        l707MyLinkedList.addAtHead(1);
        l707MyLinkedList.addAtIndex(3, 0);
        l707MyLinkedList.deleteAtIndex(2);
        l707MyLinkedList.addAtHead(6);
        l707MyLinkedList.addAtTail(4);
        l707MyLinkedList.get(4);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
