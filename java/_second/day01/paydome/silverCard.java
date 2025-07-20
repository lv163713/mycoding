package day01.payDome;

//金卡重写消费方法，8折优惠
public class silverCard extends card{
    public silverCard(String carId, String phone, String name, double money) {
        super(carId, phone, name, money);
    }

    public silverCard() {
    }

    // 重写消费方法
    @Override
    public void consume(double money) {
        if(money * 0.9 < getMoney()){
            // 更新银卡账户余额
            setMoney(getMoney() - money*0.9);
        }else{
            System.out.println("余额不足，请充值");
            return;
        }
    }
}

