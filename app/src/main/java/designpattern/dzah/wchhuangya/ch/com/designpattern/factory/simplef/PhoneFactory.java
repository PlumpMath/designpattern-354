package designpattern.dzah.wchhuangya.ch.com.designpattern.factory.simplef;

/**
 * 手机代工厂
 * Created by wchya on 2016-12-19 10:07
 */

public class PhoneFactory {

    public static String factory(String type) {
        if ("xiaomi".equals(type)) {
            return new XiaoMiPhone().producePhone();
        } else if ("samsung".equals(type)) {
            return new SamSungPhone().producePhone();
        } else {
            return "手机代工厂不能生产该类型的手机！";
        }
    }
}
