package stu.hxl.helloword.v3;

/**
 * @author sharloon
 * @date 2019/7/16
 */
public class SausageDecorator extends BatterCakeDecorator {

    public SausageDecorator(IBatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+一根香肠";
    }

    @Override
    public Integer getPrice() {
        return super.getPrice() + 2;
    }
}
