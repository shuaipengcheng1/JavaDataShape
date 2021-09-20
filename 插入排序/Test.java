package 插入排序;

import java.util.Arrays;

public class Test {
//    存放插入值
    static int[] da;
//    下标
    static int key = 0;

    public static void main(String[] args) {
        int[] data = new int[]{43,3123,54323,2321,32};
        da = new int[data.length];
        CP(data);

    }

    public static void CP(int[] arr) {
//        递归取值
        if (key == arr.length) {
            return;
        }
//        第一次赋值直接赋值
        if (key == 0) {
            da[key] = arr[key];
            key++;
            CP(arr);

        } else {
            if (arr[key] < da[key - 1]) {
//                循环
                int index = key;
                int ke = key;
                while (true) {
                    if (index == 0) {
                        break;
                    }
//                    判断以前值和传入值
                    if (da[index - 1] > arr[ke]) {
                        int temp = arr[ke];
                        da[index] = da[index - 1];
                        da[index - 1] = temp;
                        System.out.println(Arrays.toString(da));
                    }else {
                        break;
                    }
                    if (da[index - 1] > arr[index]) {
                        break;
                    }


                    index--;


                }
                key++;
                CP(arr);


            } else {

                da[key] = arr[key];
                key++;
                CP(arr);

            }
        }
    }
}
