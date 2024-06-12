package chb.DynamicArrays;

import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0;//逻辑大小
    private int capacity = 8;//容量
    private int[] array = {};//静态数组

    //向新数组添加数据
    public void addLast(int element) {
        //容量检查
        extracted();
//        array[size] = element;
//        size++;
        add(size, element);
    }

    private void extracted() {
        if(size==0){
            array=new int[capacity];
        }else if(size==capacity){
            //进行扩容
            capacity+=capacity>>1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array=newArray;
        }
    }

    //根据索引位置插入元素
    public void add(int index, int element) {
        if (index >= 0 && index < size) {
            //要拷贝的数组，从哪里开始拷贝，拷贝到哪个数组，从数组下标的什么位置赋值，要赋值多少个原来数组的元素个数
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    //test用来查看数组元素的
    public int get(int index) {
        return array[index];
    }

    //遍历数组使用函数式接口
    //Consumer接口和accept可以对元素进行操作如插入，删除，新增，修改，输出
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }
    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() { //有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { //返回当前元素，并移动到下一个元素
                return array[i++];//先返回当前元素，再进行++操作
            }
        };
    }
    //流遍历
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }


    //数组的删除
    public int remove(int index){
        int removed=array[index];
        //如果不是最后一个元素，每什么用无伤雅，加不加if 都行
        if(index<size-1){
            System.arraycopy(array,index+1,array,index,size-index-1);
        }
        size--;
        return removed;
    }
}
