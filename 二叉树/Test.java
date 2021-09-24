package 二叉树;

public class Test {
    public static void main(String[] args) {
//        创建二叉树
        Tree tree = new Tree();
        TreeNode treeNode = new TreeNode(1,"misaka");
        TreeNode treeNode1 = new TreeNode(0,"misaka");
        TreeNode treeNode2 = new TreeNode(3,"misaka");
        TreeNode treeNode3 = new TreeNode(4,"misaka");
        TreeNode treeNode4 = new TreeNode(8,"misaka");
//        左小右大
        treeNode.Left = treeNode1;
        treeNode.Right = treeNode2;
        treeNode2.Right = treeNode3;
        treeNode3.Right = treeNode4;
//        设置头节点
        tree.Root = treeNode;

//        前序
//        tree.PreSelect();
//        前序查找
//        tree.preFind(4);


//        中序
//        tree.CenterSelect();
//        中序查找
//        tree.CenterFind(4);

//        后续
//tree.LastSelect();
//        tree.LastFind(4);
        tree.CenterSelect();

        tree.Del(8);

        tree.CenterSelect();
    }
}
