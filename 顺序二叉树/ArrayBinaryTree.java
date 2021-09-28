package 顺序二叉树;

public class ArrayBinaryTree {
//    顺序二叉树是基于数组的
    public int[] arr;
    public  ArrayBinaryTree(int[] arr){
        this.arr = arr;
        /*
        *              图例  数字为下标
              0  (root)
          1         2
       3    4     5   6     --  自上而下 自左向右进行存储
        * */
    }
/*
* 公式
*  第n个元素的左节点为  2*n+1
 第n个元素的右子节点为2*n+2
第n个元素的父节点为 (n-1)/2
* */
//    前序遍历 根据num查询
    public void PreSelect(int num){
//        中左右
//        判断要遍历的数组是否为空
        if(this.arr==null||this.arr.length==0){
            System.out.println("数组为空");
        }else {
//            向左递归
           if((num*2+1)<arr.length){
               PreSelect((num*2+1));
           }
//           向右递归
            if((num*2+2)<arr.length){
                PreSelect((num*2+2));
            }
        }
    }
}
