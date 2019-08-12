package stu.hxl.helloword.v1;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg {

    @Override
    protected String getMsg() {
        return super.getMsg() + ", 加一根香肠";
    }

    @Override
    protected Integer getPrice() {
        return super.getPrice() + 2;
    }
}
