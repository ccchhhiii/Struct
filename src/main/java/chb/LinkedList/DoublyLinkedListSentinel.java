package chb.LinkedList;

import java.util.Iterator;

/**
 * @author chihb
 * @create-time 2024/6/9 16:30
 * @description
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    //添加第一个
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    //添加最后一个
    public void addLast(int value) {
        Node b = sentinel;
        Node a=sentinel.prev;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    //删除第一个
    public void removeFirst(){
        Node a=sentinel;
        Node removeNode=sentinel.next;
        if(removeNode==sentinel){
            throw new IllegalArgumentException("非法");
        }
        Node b=removeNode.next;
        a.next=b;
        b.prev=a;
    }

    //删除最后一个
    public void removeLast(){
        Node a=sentinel;
        Node removeNode=a.prev;
        if(removeNode==sentinel){
            throw new IllegalArgumentException("非法");
        }
        Node b=removeNode.prev;
        a.prev=b;
        b.next=a;
    }

    public void removeByValue(int value){
        Node p=findByValue(value);
        if(p==null){
            return;
        }
        Node a=p.prev;
        Node b=p.next;
        a.next=b;
        b.prev=a;
    }


    //跳过值查找节点的位置
    public Node findByValue(int value){
        Node p=sentinel.next;
        while (p!=sentinel){
            if(p.value==value){
                return p;
            }
            p=p.next;
        }
        return null;
    }
}
