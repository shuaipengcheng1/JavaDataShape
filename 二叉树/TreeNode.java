package 二叉树;

public class TreeNode {
    //    该树的底层为链表 该java类为树的节点
    public int no;
    public String name;
    public TreeNode Left;
    public TreeNode Right;

    public TreeNode() {

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", Left=" + Left +
                ", Right=" + Right +
                '}';
    }

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //    前序遍历
    public void preSelect() {
//        中左右
        System.out.println(this);
        if (this.Left != null) {
//            递归
            this.Left.preSelect();
        }
        if (this.Right != null) {
            this.Right.preSelect();
        }
    }

    //    中序遍历
    public void CenterSelect() {
        //        左中右

        if (this.Left != null) {
//            递归
            this.Left.CenterSelect();
        }
        System.out.println(this);
        if (this.Right != null) {
            this.Right.CenterSelect();
        }
    }

    //    后续遍历
    public void LastSelect() {
//        左右中
        if (this.Left != null) {
//            递归
            this.Left.LastSelect();
        }
        if (this.Right != null) {
            this.Right.LastSelect();
        }
        System.out.println(this);

    }

    //    前序查询
    public void PreFind(int id) {
//        中左右
        //                这里的this会因为每一次的递归而不同 因为每一次该函数的调用者都是this.Left or this.Right

        if (this.no == id) {
            System.out.printf("name:%s id: %d", this.name, this.no);
        }
        if (this.Left != null) {
            if (this.Left.no == id) {
                System.out.printf("name:%s id: %d", this.Left.name, this.Left.no);
            } else {
//                不对就递归
                this.Left.PreFind(id);
            }
        }
        if (this.Right != null) {
            if (this.Right.no == id) {
                System.out.printf("name:%s id: %d", this.Right.name, this.Right.no);

            } else {
                //                不对就递归

                this.Right.PreFind(id);

            }
        }

    }

    //    中序查询
    public void CenterFind(int id) {
//        左中右

        if (this.Left != null) {
            if (this.Left.no == id) {
                System.out.printf("name:%s id: %d", this.Left.name, this.Left.no);
            } else {
                this.Left.CenterFind(id);
            }
        }
        if (this.no == id) {
            System.out.printf("name:%s id: %d", this.name, this.no);
        }
        if (this.Right != null) {
            if (this.Right.no == id) {
                System.out.printf("name:%s id: %d", this.Right.name, this.Right.no);

            } else {
                this.Right.CenterFind(id);

            }
        }

    }

    //    后序查询
    public void LastFind(int id) {
//        左中右

        if (this.Left != null) {
            if (this.Left.no == id) {
                System.out.printf("name:%s id: %d", this.Left.name, this.Left.no);
            } else {
                this.Left.CenterFind(id);
            }
        }

        if (this.Right != null) {
            if (this.Right.no == id) {
                System.out.printf("name:%s id: %d", this.Right.name, this.Right.no);

            } else {
                this.Right.CenterFind(id);

            }
        }
        if (this.no == id) {
//
            System.out.printf("name:%s id: %d", this.name, this.no);
        }

    }


    //    删除节点
    public void Del(int no) {
//        根据no删除节点
//        通过前序遍历获取节点 中左右
        //        删除前判断他是一个叶子节点(无Left right) 还是一个子节点(有Left或者Rigth)

        if (this.no == no) {
//            如果当前的节点的右节点或者左节点有值 则为子树节点
            if (this.Right != null || this.Left != null) {
                this.Right = null;
                this.Left = null;
                TreeNode temp = this;
                temp = null;
                System.out.println("删除了一个子树");

            } else {
                //    叶子节点 直接删除
                TreeNode temp = this;
                temp = null;
                System.out.println("删除了一个叶子");

            }
        }
        if (this.Left != null)
//            左节点符合条件
            if (this.Left.no == no) {


                //                如果当前节点的左节点的右节点或者左节点不为空 则为子树
                if (this.Left.Right != null || this.Left.Left != null) {
                    this.Left.Right = null;
                    this.Left.Left = null;
                    TreeNode temp = this;
                    temp = null;
                    this.Left = null;
                    System.out.println("删除了一个子树");
                } else {
                    //    叶子节点 直接删除

//                删除当前节点的左节点指向
                    this.Left = null;

                    TreeNode temp = this;
                    temp = null;
                    System.out.println("删除了一个叶子");

                }
            } else {
//            递归
                this.Left.Del(no);
            }


        if (this.Right != null)
//            右节点符合条件
            if (this.Right.no == no) {

//                如果当前节点的右节点的右节点或者左节点不为空 则为子树
                if (this.Right.Right != null || this.Right.Left != null) {
                    this.Right.Right = null;
                    this.Right.Left = null;
                    TreeNode temp = this;
                    this.Right = null;
                    temp = null;
                    System.out.println("删除了一个子树");

                } else {
                    //    叶子节点 直接删除
//                当前节点的右节点删除
                    this.Right = null;
                    TreeNode temp = this;
                    temp = null;
                    System.out.println("删除了一个叶子");

                }
            } else {
//            递归
                this.Right.Del(no);

            }
    }
}
