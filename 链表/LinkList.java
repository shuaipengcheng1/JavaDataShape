package 链表;

public class LinkList {
    //    头节点
    GoodsNode HEADER = new GoodsNode(0, "", 0.0);

    public static void main(String[] args) {
//        需求
//        加入新的节点id必须从小到大排序
        LinkList linkList = new LinkList();
        linkList.add(new GoodsNode(1, "", 0.0));
        linkList.add(new GoodsNode(6, "", 0.0));
        linkList.add(new GoodsNode(3, "", 0.0));
        linkList.add(new GoodsNode(4, "", 0.0));
        linkList.add(new GoodsNode(7, "", 0.0));
//         修改
//        System.out.println(linkList.HEADER.next.next.next.id);
        linkList.Change(new GoodsNode(4, "misaka", 10.0));
        linkList.Change(new GoodsNode(5, "misaka", 10.0));
        linkList.Del(3);
        linkList.Del(3);

        linkList.PRINT();
    }

    public void add(GoodsNode goodsNode) {
//        递归所有的next 每一次比较如果
//        定义一个临时指针
        GoodsNode temp = HEADER;
//        标识是否为大于
        Boolean Flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > goodsNode.id) {
                Flag = true;
                break;
            }
            if (temp.next.id == goodsNode.id) {
                throw new RuntimeException("重复id");
            }
            temp = temp.next;
        }
        if (Flag) {
//            大于的情况换位处理
            GoodsNode Big_Id = temp.next;
            temp.next = goodsNode;
            goodsNode.next = Big_Id;

        } else {
//            next为空
            temp.next = goodsNode;

        }

    }


    //    打印链表的方法
    public void PRINT() {
        GoodsNode temp = HEADER;

        while (temp.next != null) {
//           输出id
            System.out.println(temp.id + "" + temp.name + "" + temp.price);
            temp = temp.next;
        }
    }

    //    修改
    public void Change(GoodsNode goodsNode) {
        GoodsNode temp = HEADER;
        GoodsNode goodsNode1 = null;
        while (temp.next != null) {
//            判断id是否一样
            if (temp.next.id == goodsNode.id) {
//                替换
                if (temp.next.next != null) {
                    goodsNode1 = temp.next.next;
                }
                if (goodsNode1 != null) {
                    goodsNode.next = goodsNode1;
                }
                temp.next = goodsNode;
                break;
            } else {
//                不一样 继续循环
                temp = temp.next;
            }
        }
        System.out.println("未找到节点!!");
    }

    //    删除
    public void Del(int id) {
        GoodsNode temp = HEADER;
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到要删除的节点");
                break;
            }
            if (temp.next.id == id) {
//                删除
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }
}
