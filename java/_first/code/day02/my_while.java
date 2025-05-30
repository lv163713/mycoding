package day02;

public class my_while {
    //需求，调用一个方法，用while循环，我现在有一张无限大的纸，厚度为0.1毫米，我要折叠多少次能达到地球到月亮的高度
    public static void main(String[] args) {
        double h = 0.1;
        int i = 0;
        while (h < 3840000) {
            h = h * 2;
            i++;
        }
        System.out.println(i);
    }
}
