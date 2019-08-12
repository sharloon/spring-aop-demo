package stu.hxl.helloword.v2;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public class V2Test {

    public static void main(String[] args) {

        IBatterCake cake = new BaseBatterCake();
        System.out.println(cake.getMsg() + ",总价格：" + cake.getPrice());

        IBatterCake cake1 = new BatterCakeWithEgg(2);
        System.out.println(cake1.getMsg() + ",总价格：" + cake1.getPrice());

        IBatterCake cake2 = new BatterCakeWithSasuage(3);
        System.out.println(cake2.getMsg() + ",总价格：" + cake2.getPrice());

    }

}
