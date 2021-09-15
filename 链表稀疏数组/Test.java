package 链表稀疏数组;

public class Test {
    //    新建一个二维数组 用于转换为稀疏数组
    int[][] arr = new int[5][5];
    //    总有效数据
    int Sum = 0;
    //头节点
    Node Header; //稀疏数组对应的二维数组有 5行 5列 5个数据

    public static void main(String[] args) {
//     通过链表压缩
//生成数据
        Test test = new Test();
        test.Created();
//        获取有效数据个数 并且生成头节点
        test.GetData();
//        还原链表稀疏数组 成为二维数组
        test.re();


    }

    public void Created() {
//        生成五个
        for (int i = 0; i < 5; i++) {

            //        随机数
            int x = (int) Math.floor(Math.random() * 5);
            int y = (int) Math.floor(Math.random() * 5);
            int data = (int) Math.floor(Math.random() * 100);
            arr[x][y] = data;

        }
    }

    public void GetData() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) {
                    Sum++;
                }
            }
        }
        System.out.println(Sum);
//        生成头节点
        Header = new Node(5, 5, Sum);
//        链接数据
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) {
                    int x = i;
                    int y = j;
                    int data = arr[i][j];
//                    创建节点
                    Node node = new Node(x, y, data);
                    add(node);
                }
            }
        }
    }

    //    添加节点到Header中
    public void add(Node node) {
//        创建指针
        Node temp = Header;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
//
        System.out.println("添加成功" + node);
    }
//    还原稀疏数组
    public void re(){
        System.out.println("-------------------");
//        创建指针
        Node temp = Header;
//        根据头节点的值生成二维数组
        int [][] arr =new int[temp.x][temp.y];
        while (true){
            if(temp.next==null){
//                System.out.println("还原成功" + temp);

//                arr[temp.x][temp.y] = temp.data;
                break;
            }else {
                arr[temp.next.x][temp.next.y] = temp.next.data;
                System.out.println("还原成功" + temp.next);

            }
           temp= temp.next;
        }
    }

}
