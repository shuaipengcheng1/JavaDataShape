package 哈希表;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", no=" + no +
                ", next=" + next +
                '}';
    }

    public String name;
    public int no;
    public Student next;

    public Student(String name, int no) {
        this.name = name;
        this.no= no;
    }
}
