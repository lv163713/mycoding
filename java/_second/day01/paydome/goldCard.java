package day01.payDome;

public class goldCard extends card{
    public goldCard(String carId, String phone, String name, double money) {
        super(carId, phone, name, money);
    }

    public goldCard() {
    }

    @Override
    public void consume(double money) {
        System.out.println("使用金卡支付,当前消费" + money);
        System.out.println("优惠后的价格为" + money*0.8);
        if(money * 0.8 < getMoney()){
            // 更新金卡账户余额
            setMoney(getMoney() - money*0.8);
            // 消费大于200打印洗车票
            if(money * 0.8 >= 200){
                System.out.println("打印洗车票");
            }else{
                System.out.println("消费金额不足，不打印洗车票");
            }
        }else{
            System.out.println("余额不足，请充值");
            return;
        }
    }

    public void printTicket(){
        System.out.println("洗车票");
    }
}
