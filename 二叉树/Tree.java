package 二叉树;

//树
public class Tree {
//    头节点
 public TreeNode Root;
 public Tree(TreeNode treeNode){
     this.Root = treeNode;
 }

    public Tree() {

    }

    // 中序
    public  void CenterSelect(){

     if(this.Root!=null){
         this.Root.CenterSelect();
     }
    }
    public void PreSelect(){
//     前序遍历
        if(this.Root!=null){
            this.Root.preSelect();
        }
    }
//    后续
    public void LastSelect(){
     if(this.Root!=null){
         this.Root.LastSelect();
     }
    }


//    前序查找
    public void preFind(int id){
     if(this.Root!=null){
         this.Root.PreFind(id);
     }
    }
//    中序
    public void CenterFind(int id){
        if(this.Root!=null){
            this.Root.CenterFind(id);
        }
    }
//    后续
    public void LastFind(int id){
        if(this.Root!=null){
            this.Root.LastFind(id);
        }
    }

//    删除
    public void Del(int id){
     if(this.Root!=null){
         this.Root.Del(id);
     }
    }
}
