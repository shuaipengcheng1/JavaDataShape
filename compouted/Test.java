package compouted;

public class Test {
    //    测试类
    public static void main(String[] args) {
        String str = "2+8*2/2";
//    创建栈
        Struck s = new Struck();

        for (int i = 0; i < str.length(); i++) {
            if (Character.getNumericValue(str.charAt(i)) != -1) {
//            数字
                int num = Character.getNumericValue(str.charAt(i));
//            压数字栈
                s.Num_Save(num);
            } else {
                char c = str.charAt(i);
                s.Char_Save(c);

            }
        }
       System.out.println(str+"最后结果"+ s.PRINT());
    }
}
