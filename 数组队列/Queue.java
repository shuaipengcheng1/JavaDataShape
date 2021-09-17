package 数组队列;
//通过数组实现队列
public class Queue {
    int Length = 0;
//    创建一个队列
    int[] queue = new int[Length];
//    队尾指针
    int Queue_End = 0;

    public Queue(int length) {
        Length = length;
        this.queue = new int[length];
        Queue_End=-1;
        Queue_Start=-1;
    }

    //    队首指针
    int Queue_Start = 0;
//    判断是否满了
    public Boolean isFull(){
        if(Queue_End>=Length-1){
            return true;
        }else {
            return false;
        }
    }
//    判断是否为空
    public Boolean isEmpyte(){
        if(Queue_End==Queue_Start){
            return true;
        }else {
            return false;
        }
    }

//添加元素
    public void add(int data){
//        判断是否维满
        if(isFull()){
            throw new RuntimeException("队列已满");
        }else {
//            对尾+1
            Queue_End++;
//            队首+1
            if(Queue_Start==-1){
//                指向最靠前的元素 所以为0
                Queue_Start++;
            }
//            填充数据
            this.queue[Queue_End] = data;
        }
    }
//    移出元素
    public int get(){
        if(isEmpyte()){
            throw new RuntimeException("不能移出空队列元素");
        }else {
//            队头指向头元素

          return queue[Queue_Start];
//
        }
    }

//    查看队列
    public void List(){
        for (int i = 0; i <queue.length ; i++) {
            System.out.println(queue[i]);
        }
    }

}
