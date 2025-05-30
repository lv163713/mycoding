package day02;

public class dynamic_arr {
    public static void main(String[] args) {
        // 动态数组
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
