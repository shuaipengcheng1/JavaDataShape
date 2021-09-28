package 赫夫曼编码压缩;

import 赫夫曼树.Node;

import java.util.*;

public class HeFu {
    static int K = 0;
    static int[] ar = new int[0];
    static Tree tree = new Tree();
    static Map<Byte, String> Ye = new TreeMap<>();
    static StringBuilder stringBuilder = new StringBuilder("");

    public static void main(String[] args) {
//        定义一个要压缩的字符串
        String str = "hello world";
//        转为byte数组
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
//        冒泡排序
        Maopao(bytes);

        System.out.println(Arrays.toString(bytes));

//        获取每一个字符的出现次数并且添加到树中

        List<NodeCode> list = get(bytes);
        for (NodeCode item : list
        ) {
            System.out.println(item);
        }
//        添加到树中

        System.out.println("x" + add(list));
        GetHuff(add(list).Left, "0", stringBuilder);
        GetHuff(add(list).Right, "1", stringBuilder);
        for (Map.Entry<Byte, String> item : Ye.entrySet()
        ) {
            System.out.println(item);
        }
        zip(bytes, Ye);
        System.out.println(add(list).Left.Right.Right);

    }

    static NodeCode add(List<NodeCode> list) {
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        头节点的权重 等于前两个节点的weight属性相加

        while (list.size() > 1) {
            //            排序
            Collections.sort(list);
            NodeCode Left = list.get(0);
            NodeCode Right = list.get(1);
            NodeCode Root = new NodeCode(Left.weight + Right.weight);
            Root.Left = Left;
            Root.Right = Right;
            list.remove(Left);
            list.remove(Right);
            list.add(Root);
        }
        return list.get(0);
    }


    static void Maopao(byte arr[]) {
        K++;
        if (K >= arr.length) {
            K = 0;
            return;
        } else {
//            相连元素对比
            for (int i = 0; i < arr.length; i++) {
                if (i + 1 >= arr.length) {
                    break;
                } else {
                    if (arr[i] > arr[i + 1]) {
                        byte temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }
            Maopao(arr);

        }
    }

    //    获取每一个字符的权重
    public static List get(byte[] bytes) {
        int Times = 1;
//        创建一个集合
        List<NodeCode> list = new ArrayList<>();


        for (int i = 0; i < bytes.length; i++) {

//            获取第i个字符
            int Value = bytes[i];
//            出现次数
            Times = 1;
            for (int j = 0; j < bytes.length; j++) {
                if (j == i) {

                } else {
                    if (Value == bytes[j]) {
                        Times++;
                    }

                }
                if (j == bytes.length - 1) {
                    System.out.println(Times);

                    list.add(new NodeCode(bytes[i], Times));

                }


            }
        }

//        使用一个集合
//        使用sort必须实现接口compareble or compareTo
        Collections.<NodeCode>sort(list);

        return list;


    }

    //    获取赫夫曼值
//    往左 way=0 右=1
//
    public static Map GetHuff(NodeCode nodeCode, String Way, StringBuilder str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(Way);
//      递归  循环
        if (nodeCode != null) {
            if (nodeCode.data == 0) {
                //          向左循环
                GetHuff(nodeCode.Left, "0", stringBuilder);
//向右循环
                GetHuff(nodeCode.Right, "1", stringBuilder);

            } else {
//                找到了叶子节点  key asc码 value 路径
                Ye.put(nodeCode.data, stringBuilder.toString());
            }
        }
        return Ye;
    }

    //    数据压缩
    public static void zip(byte[] arr, Map HuffCode) {
//通过byte数组取值
        StringBuilder stringBuilder = new StringBuilder();
        for (byte item : arr
        ) {
            stringBuilder.append(HuffCode.get(item));

        }
        int Length;
        if (stringBuilder.length() % 8 == 0) {
//            被8整除
            Length = stringBuilder.length() / 8;
        } else {
            Length = stringBuilder.length() / 8 + 1;

        }
        byte[] bytes = new byte[Length];
//        每隔8个字节
        int index=0;
        for (int i = 0; i < stringBuilder.length(); i = i + 8) {
            String str;
            if (i + 8 > stringBuilder.length()) {
                str = stringBuilder.substring(i);
            } else {
                str = stringBuilder.substring(i, i + 8);
            }
//            将str(二进制)转为byte数据(十进制)
            byte b = (byte) Integer.parseInt(str,2);
            bytes[index] = b;
            index++;

        }
        System.out.println(stringBuilder.toString());
        System.out.println(Arrays.toString(bytes));
        System.out.println((float) (arr.length- bytes.length)/arr.length);
    }
}
