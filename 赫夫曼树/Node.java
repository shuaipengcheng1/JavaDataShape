package 赫夫曼树;

public class Node {
    int no;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    Node Left;
    Node Right;
    Node root;

    public void CenterSelect() {
//        左中右
        if(this.Left!=null){
            this.Left.CenterSelect();
        }
        System.out.println(this);
        if(this.Right!=null){
            this.Right.CenterSelect();
        }
    }
}
