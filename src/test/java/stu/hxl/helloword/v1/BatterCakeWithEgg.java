package stu.hxl.helloword.v1;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public class BatterCakeWithEgg extends BatterCake {

    @Override
    protected String getMsg() {
        return super.getMsg() + ", 加一个鸡蛋";
    }

    @Override
    protected Integer getPrice() {
        return super.getPrice() + 1;
    }
}
