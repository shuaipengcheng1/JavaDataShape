package 数组栈;

import java.sql.Array;
import java.util.Arrays;

//通过数组实现的栈
public class ArrayStrck {
    public static void main(String[] args) {


        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.pop();
        Struck.pop();
System.out.println("弹出的值"+        Struck.pop()
);
        Struck.pop();
        Struck.pop();
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);
        Struck.push(10);


    }

}

//数组实现
class Struck {
    static int maxNum=10;
    //    数组
    static int[] arr = new int[maxNum];
    //栈顶指针
    static int TOP = 0;

    public Struck(int maxNums) {
//        最大栈数
        maxNum=maxNums;
        arr =new int[maxNums];
    }

    public Struck() {
    }

    //   弹栈
    public static int pop() {
//        for (int i = 0; i <arr.length ; i++) {
//            if(arr[i]==0){
//                arr[i-1]=0;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(TOP);
        if(TOP==maxNum){
            TOP--;
            System.out.println("减去"+TOP);
        }
        int Value = arr[TOP];
        arr[TOP] = 0;
        if (TOP != -1) {


            TOP--;
            return Value;

        } else {

            throw new RuntimeException("栈空");
        }


    }

    //   压栈
    public static void push(int data) {
//        for (int i = 0; i <arr.length ; i++) {
//            if(arr[i]==0){
//                arr[i]=data;
//                System.out.println(Arrays.toString(arr));
//                return;
//            }
//        }

        if (TOP < maxNum) {
            arr[TOP] = data;
System.out.println(TOP);
            TOP++;

        } else {
            System.out.println("栈满!");
            return;
        }
        System.out.println(Arrays.toString(arr));

    }

}

