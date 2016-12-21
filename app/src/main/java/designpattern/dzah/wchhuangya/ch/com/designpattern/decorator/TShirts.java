package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 14:35
 */

public class TShirts extends Finery {

    @Override
    public String show() {
        return "大 T 恤 " + super.show();
    }
}
