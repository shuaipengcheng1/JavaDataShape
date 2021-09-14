package compouted;

import java.util.Arrays;

//计算需求
//如给出一个字符串 String str = "4+5+3+2*1"
//循环遍历出来每一个元素
//如果是数字则压入数字栈 如果是一个符号则压入符号栈
//如果符号栈
//如果为空
// 则直接压入 如果小于or等于就先计算数字栈的数据 然后再压入符号栈(用于对比)
//如果大于原来的符号优先级则直接入栈 最后获取结果
public class Struck {//    数字栈
    private int[] Num = new int[10];
    //     符号栈
    private char[] Str = new char[10];

    //    数字栈的最顶 -1为空
    private int Num_TOP = -1;
    //    字符栈的最顶-1为空
    private int Str_TOP = -1;

    public Struck() {
    }

    //    栈底层设计为数组
//    字符串
    public void Char_Save(char Str) {
//     如果为空直接存入
        if (this.Str_TOP == -1) {
            PUSH(this.Str, Str);
        } else {
//            不为空
//            对比当前栈顶的字符 和 传入的字符的优先级
            char TOP = this.Str[Str_TOP];
//            获取两个的优先级
            int TOP_STR = DuiBi(TOP);
            int STR = DuiBi(Str);
//            如果栈顶的优先级高
            if (TOP_STR > STR) {
//                符号直接入栈
                PUSH(this.Str, Str);
            }
            if (TOP_STR <= STR) {
//                栈顶优先级与下一个小于or等于 把数字弹栈再压栈（计算符号为栈顶符号）
//                循环弹栈
//                    获取符号栈顶符号
                String Fu = FUHao(TOP);
                System.out.println(Fu);
//                计算结果
//                初始值为栈顶
                int SUM = POP();
//                减一

                for (int i = Num_TOP; i > -1; i--) {
                    System.out.println("循环");
                    if (Fu.equals("加")) {
                        System.out.println(SUM);
                        System.out.println(Num_TOP);
                        SUM += POP();
                    }
                    if (Fu.equals("减")) {
                        SUM -= POP();
                    }
                    if (Fu.equals("乘")) {
                        System.out.println("ok");
                        SUM *= POP();
                    }
                    if (Fu.equals("除")) {
                        SUM = POP()/SUM;
                    }

                }
//                将数据重新存入数字栈
                System.out.println(SUM);
                PUSH(this.Num, SUM);
                System.out.println(Str);
//                将下一个符号压入栈
                PUSH(this.Str, Str);
            }


        }
    }

    //    数字
    public void Num_Save(int Num) {
//数字压栈
//        System.out.println(Num);
        PUSH(this.Num, Num);
    }

    //    字符串压栈
    private void PUSH(char[] Str, char data) {
        //       指针自增
        Str_TOP++;
//        压栈
        Str[Str_TOP] = data;

    }

    //    数字压栈
    private void PUSH(int[] Num, int data) {
        Num_TOP++;
        Num[Num_TOP] = data;
    }

    //    数字弹栈
    private int POP() {
        if (Num_TOP > -1) {
            //        获取栈顶数据
            int data = this.Num[Num_TOP];
//      减一
            Num_TOP--;
//      返回
            return data;
        } else {
            throw new RuntimeException("栈空!");
        }
    }


    //    对比优先级 封装为函数
    private int DuiBi(char str) {
        switch (str) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;


        }
        return -1;
    }

    //    判断栈顶符号
    private String FUHao(char str) {
        System.out.println("符号" + str);
        switch (str) {
            case '+':
                return "加";
            case '-':
                return "减";
            case '*':
                return "乘";
            case '/':
                return "除";


        }
        return "未知";
    }

    //    获取总和
    public int PRINT() {
//        如果数字栈中不止一个
        if (Num_TOP != 0) {
            System.out.println(Arrays.toString(Num));
//            弹栈
            int SUM;
            //           获取栈顶符号
            String Fu = this.FUHao(Str[Str_TOP]);
            if(Fu.equals("乘")||Fu.equals("除")){
                SUM =POP();

            }else {
                SUM =0;

            }
            for (int i = Num_TOP; i > -1; i--) {
                System.out.println("循环");
                if (Fu.equals("加")) {
                    System.out.println(SUM);
                    System.out.println(Num_TOP);
                    SUM += POP();
                    System.out.println(SUM);
                }
                if (Fu.equals("减")) {
                    SUM -= POP();
                }
                if (Fu.equals("乘")) {
                    SUM *= POP();
                    System.out.println(SUM);

                }
                if (Fu.equals("除")) {
                    System.out.println("除"+SUM);
//                    System.out.println(POP());
                    SUM = POP()/SUM;
                }

            }
            //                将数据重新存入数字栈
            System.out.println("总和"+SUM);
            PUSH(this.Num, SUM);



        }
        System.out.println(Arrays.toString(this.Num));
//        弹栈
        return POP();
    }
}
