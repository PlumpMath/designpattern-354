package designpattern.dzah.wchhuangya.ch.com.designpattern.factory.simplef;

/**
 * 小米手机流水线
 * Created by wchya on 2016-12-19 10:05
 */

public class XiaoMiPhone implements Phone {
    @Override
    public String producePhone() {
        return "生产小米手机";
    }
}
