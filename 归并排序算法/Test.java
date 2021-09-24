package 归并排序算法;

public class Test {
//    指针
    static int L =0;
    static int R =0;
    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,7,1,6,3,2};
//        先拆
        for (int i = 0; i <(int)Math.floor(arr.length/2) ; i++) {
//            再拆
            System.out.println(arr[i]);
        }
        for (int i = (int)Math.floor(arr.length/2); i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
//        L =arr[0];
////        分为两个部分
//        R = arr[(int)Math.floor(arr.length/2)];


    }
}
