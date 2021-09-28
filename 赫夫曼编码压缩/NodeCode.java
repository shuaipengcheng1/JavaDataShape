package 赫夫曼编码压缩;

import java.util.Comparator;

public class NodeCode implements Comparable {
    boolean flag  =false;
    @Override
    public String toString() {
        return "NodeCode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //        用来描述字符的十进制
    public byte data;
    //        字符在字符串出现的次数 作为树节点的权重
    public int weight;

    public NodeCode Right;
    public NodeCode Left;

    public NodeCode(int weight) {
        this.weight = weight;
    }

    public NodeCode(byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

//    中序遍历
    public void CenterSelect(){
        if (this.Left!=null){
            this.Left.CenterSelect();
        }
        System.out.println(this);
        if(this.Right!=null){
            this.Right.CenterSelect();
        }
    }
    public void CenterSelect(NodeCode nodeCode){

        if (this.Left!=null){
            this.Left.CenterSelect(nodeCode);
            if(flag){
                return;
            }
        }
        if(this.weight+nodeCode.Left.weight==nodeCode.weight){
        nodeCode.Right = this;
        flag=true;

        return;
        }
        if(this.weight+nodeCode.Right.weight==nodeCode.weight){
            nodeCode.Left = this;
            flag=true;

            return;

        }
        if(this.Right!=null){
            if(flag){
                return;
            }
            this.Right.CenterSelect(nodeCode);
        }
    }


    @Override
    public int compareTo(Object o) {
        int compareAge=((NodeCode)o).weight;
        /* 正序排列 */
        return this.weight-compareAge;
    }
}
