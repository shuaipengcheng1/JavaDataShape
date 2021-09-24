package 哈希表;

public class StudentLinkList {
    Student Head;

    //    添加节点操作
    public void add(Student student) {
//        如果头节点为空
        if (this.Head == null) {
            Head = student;
            System.out.println("添加成功");

        } else {
            Student temp = Head;
            while (temp.next != null) {
//
                System.out.println("添加成功");
                temp = temp.next;
            }
            temp.next = student;
            System.out.println("添加成功");

        }
    }

    //    查询节点 通过no属性
    public Student find(int Key) {
        if (this.Head == null) {
            throw new RuntimeException("该链表为空");
        } else {
            Student temp = Head;
            while (temp.next != null) {
                if (temp.next.no == Key) {
                    return temp.next;
                }
                temp = temp.next;
            }
            throw new RuntimeException("无数据");
        }
    }

    //    获取数据
    public void List(int i) {
        if (this.Head == null) {
        System.out.println("第"+i+"个链表该链表为空");
        } else {

            Student temp = Head;
            while (temp.next != null) {
                System.out.println("第"+i+"个链表的元素名字:" + temp.next.name + "   no:" + temp.next.no);
                temp = temp.next;
            }
            if (temp.next == null) {
                System.out.println("第"+i+"个链表的元素名字:" + temp.name + "   no:" + temp.no);
            }
        }
    }
}
