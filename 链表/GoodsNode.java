package 链表;

public class GoodsNode {
    public GoodsNode(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //    该类为商品节点
   public int id;
   public String name;
   public Double price;
    public GoodsNode next;
}
