package chb.DynamicArrays;


import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author chihb
 * @create-time 2024/6/8 16:53
 * @description
 */
public class DynamicArrayTest{
    @Test
    public void test() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(5);
        dynamicArray.addLast(9);
        dynamicArray.addLast(4);
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);

        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }

        dynamicArray.add(2, 10);
        System.out.println("-------------");
        dynamicArray.foreach(element -> {
            System.out.println(element);
        });

        System.out.println("-------------增强for循环的使用之迭代器----------------");
        for (Integer element:dynamicArray){//调用的是hasNext() 和 next()
            System.out.println(element);
        }

        System.out.println("-------------流输出----------------");
        dynamicArray.stream().forEach(element ->{
            System.out.println(element);
        });
        System.out.println("------------删除数组里的元素-----------");
        assertEquals(1,dynamicArray.remove(4));
        assertIterableEquals(List.of(5,9,10,4,2),dynamicArray);
    }
}
