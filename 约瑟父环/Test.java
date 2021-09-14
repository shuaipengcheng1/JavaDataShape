package 约瑟父环;

public class Test {
    /*
    实现单向环形链表
    环形 头尾相连
    猜想
     使用Header指针 指向头节点的节点
     使用Last指针 指向最后一个节点

    * */

    //    头节点
    Boy boy1 = null;

    public Boy HEADER = new Boy(1);

    //    尾部指针
    public Boy Last = HEADER;
    //    链表长度
    public int Length = 1;
    //第一个
    public Boy First = null;

    public static void main(String[] args) {
        Test test = new Test();
//        test.add(new Boy(1));
        test.add(new Boy(2));

        test.add(new Boy(3));
        test.add(new Boy(4));

        test.add(new Boy(5));
//        System.out.println(test.HEADER.next.next.next.next.id);
        test.Print();
//        System.out.println(test.Length);
//调用约瑟夫环
        test.YueSeFu(1, 2, test.Length);
    }

    public void add(Boy boy) {
//        添加一个节点 每一次添加的节点都一定是最后一个节点
//       尾部节点next要为头部 之前的尾部节点的next要为新尾部节点
        //    头部指针
        Boy Head = HEADER;


//             获取到了尾部
        if (Head.next == null) {
//            第一次尾部 也就是第一个儿子
            First = boy;
            Head.next = boy;
        }
//        新的尾部 next为头节点
        boy.next = Head;
//        之前的尾部的下一个为新尾部
        Last.next = boy;
//        更新新的尾部
        Last = boy;
//        更新长度
        Length++;


    }

    //    打印环形链表
    public void Print() {
        Boy temp = HEADER;
        while (true) {
//            循环到头部是 停止循环
            if (temp.next == HEADER) {
                System.out.println(temp.id);
                break;
            }
            System.out.println(temp.id);
            temp = temp.next;
        }
    }

//    约瑟夫出环问题
//    startNo 起始位置
//    CountNum 出列次数
//    Length 链表长度

//    设编号1，2...的人围坐一圈 约定下标为id1的人开始报数
//    假设报两次 1 2 之后 数到2的人出列 然后出列后的下一个 继续报数
//    直到所有人出列

    public void YueSeFu(int startNo, int CountNum, int Length) {
//        先到达起始id位置
//        定义指针
        if (Length == 0) {
           System.exit(0);
        }
        Boy Point = HEADER;
        while (true) {

            if (Point.next == null) {
                throw new RuntimeException("没有该id的用户");

            }
            if (Point.next.id == startNo) {
//                找到了id
//                开始数数
//                定义数数次数
//                如果为第一个
                if (Point.next == First) {
//                    定义指针 指向上一层
                    boy1 = Point;
//                    调用数数函数
                    Count(CountNum, 1, Point);

                } else {
//                    不是第一个儿子
//                    定义指针指向第一个儿子的next
                    boy1 = Point.next;
//                    执行函数
                    Count(CountNum, 1, Point.next);

                }
                break;

            }

            Point = Point.next;
        }

    }
//数数函数
    private void Count(int countNum, int start, Boy boy) {
        if (Length == 0) {
            System.exit(0);
        }
//        数数方法
        int Start_id;
//        递归
        if (start < countNum) {
            start++;

            Count(countNum, start, boy.next);

        }
        if (start == countNum) {
//            将其出列
//            start=1;
//            将其删除
            System.out.println("出列的id" + boy.id);
            Start_id = boy.next.id;
            boy1.next = boy.next;

//            递归\
            YueSeFu(Start_id, 2, Length--);
        }
    }
}
