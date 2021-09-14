package 双链表;

public class Test {
    //    头部
    public Node HEADER = new Node(0, 0, "");

    //    将单链表的操作改为双向链表
    public static void main(String[] args) {
Test test = new Test();
test.add(new Node(1,10,""));
        test.add(new Node(8,10,""));
        test.add(new Node(10,10,""));
        test.add(new Node(12,10,""));

        test.add(new Node(6,10,""));
        System.out.println(test.HEADER.next.next.next.pre.id);
        test.List();

    }

    public void add(Node node) {
//    指针
        Node temp = HEADER;
        while (true) {
            if (temp.next == null) {
//         为空
                temp.next = node;
                node.pre = temp;
                break;
            }
//     大于id
            if (temp.next.id > node.id) {
//                保存原本的下一个
                Node next = temp.next;
//                保存原本下一个的上一个
                Node pre = temp.next.pre;
//                修改下一个
                temp.next = node;
//                修改新增的下一个的上一个
                node.pre = pre;
//                修改新增下一个的下一个
                node.next =next;
//                修改原本下一个的上一个
                next.pre = node;

                break;
            }
            if(temp.next.id==node.id){
                throw new RuntimeException("不能相同id");
            }
            temp=temp.next;
        }

    }
//    删除
    public void Del(int id){
        Node temp = HEADER;
        while (true){
            if(temp.next==null){
                System.out.println("未找到要删除的节点");
                break;
            }
            if(temp.next.id==id){
//                双向链表
                temp.next = temp.next.next;
                temp.next.next.pre = temp.next;
                break;
            }
            temp=temp.next;
        }

    }
//    修改
public void Change(Node node){
    Node temp = HEADER;
    while (true){
        if(temp.next==null){
            System.out.println("未找到要修改的节点");
            break;
        }
        if(temp.next.id==node.id){
//                双向链表
//        先保存要修改的节点的pre next
            Node Pre= temp.next.pre;
            Node Next= temp.next.next;
            temp.next = node;
            temp.next.next.pre = node;
            node.pre =Pre;
            node.next = Next;
            break;

        }
        temp=temp.next;
    }

}
//查询
    public void List(){
        Node temp = HEADER;
        while (true){
            if(temp.next==null){
                System.out.println(temp.id);
                break;
            }
                System.out.println(temp.id);


            temp=temp.next;
        }
    }
}
