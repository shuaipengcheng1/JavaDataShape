package 二分查找法;

import java.util.Arrays;

public class Test {
    //    二分查找必须是有序数列
    static int L = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{3, 21, 1, 4, 42, 6};   // 第一次冒泡  3,1,4,21,6,42   第二次 1,3,4,6,21,42
//    冒泡次数等于数组长度
        L = arr.length;

//    通过冒泡排序
        MP(arr);
//    二分法查找21
        System.out.println(Arrays.toString(arr));

        System.out.println(Serch(arr, 1));

    }

    static void MP(int[] arr) {
        if (L == 0) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        L--;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                int temp = 0;
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

            }
        }
        MP(arr);
    }

    static int Serch(int[] arr, int target) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
//        算出平均索引
            int mid = (min + max) / 2;
            if (arr[mid] == target) {
                System.out.println(mid);
                return mid;
            }
            if (arr[mid] < target) {
                min = mid + 1;
            }
            if (arr[mid] > target) {
                max = mid - 1;
            }
        }
        return -1;

    }
}
