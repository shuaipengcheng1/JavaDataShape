package 赫夫曼树;

import java.util.Arrays;

public class HeFuManTree {

    /*
    *
    *  一个数列通过排序算法从小到大排序
 然后获取最小两位数(分别作为左子树 右子树 相加的权值为结点)
    相加后的结果继续放在数组中排序
    继续获取最小两位树
    直到数组长度==0
    * */
    static int c = 0;
    static Tree tree =new Tree();

    public static void main(String[] args) {
//        创建一个数列
        int[] arr = new int[]{1, 7, 5, 6, 13, 29};
//        System.out.println(Arrays.toString(arr));
//       先排序
        MaoPao(arr);
        System.out.println(Arrays.toString(arr));
//        赫夫曼化
        HeFu(arr);

        //        查看赫夫曼书
        tree.CenterSelect();


    }

    static void MaoPao(int[] arr) {
        c++;
        if (c >= arr.length) {
            c = 0;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
//                    相邻元素比较
            if (i + 1 >= arr.length) {

            } else {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];

                    arr[i + 1] = temp;
                }
            }
        }
        MaoPao(arr);

    }


    //    转赫夫曼树
    public static void HeFu(int arr[]) {
//        获取最小两位数(分别作为左子树 右子树 相加的权值为结点)
//        相加后的结果继续放在数组中排序(递归)
//                继续获取最小两位树
//        直到数组长度==0
        int[] temp = new int[10];
//        获取最小值
        int min_1 = arr[0];
        Node node = new Node(min_1);
        int min_2 = arr[1];
        Node node1 = new Node(min_2);

//        头部
        int min = arr[0] + arr[1];
        Node node2 = new Node(min);
        node2.Left = node;
        node2.Right = node1;
//        添加到树
        tree.add(node2);


//移出最小值 并且将和放入数组中 并排序
        System.arraycopy(arr, 2, temp, 0, arr.length - 2);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                temp[i] = min;
//                裁剪数组
                int[] t = new int[i + 1];
                System.arraycopy(temp, 0, t, 0, i + 1);
//                System.out.println(Arrays.toString(t));
//                排序更新后的数组
                MaoPao(t);
                System.out.println(Arrays.toString(t));
//                递归
                if(t.length==1){
                  return;
                }else {
                    HeFu(t);
                }
//                排序
                break;
            }
        }
//        MaoPao(temp);



    }

}
