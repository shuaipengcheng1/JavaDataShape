package 快速排序;

import java.util.Arrays;

public class Test {
    //    快速排序 有点像二分法  取一个中值 并且他的右侧要小于它 左侧要大于它

    //    右侧指针
    static int R = 0;
    //    左侧
    static int L = 0;
    //    中值
    static int C = 0;
    static int i = 1;
    static int j = 0;


    public static void main(String[] args) {
        int[] arr = new int[]{321,3214,323,1323,432312,32432};
        int[] re = KP(arr);
        System.out.println(Arrays.toString(re));
    }

    public static int[] KP(int[] arr) {
        R = arr[arr.length - 1];
//        i = 1;
        j = 0;
        L = arr[j];

        C = arr[(int) Math.ceil((arr.length - 1) / 2)];
        System.out.println(C);
        while (true) {
            if (R < C) {
                int temp = R;
                arr[arr.length - i] = arr[(int) Math.ceil((arr.length - 1) / 2)];
                arr[(int) Math.ceil((arr.length - 1) / 2)] = temp;
                i = 1;

                KP(arr);
            }
            if (L > C) {
                if (arr[arr.length - i] < C) {
                    int temp = arr[j];
                    arr[j] = arr[arr.length - i];
                    arr[arr.length - i] = temp;
                    KP(arr);

                } else {

                    int temp = L;
                    arr[j] = arr[(int) Math.ceil((arr.length - 1) / 2)];
                    arr[(int) Math.ceil((arr.length - 1) / 2)] = temp;
                    System.out.println(Arrays.toString(arr));

                    KP(arr);
                }
//System.out.println(C);


            }
            if (R == C || L == C) {
                if (arr.length - i == (int) Math.ceil((arr.length - 1) / 2)) {
                    if (j != (int) Math.ceil((arr.length - 1) / 2)) {
                        j++;
                        L = arr[j];
                        continue;
                    }
                    System.out.println(Arrays.toString(arr));

                    break;

                }
                if (j == (int) Math.ceil((arr.length - 1) / 2)) {
                    if (arr.length - i != (int) Math.ceil((arr.length - 1) / 2)) {
                        i++;
                        R = arr[arr.length - i];
                        continue;
                    }
                    System.out.println(Arrays.toString(arr));

                    break;

                }

//                只是值相等
                j++;
                L = arr[j];

                continue;

            }

            i++;
            j++;
            R = arr[arr.length - i];
            L = arr[j];
        }

//        计算右侧元素
        int R = (int) Math.floor((arr.length - 1) / 2) - 1; //中值为3 01 2 右侧的元素一共有两个
        int L = arr.length - R;
//        有规则数列 中值右侧小 左侧大

//        计算右侧
        int max = arr[R];
        for (int k = 0; k < R; k++) {
            if (arr[k] > max) {
                int temp = max;
                arr[k] = max;

                arr[R] = temp;
            }
        }
//        计算左侧
        int max1 = arr[arr.length - 1];
        for (int i = (int) Math.floor((arr.length - 1) / 2) + 1; i <= L; i++) {
            if (arr[i] > max1) {
                int temp = arr[i];
                arr[i] = max1;
                arr[arr.length - 1] = temp;
                max1 = temp;
            }
        }

        return arr;
    }

}
