package chapter2.array;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity){
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     * @param index 插入的位置
     * @param element 插入的元素
     */
    public void insert(int index, int element)throws Exception{
        //判断访问下标是否超出范围
        if( index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围!");
        }
        //从右向左循环，将元素逐个向右挪1位
        for (int i = size-1; i >= index ; i--) {
            array[i+1] = array[i];
        }
        //腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     * 输出数组
     */
    public void output(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        try {
            myArray.insert(0,3);
            myArray.insert(1,7);
            myArray.insert(2,9);
            myArray.insert(3,5);
            myArray.insert(1,6);
            myArray.output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
