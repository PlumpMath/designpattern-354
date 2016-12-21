package designpattern.dzah.wchhuangya.ch.com.designpattern.decorator;

/**
 * Created by wchya on 2016-12-21 14:32
 */

public class Finery implements Person {

    protected Person mPerson;

    public void setComponent(Person person) {
        mPerson = person;
    }

    @Override
    public String show() {
        return mPerson.show();
    }
}
