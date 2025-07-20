package day01.smartHomeSystem;

public class Washer extends JD implements Furniture{
    public Washer(String name, boolean status) {
        super(name, status);
    }
    public boolean isOpen = false;
    @Override
    public void press() {
        this.isOpen = !this.isOpen;
    }
    public String getIsOpen() {
        return isOpen ? "开着" : "关着";
    }
}
