package stu.hxl.helloword.v1;

/**
 * @author sharloon
 * @date 2019/7/15
 */
public class MainTest {
    public static void main(String[] args) {

        BatterCake cake = new BatterCake();
        System.out.println(cake.getMsg() + ",总价格：" + cake.getPrice());

        BatterCake cakeWithEgg = new BatterCakeWithEgg();
        System.out.println(cakeWithEgg.getMsg() + ",总价格：" + cakeWithEgg.getPrice());

        BatterCake withEggAndSausage = new BatterCakeWithEggAndSausage();
        System.out.println(withEggAndSausage.getMsg() + ",总价格：" + withEggAndSausage.getPrice());

    }

}

