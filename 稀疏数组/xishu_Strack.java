package 稀疏数组;

import java.util.Arrays;

public class xishu_Strack {
    //    用于存储稀疏数组的栈
    int num = 0;

    @Override
    public String toString() {
        return "xishu_Strack{" +
                "xiShu=" + Arrays.toString(xiShu) +
                '}';
    }

    XiShu[] xiShu = new XiShu[num];
    //    栈顶指针
    int Top = -1;

    //    构造函数
    public xishu_Strack(int num) {
        this.num = num;
        this.xiShu = new XiShu[num];

    }

    //压栈
    public void push(XiShu xiShu) {
        Top++;
        this.xiShu[Top] = xiShu;
    }

    //   弹栈
    public void pop() {
        while (Top != 0) {
            xiShu[Top] = null;
            Top--;
        }
    }


}
