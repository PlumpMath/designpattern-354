package designpattern.dzah.wchhuangya.ch.com.designpattern.factory.simplef;

/**
 * 三星手机流水线
 * Created by wchya on 2016-12-19 10:06
 */

public class SamSungPhone implements Phone {
    @Override
    public String producePhone() {
        return "生产三星手机";
    }
}
