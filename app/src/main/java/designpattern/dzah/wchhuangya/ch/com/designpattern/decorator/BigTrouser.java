package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 14:37
 */

public class BigTrouser extends Finery {

    @Override
    public String show() {
        return "跨裤 " + super.show();
    }
}
