package 递归;

public class MiGong {
    //        获取终点坐标 通过稀疏数组
    Zuobiao Zhongdian = new Zuobiao();
    //        获取小球坐标
    Zuobiao XiaoQiu = new Zuobiao();
    //    迷宫问题
    int step=0;
//创建迷宫 随机大小的迷宫
    int[][] map = new int[7][8];
    int ball = 3;

    //设置边墙的方法 值1为的数组元素为墙 0为可以行走的区域 3为球 4为终点
    public void setWall(int[][] map) {
        int x = map.length;//`行
        int y = map[0].length;// 列(每一个元素的长度)
        int j = 0;

//      设置边框 最顶部 最底部
        for (int i = 0; i < y; i++) {
            map[0][i] = 1;
            map[x - 1][i] = 1;
        }
//        设置第一列为1 最后一列也为1
        for (int i = 0; i < x; i++) {
            map[i][0] = 1;
            map[i][y - 1] = 1;
        }
//        取行(x)中间值 并添加两堵墙
        int avg = (int) Math.floor(x / 2);

//        在这行添加
        for (int i = 0; i < 2; i++) {
            map[avg][i] = 1;
        }
//        生成终点在右下角
        map[x - 2][y - 2] = 4;


//        生成小球到中心点
//        计算中心点
        int x_center = (int) Math.floor(x / 2);
        int y_center = (int) Math.floor(y / 2);
        if (map[x_center][y_center] == 1) {
//            如果为墙判断左右两侧
            if (map[x_center][y_center + 1] != 1) {
                map[x_center][y_center + 1] = 3;
            }
        } else {
            map[x_center][y_center] = 3;
        }
//        输出
        System.out.println("\n原样");


        //        输出
        for (int i = 0; i < x; i++) {
            System.out.println();
            for (int k = 0; k < y; k++) {
                System.out.print(map[i][k]+" ");

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("值1为墙 0为可以行走的区域 3为球 4为终点 9为行走路线");
        MiGong miGong = new MiGong();
//        创建墙体函数 并且生成小球
        miGong.setWall(miGong.map);

        miGong.move(miGong.map);

    }

    //    移动的代码
    public void move(int[][] map) {
        int x = map.length;
        int y = map[0].length;

        for (int i = 0; i < x - 1; i++) {
            for (int j = 0; j < y - 1; j++) {
                if (map[i][j] == 3) {
//    小球
                    XiaoQiu.x = i;
                    XiaoQiu.y = j;
                }
                if (map[i][j] == 4) {
//    终点
                    Zhongdian.x = i;
                    Zhongdian.y = j;
                }
            }
        }
//        System.out.println("\n" + XiaoQiu);
//        System.out.println(Zhongdian);

//        调用move
        isMove(XiaoQiu);
    }

    //    递归函数   每一次传入一次更新的坐标
    public void isMove(Zuobiao zuobiao) {
        int x = map.length;
        int y = map[0].length;

        if (zuobiao.y == Zhongdian.y && zuobiao.x == Zhongdian.x) {
            System.out.println();



            System.out.println("结束-----------------");
            System.out.println(Zhongdian);
            System.out.println(zuobiao);
            map[zuobiao.x][zuobiao.y]=3;


            //        输出
            for (int i = 0; i < x; i++) {
                System.out.println();
                for (int k = 0; k < y; k++) {
                    System.out.print(map[i][k]+" ");

                }
            }
        } else {

//            如果x轴不相等 相等就不移动x
            if (zuobiao.x != Zhongdian.x) {
//判断下一个或者上一个是否为墙
                if (map[zuobiao.x + 1][zuobiao.y] != 1&&map[zuobiao.x - 1][zuobiao.y] != 1) {
//              判断是大于 还是小于 大于++ 小于--
                    if (Zhongdian.x > zuobiao.x) {
//                把原本位置换为0 下一个位置换为三
                        map[zuobiao.x][zuobiao.y] = 9;
//                        System.out.println(zuobiao.x);
                        zuobiao.x++;
//自增
                        map[zuobiao.x][zuobiao.y] = 3;
//                        System.out.println(zuobiao.x);

//                    更新zuobiao对象
//                        System.out.println("更新了x"+zuobiao);
                        //            传入更新后的坐标对象
                        step++;
                        System.out.println("\n--------"+step+"步");
                        //        输出
                        for (int i = 0; i < x; i++) {
                            System.out.println();
                            for (int k = 0; k < y; k++) {
                                System.out.print(map[i][k]+" ");

                            }
                        }
                    }else {
//                                        把原本位置换为0 上一个位置换为三
                        map[zuobiao.x][zuobiao.y] = 9;
                        zuobiao.x--;

//自减
                        map[zuobiao.x][zuobiao.y] = 3;


//                    更新zuobiao对象
//                        System.out.println("更新了x"+zuobiao);
                        //            传入更新后的坐标对象
                        step++;
                        System.out.println("\n--------"+step+"步");
                        //        输出
                        for (int i = 0; i < x; i++) {
                            System.out.println();
                            for (int k = 0; k < y; k++) {
                                System.out.print(map[i][k]+" ");

                            }
                        }
                    }
                }else {
                    System.out.println("x即将出墙");
                }
            }
            //            如果y轴不相等 相等就不移动y
            if (zuobiao.y != Zhongdian.y) {
//判断下一个是否为强
                if(map[zuobiao.x][zuobiao.y++]!=1&&map[zuobiao.x][zuobiao.y--]!=1){
//                    判断大于还是小于
                    if(Zhongdian.y> zuobiao.y){
//移动
                        map[zuobiao.x][zuobiao.y]=9;
                        zuobiao.y++;
                        map[zuobiao.x][zuobiao.y]=3;

//            传入更新后的坐标对象
                        step++;
                        System.out.println("\n--------"+step+"步");
                        //        输出
                        for (int i = 0; i < x; i++) {
                            System.out.println();
                            for (int k = 0; k < y; k++) {
                                System.out.print(map[i][k]+" ");

                            }
                        }
                    }else {
                        map[zuobiao.x][zuobiao.y]=9;
zuobiao.y--;
                        map[zuobiao.x][zuobiao.y]=3;
//            传入更新后的坐标对象
                        step++;
                        System.out.println("\n--------"+step+"步");
                        //        输出
                        for (int i = 0; i < x; i++) {
                            System.out.println();
                            for (int k = 0; k < y; k++) {
                                System.out.print(map[i][k]+" ");

                            }
                        }

                    }
                    System.out.println("y更新了"+zuobiao);
                }else {
                    System.out.println("y即将出墙");
                }
            }


            isMove(zuobiao);
        }
    }
}
