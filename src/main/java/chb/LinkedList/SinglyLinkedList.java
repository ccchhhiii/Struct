package chb.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单项链表
 */
public class SinglyLinkedList implements Iterable<Integer> {
    //头节点
    //private Node head = null;
    //哨兵节点 --解决链表为空和index为0的问题
    private Node head=new Node(666,null);

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }


    //节点类
    private static class Node {
        int value; //值
        Node next; //下一个节点的指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //向链表头部添加   头插法
    public void addFirst(int value) {
        //1.链表为空
        //head=new Node(value,null);
        //链表非空
        //head = new Node(value, head);
        insert(0,value);
    }

    //遍历链表
    public void loop(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    //找到链表的最后节点
    private Node findLast() {
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    //添加节点在链表最后面
    public void addLast(int value) {
        Node last = findLast();
        //如果链表是空链表，我们插入的节点就变成第一个
//        if (last == null) {
//            addFirst(value);
//            return;
//        }
        last.next = new Node(value, null);
    }

    //查找某个元素的索引值
    public Node findNode(int index){
        //int i=0;
        //因为哨兵节点的索引位置是-1
        int i=-1;
        for(Node p=head.next;p.next!=null;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;//没找到
    }

    //在得到索引值的基础上获取节点的value值
    public int get(int index) throws IllegalArgumentException{
        Node node =findNode(index);
        if(node==null){
            throw illegalIndex(index);
        }
        return node.value;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index)
        );
    }

    //向索引位置插入值
    public void insert(int index,int value){
        //index==0时直接使用插头法
//        if(index==0) {
//            addFirst(value);
//            return;
//        }
        Node prev=findNode(index-1);//找到我们的上一个节点
        if(prev==null){//找不到
            throw illegalIndex(index);
        }
        prev.next=new Node(value,prev.next);
    }

    //删除第一个节点
    public void removeFirst(){

        if(head==null){
            throw illegalIndex(0);
        }
        head=head.next;
    }

    //根据索引删除节点
    public void remove(int index) {
//        if(index==0){
//            removeFirst();
//            return;
//        }
        Node prev=findNode(index-1);//被删除节点的上一个节点
        if(prev==null){
            throw illegalIndex(index);
        }
        Node removed =prev.next;//需要被删除的节点
        if(removed==null){
            throw illegalIndex(index);
        }
        prev.next=removed.next;//跳过被删除节点指向被删除节点的下一个节点
    }

    //两个方法合起来是递归遍历
    private  void recursion(Node curr){//某个节点要进行的操作
        if(curr==null){
            return;
        }
        System.out.println(curr.value);
        recursion(curr.next);
    }

    public void loop3(){
        recursion(head);
    }
}
