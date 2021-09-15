package 稀疏数组;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    //    稀疏数组
//    先创建一个二维数组
//    5X5大小
    public int[][] DoubleArray = new int[5][5];
    //    有效数据总数
    public int Sum = 0;
    //    稀疏数组
    public xishu_Strack xishu_strack = new xishu_Strack(1);


    //    放一些有效的数据xishu_strack
//    随机生成5个有效数据 在随机的位子
    public static void main(String[] args) {
        Test test = new Test();
      test.  Sum++;
      test.xishu_strack.push(new XiShu(5,5, test.Sum));

//填充值
        test.CreateItem();
//压缩
        test.GetXiShu();
//        还原
        test.Re();

    }

    //随机生成函数
    public void CreateItem() {
        for (int i = 0; i < 5; i++) {
            //    生成x
            int x = (int) Math.floor(Math.random() * 4);
//        生成y
            int y = (int) Math.floor(Math.random() * 4);
//        生成随机值
            int item = (int) Math.floor(Math.random() * 100);
//            System.out.println(x);
//            System.out.println(y);
//            System.out.println(item);

//            填充值
            DoubleArray[x][y] = item;
        }
    }

    //    生成稀疏数组
    public void GetXiShu() {
//    x轴
        for (int x = 0; x < 5; x++) {
//          y轴
            for (int y = 0; y < 5; y++) {
                if (DoubleArray[x][y] != 0) {
//                    值不为0
                    Sum++;
//                    将xy的信息输出
                    System.out.println("x" + x + "y" + y + "num" + DoubleArray[x][y]);
//                    将其压栈

                    if (xishu_strack.xiShu.length < Sum) {
//                        扩容
//                        创建一个Sum长度的数组
                        XiShu[] xiShu = new XiShu[Sum];
//                        赋值到新数组
                        System.arraycopy(xishu_strack.xiShu, 0, xiShu, 0, xishu_strack.xiShu.length);
//                       将新数组赋值给对象
                        xishu_strack.xiShu = xiShu;
                    }
                    XiShu xiShu = new XiShu(x, y, DoubleArray[x][y]);
                    xishu_strack.push(xiShu);
                }
                if (x == 4 && y == 4) {
//稀疏数组
                    for (int i = 0; i < xishu_strack.xiShu.length; i++) {
                        System.out.println(xishu_strack.xiShu[i]);
                    }
                }

            }
        }


    }

//    根据稀疏数组生成二维数组
    public void Re(){
        System.out.println("---------------------");
//        暂存稀疏数组
     XiShu[] xiShus=   xishu_strack.xiShu;
//     生成原数组
        int[][] Re = new int[xiShus[0].x][xiShus[0].y];
//        通过循环还原数组
        for (int i = 1; i <xiShus.length ; i++) {
            System.out.println(xiShus[i]);
        }

//        还原成功
    }

}
