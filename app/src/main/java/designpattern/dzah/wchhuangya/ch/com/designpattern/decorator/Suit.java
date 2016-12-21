package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 14:41
 */

public class Suit extends Finery {

    @Override
    public String show() {
        return "西装 " + super.show();
    }
}
