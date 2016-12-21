package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 14:42
 */

public class Tie extends Finery {

    @Override
    public String show() {
        return "领带 " + super.show();
    }
}
