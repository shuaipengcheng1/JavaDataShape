 package 链表稀疏数组;

public class Node {
//    要实现单链式稀疏数组
    public Node next;
    public int x;
int data;

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", data=" + data +
                ", y=" + y +
                '}';
    }

    public Node(int x, int y, int data) {
        this.x = x;
        this.y = y;
        this.data=data;
    }

    public  int y;

}
