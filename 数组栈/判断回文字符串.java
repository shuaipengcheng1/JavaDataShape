package 数组栈;

import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.Arrays;

public class 判断回文字符串 {
//    通过Struck类 判断字符串是否为回文数据

    public static void main(String[] args) {

//        回文字符串
//        aca bcaacb 就是回文 就读取顺序不同 也是同一个字符串
        String str = "bcaacb";
        Struck s = new Struck((str.getBytes(StandardCharsets.UTF_8)).length);
        //            将字符串转为acall码
        byte[] b = (str.getBytes(StandardCharsets.UTF_8));
        byte[] x =new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
//    将值存入
            s.push(b[i]);
        }


//        弹栈 （栈是先进后出）
        for (int i = 0; i < b.length; i++) {
            x[i] = (byte) s.pop();
            System.out.println(Arrays.toString(x));
        }

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(b));

        //        比较先后的数组
        if(Arrays.equals(x, b)){
            System.out.println(str+"该字符串是一个回文数据");
        }else {
            System.out.println("不是回文数据");
        }
    }
}
