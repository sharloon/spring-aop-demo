package stu.hxl.helloword.v3;

import org.springframework.context.annotation.Configuration;

/**
 * @author sharloon
 * @date 2019/7/16
 */
@Configuration
public class TestV3 {

    public static void main(String[] args) {

        //基础套餐，只有一个煎饼
        IBatterCake cake = new BaseBatterCake();
        System.out.println(cake.getMsg() + ",总价格：" + cake.getPrice());

        //加一个鸡蛋
        cake = new EggDecorator(cake);
        System.out.println(cake.getMsg() + ",总价格：" + cake.getPrice());

        //加一根香肠
        cake = new SausageDecorator(cake);
        System.out.println(cake.getMsg() + ",总价格：" + cake.getPrice());

        //再加一个鸡蛋
        cake = new EggDecorator(cake);
        System.out.println(cake.getMsg() + ",总价格：" + cake.getPrice());

        //再加一个鸡蛋
        cake = new EggDecorator(cake);
        System.out.println(cake.getMsg() + ",总价格：" + cake.getPrice());

        String[] s = new String[] {"1","2","3"};

    }
}
