package day01.payDome;


public class card {
    private String carId;   //车牌号
    private String phone;
    private String name;
    private double money;   //卡内余额

    public card(String carId, String phone, String name, double money) {
        this.carId = carId;
        this.phone = phone;
        this.name = name;
        this.money = money;
    }
    public card() {
    }
    //预存金额
    public void deposit(double money) {
        this.money += money;
    }
    
    //消费金额
    public void consume(double money) {
        this.money -= money;
    }

    @Override
    public String toString() {
        return "card [carId=" + carId + ", phone=" + phone + ", name=" + name + ", money=" + money + "]";
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public String getCarId() {
        return carId;
    }
    public String getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }

    
}
