package day02.oop;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        Person[] p1 = new Person[3];
        p1[0] = new Person("张三", 18, 180);
        p1[1] = new Person("李四", 19, 170);
        p1[2] = new Person("王五", 20, 160);

        // 按照身高降序来排序
        Arrays.sort(p1, (o1, o2) -> o2.high - o1.high);
    }
}

class Person {
    public String name;
    public int age;
    public int high;

    public Person(String name, int age, int high) {
        this.name = name;
        this.age = age;
        this.high = high;
    }
}