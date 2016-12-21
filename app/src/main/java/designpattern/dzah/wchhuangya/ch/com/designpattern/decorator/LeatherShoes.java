package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 14:44
 */

public class LeatherShoes extends Finery {

    @Override
    public String show() {
        return "皮鞋 " + super.show();
    }
}
