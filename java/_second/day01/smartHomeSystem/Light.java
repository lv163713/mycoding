package day01.smartHomeSystem;

public class Light extends JD implements Furniture{
    public Light(String name, boolean status) {
        super(name, status);
    }
    private boolean isOpen = false;
    public void press(){
        this.isOpen = !this.isOpen;
    }
    public String getIsOpen(){
        return isOpen ? "开启" : "关闭";
    }
}
