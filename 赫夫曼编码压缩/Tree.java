package 赫夫曼编码压缩;

public class Tree {
    NodeCode Root;  //头节点
    NodeCode PreNode; //之前的头结点

    public void add(NodeCode nodeCode) {
        if (PreNode != null) {
//            将右节点赋值

//            nodeCode.Right = PreNode;
////更新
//           Root= nodeCode;
//            PreNode =Root;

            if (PreNode.weight + nodeCode.Left.weight == nodeCode.weight) {
                nodeCode.Right = PreNode;
////更新
                Root = nodeCode;
                PreNode = Root;
                return;
            }
            if (PreNode.weight + nodeCode.Right.weight == nodeCode.weight) {
                nodeCode.Left = PreNode;
////更新
                Root = nodeCode;
                PreNode = Root;
                return;
            }
//            中序遍历查找可以插入的地方
            PreNode.CenterSelect(nodeCode);
            Root =  nodeCode;

            System.out.println("-x-----------------------");

            Center();
            System.out.println("-x-----------------------");




        }
        if (Root == null) {
            Root = nodeCode;
            PreNode = nodeCode;
        }
    }
    public void Center(){
        if(Root!=null){
            Root.CenterSelect();
        }
    }
}
