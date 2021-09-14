package 双链表;

//节点
public class Node {
    public int id;
    private int price;



    public Node(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    private String name;
//   下一个
    public Node next;
//    上一个
    public Node pre;

}
