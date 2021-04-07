package chapter2.array;

public class GetAndUpdateDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2,5,4,9,7,2};
        //读取元素（根据元素下标读取元素的方式叫做随机读取）
        //输出数组中下标为3的元素
        System.out.println(array[3]);

        //更新元素
        //给数组下标为5的元素赋值
        array[5] = 10;
        //输出数组中下标为5的元素
        System.out.println(array[5]);
    }
}
