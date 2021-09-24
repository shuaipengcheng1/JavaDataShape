package 希尔排序;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 4, 2, 3, 5, 72, 4, 5, 2};

//  实现增量变换 gap==增量
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
//           每一组的元素
            for (int i = gap; i <arr.length ; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
//                    判断每一组的元素
                    if(arr[j]>arr[j+gap]){
                        int temp =0;
                        temp=arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
