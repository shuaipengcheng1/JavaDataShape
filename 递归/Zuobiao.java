package 递归;

public class Zuobiao {
    public Zuobiao() {
    }

    @Override
    public String toString() {
        return "Zuobiao{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Zuobiao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //    坐标
    int x;
    int y;

}
