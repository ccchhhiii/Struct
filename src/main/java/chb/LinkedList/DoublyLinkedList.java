package chb.LinkedList;

import java.util.Iterator;

/**
 * 双向链表
 */
public class DoublyLinkedList implements Iterable<Integer> {

    private static class Node {
        Node prev;//上一个节点指针
        int value;//值
        Node next;//下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;//头哨兵
    private Node tail;//尾哨兵

    /**
     * 当前类的构造方法自动创建双向链表的哨兵头和哨兵尾
     */
    public DoublyLinkedList() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        //头指针指向尾
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 查找双向链表里面的节点元素
     *
     * @param index
     * @return
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * 根据索引往双向链表插入值
     *
     * @param index
     * @param value
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node node = new Node(prev, value, next);
        prev.next = node;
        next.prev = node;
    }

    /**
     * 往双向链表头部插入值
     *
     * @param value
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     * 工具用来抛出异常的
     *
     * @param index
     * @return IllegalArgumentException
     */
    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index)
        );
    }

    /**
     * 根据索引删除双向链表的节点元素
     * @param index
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if(prev==null){
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        //如果删除的对象是尾哨兵也是不合法的
        if(removed==tail){
            throw illegalIndex(index);
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 删除节点元素头部的元素
     * @return
     */
    public void removeFirst(){
        remove(0);
    }

    /**
     * 向双向链表的尾部添加节点
     * @param value
     */
    public void addLast(int value){
        Node last=tail.prev;
        Node added=new Node(last,value,tail);
        last.next=added;
        tail.prev=added;
    }

    /**
     * 对双向链表最后一个元素进行删除
     */
    public void removeLast(){
        Node removed=tail.prev;
        if(removed==head){
            throw illegalIndex(0);
        }
        Node prev=removed.prev;
        prev.next=tail;
        tail.prev=prev;

    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Integer next() {
                int v=p.value;
                p=p.next;
                return v;
            }
        };
    }
}
