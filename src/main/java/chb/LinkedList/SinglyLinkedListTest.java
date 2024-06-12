package chb.LinkedList;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author chihb
 * @create-time 2024/6/8 21:35
 * @description
 */
public class SinglyLinkedListTest {
    @Test
    public void test() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.addFirst(5);
        singlyLinkedList.loop(value -> {
            System.out.println(value);
        });
        System.out.println("==========迭代器=========");
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    @Test
    public void test2() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.addLast(5);

        assertIterableEquals(List.of(1, 2, 3, 4, 5), singlyLinkedList);

        System.out.println(singlyLinkedList.get(3));
        System.out.println("============插入元素的演示==================");

        singlyLinkedList.insert(0, 10);

        singlyLinkedList.loop(element -> {
            System.out.println(element);
        });
    }

    @Test
    public void test3() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);
        singlyLinkedList.addLast(5);
        System.out.println("============删除第一个元素的演示==================");
        singlyLinkedList.removeFirst();
        singlyLinkedList.loop(element -> {
            System.out.println(element);
        });

        System.out.println("============根据索引删除元素的演示==================");
        singlyLinkedList.remove(3);
        singlyLinkedList.loop(element -> {
            System.out.println(element);
        });
    }

    private SinglyLinkedList getLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        return list;
    }

    @Test
    public void test4() {
        SinglyLinkedList list = getLinkedList();
        list.loop3();
    }
}
