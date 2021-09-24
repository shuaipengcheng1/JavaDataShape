package 选择排序;

import java.util.Arrays;

public class Test {
    static int[] data;
    static int c = -1;

    //    选择排序 在一个数组中选出最小值 并放在另一个数组末尾 然后在去那个数组中并且再次获取最小值 再放在末尾
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 4, 7, 6, 8, 1};
        data = new int[arr.length];
        XP(arr);

    }

    static void XP(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}
