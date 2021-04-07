package chapter2.array;

public class MyArrayWithExpansion {
    private int[] array;
    private int size;

    public MyArrayWithExpansion(int capacity){
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
        //如果实际元素达到数组容量下限，则对数组进行扩容
        if(size >= array.length){
            resize();
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
     * 数组扩容
     */
    public void resize(){
        int[] arrayNew = new int[array.length * 2];
        //从旧数复制到新数组
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }

    /**
     * 输出数组
     */
    public void output(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 数组删除元素
     * @param index 删除的位置
     * @return
     * @throws Exception
     */
    public int delete(int index)throws Exception{
        //判断访问下标是否超出范围
        if( index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("超出数组实际元素范围!");
        }
        int deleteElement = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return deleteElement;
    }

    public static void main(String[] args) {
        MyArrayWithExpansion myArray = new MyArrayWithExpansion(4);
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
