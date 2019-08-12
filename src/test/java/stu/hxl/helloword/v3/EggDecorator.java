package stu.hxl.helloword.v3;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public class EggDecorator extends BatterCakeDecorator {

    public EggDecorator(IBatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    public Integer getPrice() {
        return super.getPrice() + 1;
    }
}
