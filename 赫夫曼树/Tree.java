package 赫夫曼树;

public class Tree {
    public int[] Tree = new int[20];
    //    当前头节点
    Node Node;
    //    之前的头节点
    Node PreNode;

    public void add(Node node) {
        //        已经有头节点 前一个头节点永远是下一个节点的右节点

        if (PreNode != null) {

            node.Right = PreNode;
//更新
            Node = node;

            PreNode = Node;


        }
        if (Node == null) {
            Node = node;
            node.root = node;

            PreNode = node;
        }

    }


//    中序遍历
    public void CenterSelect(){
//        左中右
        if(Node!=null){
            Node.CenterSelect();
        }
    }
}
