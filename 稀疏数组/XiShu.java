package 稀疏数组;

public class XiShu {
//    行
    int x;

    public XiShu(int x, int y, int data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    int y;

    @Override
    public String toString() {
        return "XiShu{" +
                "x=" + x +
                ", y=" + y +
                ", data=" + data +
                '}';
    }

    //    值
    int data;
}
