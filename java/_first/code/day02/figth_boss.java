package day02;

public class figth_boss {
    public static void main(String[] args) {
        //需求：我现在要开发一个简易的斗地主的游戏，要求完成存牌和洗牌两种功能
        saveCard();
        
    }
    //1.一个方法，存斗地主的牌
    public static void saveCard(){
        //创建一个数组，用于存放牌
        String[] cards = new String[54];

        //创建一个数组，用于存放花色
        String[] colors = {"♥","♠","♣","♦"};

        //创建一个数组，用于存放点数
        String[] numbs = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //先遍历点数，在遍历花色
        int index = 0;
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                cards[index++] = colors[j]+numbs[i];
            }
        }
        cards[index++] = "小王";
        cards[index++] = "大王";
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i]+" ");
        }
        System.out.println();
    }

}
