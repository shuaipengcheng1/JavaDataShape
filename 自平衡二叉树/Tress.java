package 自平衡二叉树;

public class Tress {
    //    树
    public Node Root;

    //    添加节点
    public void add(Node node) {
        if(Root==null){
            Root=node;
            node.root = node;
            System.out.println("头节点添加成功");
        }else {
            Root.add(node);
        }
    }

//    中序查找
    public void Center(){
        if(Root==null){
            return;
        }else {
            Root.Center();
        }
    }
//    中序寻找元素
    public void CenterSelect(int no){
        if(Root==null){
            return;
        }else {
            Root.CenterSelect(no);
        }
    }

//    删除节点
    public void Del(int no){
        if(Root!=null){
          boolean b=  Root.Del(no);
          if(b){
              //删除头节点
              System.out.println("删除了头节点");

              this.Root =null;
          }
        }else {
            System.out.println("空链表...");
        }
    }
}
