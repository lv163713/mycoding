package day01;
public class _001 {
    public static void main(String[] args) {
        //定义一个乱序的数组，调用排序
        int[] arr = {3,5,1,9,2,7,8,4,6};
        bubbleSort(arr);
        printArray(arr);
        System.out.println("-------------");
    }
    //定义一个方法，实现冒泡排序并输出
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //定义一个方法，输出数组的全部内容
    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i = 0;i < arr.length;i++){
            if(i == arr.length - 1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] + ",");
            }
        }
        System.out.print("]");
    }
}
