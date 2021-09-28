package 自平衡二叉树;

public class Test {
    public static void main(String[] args) {
//        创建二叉树
        Tress tress = new Tress();

        tress.add(new Node(43, "misaka"));
        tress.add(new Node(1, "misaka"));
        tress.add(new Node(312, "misaka"));
        tress.add(new Node(1, "misaka"));
        tress.add(new Node(3, "misaka"));
        tress.add(new Node(3, "misaka"));
        tress.add(new Node(423, "misaka"));
        tress.add(new Node(13, "misaka"));

        tress.add(new Node(2, "misaka"));
        tress.Del(13);
        tress.Del(312);
        tress.Del(1);
        tress.Del(1);
//tress.Del(43);
        tress.Center();
//        中序查找
        tress.CenterSelect(312);
    }
}
