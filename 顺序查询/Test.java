package 顺序查询;

public class Test {
    public static void main(String[] args) {
//        查找9 并返回小标
        int[] arr = new int[]{1,2,3,5,1,9};
       System.out.println(Serch(9,arr));
    }
    static int Serch(int Key,int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==Key){
                return i;
            }

        }
        return -1;
    }
}
