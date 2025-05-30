package 项目实战.movie;

import java.util.Scanner;

// 定义为实体类，用于存储数据和增加电影，还有查询电影，删除电影
// 电影的数据包含编号、名称、类型、评分
public class MovieService {
    private Movie[] movies;
    private int index;
    // 构造器
    public MovieService() {
        // 这个电影服务对象存了两个属性，一个是电影的信息，还有一个的电影的数量
        // 这里创建了电影对象，创建100个电影对象，每个电影对象有自己的数学
        // 用数组来保存这些电影对象
        movies = new Movie[100];
        index = 0;
    }

    // 展示菜单
    public void showMenu() {
        // 显示菜单
        System.out.println("1. 添加电影");
        System.out.println("2. 删除电影");
        System.out.println("3. 查询电影");
        System.out.println("4. 显示所有电影");
        System.out.println("5. 退出");
        System.out.println("请选择：");
    }
    /**
    * 添加电影信息
    * 该方法通过用户输入来创建一个新的电影对象，并将其添加到电影数组中
    * 
    * @param sc Scanner对象，用于从控制台获取用户输入
    */
    public void addMovie(Scanner sc) { 
        System.out.println("添加电影的id");
        String id = sc.next();
        System.out.println("请输入电影名称：");
        String name = sc.next();
        System.out.println("请输入电影类型：");
        String type = sc.next();
        System.out.println("请输入电影评分：");
        double rating = sc.nextDouble();
        Movie movie = new Movie(id, name, type, rating);
        movies[index] = movie;
        index++;
        System.out.println("添加成功！");
    }
    /**
     * 根据用户输入的电影编号删除电影
     * 此方法通过要求用户输入电影编号来识别并删除电影从列表中
     * 如果找到匹配的电影编号，它将从数组中移除该电影，并减少电影总数
     * 
     * @param sc Scanner对象，用于从控制台获取用户输入
     */
    public void deleteMovie(Scanner sc) { 
        for (int i = 0; i < index; i++) {
            System.out.println("请输入要删除的电影编号：");
            String id = sc.next();
            // 检查当前电影的编号是否与用户想要删除的电影编号相匹配
            if (movies[i].getId()== id) {
                // 如果找到匹配项，将匹配项之后的所有电影向前移动一位，以覆盖删除的电影
                for (int j = i; j < index - 1; j++) {
                    movies[j] = movies[j + 1];
                }
                index--; // 减少电影总数，因为电影已被删除
                break;
            }
        }
        System.out.println("删除成功！");
    }
    public void getMoviebyName(Scanner sc) {
        System.out.println("请输入要查询的电影名称：");
        String name = sc.next();
        for (int i = 0; i < index; i++) {
            if (movies[i].getName().contains(name)) {
                System.out.println(movies[i]);
                return;
            }
        }
        System.out.println("没有找到该电影！");
    }
    public void showAllMovies() {
        for (int i = 0; i < index; i++) {
            // 只展示所有电影的名称
            System.out.println(movies[i].getName());
        }
        System.out.println("没有更多电影了！");
    }
    // 用编号去查询当个电影的数据
    public Movie getMovieById(Scanner sc) {
        System.out.println("请输入编号：");
        String id = sc.next();
        for (int i = 0; i < index; i++) {
            if (movies[i].getId().equals(id)) {
                return movies[i];
            }
        }
        System.out.println("没有找到编号是" + id + "的电影");
        return null;
    }
}
