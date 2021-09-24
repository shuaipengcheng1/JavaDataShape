package 哈希表;

public class StudentHashTable {
    // 哈希表是一个数组  每一个数组元素 都是一个单向链表
    int size;
    StudentLinkList[] HashTable;

    public StudentHashTable(int size) {
        this.size = size;
        this.HashTable = new StudentLinkList[size];
    }

    // 哈希函数 散列函数 通过该函数算出对应的下标
    public int HashCode(int no) {
//  通过学生的id获取下标
        return no % size;
    }

    // 添加学生
    public void add(Student student) {
//  先获取对应下标的数组元素(链表) 再调用链表的add方法
        int num =HashCode(student.no);
        while (num>=size){
            num--;
        }
        if(num<0){
            num=0;
        }
        if(HashTable[num]==null){
            HashTable[num] = new StudentLinkList();
        }
        HashTable[num].add(student);
    }


    // 查看哈希表的所有元素
    public void List() {
        int i =0;
//        循环哈希表
        for (StudentLinkList item : HashTable
        ) {
//调用每一个的方法输出
            if(item==null){
                item = new StudentLinkList();
            }
            i++;
            item.List(i);

        }
    }
//    查找
    public Student findByid(int id){
//        通过id获取下标
        int num =HashCode(id);
        while (num>=size){
            num--;
        }
        if(num<0){
            num=0;
        }
      return   HashTable[num].find(id);


    }

}
