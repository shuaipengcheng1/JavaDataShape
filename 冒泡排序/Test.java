package 冒泡排序;

import java.util.Arrays;
public class Test {
    //    冒泡排序
    static int length = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{43,5,23,53,65,23,1};
        length = arr.length-1;
//    开始冒泡
      int[] re=  Bundle(arr);
      System.out.println("结果"+Arrays.toString(re));
    }

    public static int[] Bundle(int[] arr) {
//    冒泡递归的次数为数组的长度

        for (int i = 0; i <length ; i++) {
//            相邻数比较 如果大于就交换位置
            if(arr[i]>arr[i+1]){
               int temp= arr[i+1];
               arr[i+1] = arr[i];
               arr[i] = temp;
            }
        }
//        如果次数大于0
//        递归
        if(length>0){
            length--;
            System.out.println(Arrays.toString(arr));
            Bundle(arr);
        }
        return arr;
    }
}
