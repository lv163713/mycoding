package 项目实战.movie;

import java.util.Scanner;
// 需求：电影管理系统
// 三个java代码，一个main类，一个用于电影的查增删改类，一个是电影类，用来存放电影信息
// 这个是mian函数，用于用户和电影进行交互，使用while循环
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        // 创建一个电影服务的对象
        // 这个电影服务对象存了两个属性，一个是电影的信息，还有一个的电影的数量
        MovieService service = new MovieService();      
        while (true) {
            service.showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: service.addMovie(sc); break;
                case 2: service.deleteMovie(sc); break;
                case 3: 
                        // 让用户选择一种方法，我们提供两种查询方法，一种id，一种Name
                        System.out.println("1. 通过name查询");
                        System.out.println("2. 通过id查询");
                        System.out.println("请选择：");
                        int choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1: service.getMoviebyName(sc); break;
                            case 2: service.getMovieById(sc); break;
                        }
                        break;
                case 4: service.showAllMovies(); break;
                case 5:
                    System.out.println("欢迎下次再来");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
