package day01.smartHomeSystem;

public class JD {
    // 这个是家电类的父类，他定义了家电的名字和状态
    private String name;
    private boolean status;
    public JD(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public JD() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus() {
        return status;
    }
    // 返回一个描述家电状态的字符串
    public String toString() {
        return "家电名称：" + name + " 状态：" + (status ? "开启" : "关闭");
    }

    public void press() {
        this.status = !this.status;
    }
}
