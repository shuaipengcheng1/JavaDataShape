package 自平衡二叉树;

public class Node {
    public int no;
    public String name;
    public Node Left;
    public Node root;

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public Node Right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //    根据no删除节点

    /*
     *
     *自平衡二叉树  删除元素时 元素如果为子树 那么元素的父元素要链接它的子树
     * */

    public boolean Del(int no) {
//通过中序找出id 左中右

//        左不为空
        if (this.Left != null) {
            if (this.Left.no == no) {
//    删除该节点
//                要删除的节点为叶子节点 直接删除
                if (this.Left.Left == null && this.Left.Right == null) {
                    this.Left = null;

                    System.out.printf("删除了叶子节点");
                    return false;

//                    如果不是叶子节点
                } else if (this.Left.Left != null) {
//                    暂存
                    Node node = this.Left.Left;
//
                    Node node1 = null;
//                    判断是否还有右树
                    if (this.Left.Right != null) {
                        node1 = this.Left.Right;


                    }
                    this.Left = null;

                    this.Left = node;
                    this.Left.Right = node1;
                    System.out.printf("删除了子树节点左为" + this.Left.Left + " 右为 " + this.Left.Right);
                    return false;

                }
                if (this.Left.Right != null) {
                    Node node = this.Left.Right;

                    Node node1 = null;
                    if (this.Left.Left != null) {
                        node1 = this.Left.Left;


                    }
                    this.Left = null;

                    this.Left = node;
                    this.Left.Left = node1;
                    System.out.printf("删除了子树节点左为" + this.Left.Left + " 右为 " + this.Left.Right);
                    return false;

                }
                System.out.println("删除成功");
                return false;
            }
//            左递归
            if (this.Left != null) {
                this.Left.Del(no);

            }
        }
        if (this.no == no) {
//        删除的是头节点
            return true;

        }

        if (this.Right != null) {
            if (this.Right.no == no) {
                if (this.Right.Left == null && this.Right.Right == null) {
                    this.Right = null;

                    System.out.printf("删除了叶子节点");
                    return false;
                } else if (this.Right.Left != null) {
                    Node node = this.Right.Left;
                    Node node1 = null;
                    if (this.Right.Right != null) {
                        node1 = this.Right.Right;


                    }
                    this.Right = null;

                    this.Right = node;
                    this.Right.Right = node1;
                    System.out.printf("删除了子树节点左为" + this.Right.Left + " 右为 " + this.Right.Right);
                    return false;

                }
                if (this.Right.Right != null) {
                    Node node = this.Right.Right;
                    Node node1 = null;
                    if (this.Right.Left != null) {
                        node1 = this.Right.Left;


                    }

                    this.Right = null;

                    this.Right = node;
                    this.Right.Left = node1;
                    System.out.printf("删除了子树节点左为" + this.Right.Left + " 右为 " + this.Right.Right);

                }
//    删除该节点
                System.out.println("删除成功");

                return false;
            }

//            递归
//            右递归
            if (this.Right != null) {
                this.Right.Del(no);

            }
        }
        return  false;
    }

    //    添加节点 左小右大s
    public void add(Node node) {
//         与头节点对比
        if (this.no < node.no) {
//            大于
            this.Radd(node);
        } else {
//小于
            this.Ladd(node);
        }
    }

    public void Radd(Node node) {
        if (this.Right == null) {
            System.out.println("添加成功");
            this.Right = node;
            return;

        }
//        如果右节点大于传入节点的no 则使用该节点调用Ladd函数
        if (this.Right.no > node.no) {
            this.Right.Ladd(node);
            return;
        }

        this.Right.Radd(node);
    }

    public void Ladd(Node node) {

        if (this.Left == null) {
            System.out.println("添加成功");
            this.Left = node;
            return;

        }
        if (this.Left.no < node.no) {
            this.Left.Radd(node);
            return;

        }

        this.Left.Ladd(node);


    }

    public void Center() {
//        中序 左中右
        if (this.Left != null) {

            this.Left.Center();
        }
        System.out.println(this.no);

        if (this.Right != null) {

            this.Right.Center();
        }
    }

    //中序找值
    public void CenterSelect(int id) {
//        中序 左中右
        if (this.Left != null) {
            if (this.Left.no == id) {
                System.out.println("找到了" + this.Left);
                return;
            }
            this.Left.CenterSelect(id);
        }
        if (this.no == id) {
            System.out.println("找到了" + this);
            return;
        }
        if (this.Right != null) {
            if (this.Right.no == id) {
                System.out.println("找到了" + this.Right);
                return;
            }
            this.Right.CenterSelect(id);
        }
    }
}
