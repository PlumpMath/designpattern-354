package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 15:13
 */

public class ConcretePerson implements Person {

    private String mName;

    public ConcretePerson(String name) {
        mName = name;
    }

    @Override
    public String show() {
        return "装扮的" + mName;
    }
}
