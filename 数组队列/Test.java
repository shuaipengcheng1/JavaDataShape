package 数组队列;

public class Test {
    public static void main(String[] args) {
        Queue queue =new Queue(10);
        System.out.println(queue.isEmpyte());
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(90);
System.out.println( "队头"+queue.get());
        queue.List();
    }
}
