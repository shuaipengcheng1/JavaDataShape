package 哈希表;

public class Test {
    public static void main(String[] args) {
//        创键一个hash表
        StudentHashTable studentHashTable = new StudentHashTable(10);
        studentHashTable.add(new Student("misaka", 12));
        studentHashTable.add(new Student("misaka", 12));
        studentHashTable.add(new Student("misaka", 103));
        studentHashTable.add(new Student("misaka", 103));

        studentHashTable.add(new Student("ka", 23));

        studentHashTable.List();
        System.out.println(studentHashTable.findByid(23).toString()
        );
    }
}
