package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 14:40
 */

public class Sneakers extends Finery {

    @Override
    public String show() {
        return "破球鞋 " + super.show();
    }
}
