package 基数排序;

import java.util.Arrays;

public class Test {

    int We = 0;
    int Last=0;

    public static void main(String[] args) {
//        基数排序的思想
        /*
         * 首先将所有的数的数位同步为最大数位 如 最大值 748 数位为3 则 3 要补位为 003
         * 然后从个位开始排序 再按十位 依次类推 就能获取一个顺序数列
         * */
        Test test = new Test();
        int[] arr = new int[]{53, 542, 3, 63, 14, 214, 154, 748, 616};
//        计算最大位
        int max = test.max(arr);
        test.We = max - 1;
        System.out.println(max);
//        将所有值补位
        System.out.println(Arrays.toString(test.Bu(arr, max)));
//        计算顺序
        test.Jishu(test.Bu(arr, max), max);
    }

    //    判断最大值
    public int max(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
//        计算长度
        return String.valueOf(max).length();
    }

    //    补位
    public String[] Bu(int arr[], int num) {
        String[] strings = new String[arr.length];
//        arr为数组 num为要补的位数
        for (int i = 0; i < arr.length; i++) {
            if (String.valueOf(arr[i]).length() < num) {
//                补位
//                计算差距
                int distencse = num - String.valueOf(arr[i]).length();
                for (int j = 0; j <= distencse; j++) {

                    if (j == 2) {
                        strings[i] = "0" + strings[i];
                    } else {
                        strings[i] = "0" + arr[i];
                    }
                }
            } else {

                strings[i] = "" + arr[i];

            }
        }
        return strings;
    }


    //    排序函数
    public void Jishu(String[] arr, int num) {
        System.out.println("最新的"+Arrays.toString(arr));
        int[] arrs = new int[arr.length];

        //            判断当前位数最大数
        for (int i = 0; i < arr.length; i++) {
//                根据下标获取对应字符
            System.out.print(arr[i].charAt(We));
//            包装到一个数组中
            arrs[i] = (int) arr[i].charAt(We);

        }
        //            判断最大值
            int max = arrs[arrs.length-1];
        int min = arrs[0];
            for (int j = 0; j < arrs.length; j++) {
//                循环 判断最小值 并且移位 左小右大
                if (arrs[j] > max) {

//                    操作原数组
                    String temp1 = arr[arrs.length-1];
                    arr[arrs.length-1] = arr[j];
                    arr[j] = temp1;
                }
                if(arrs[j]<min){
                    String temp1 = arr[0];
                    arr[0] = arr[j];
                    arr[j] = temp1;
                }
            }


        if (We > 0) {

//          位数--

                We--;
                System.out.println();

                System.out.println(Arrays.toString(arr));

                Jishu(arr, num);


        } else {
            return;
        }



    }
}
