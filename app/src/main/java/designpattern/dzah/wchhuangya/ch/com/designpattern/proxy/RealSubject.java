package designpattern.dzah.wchhuangya.ch.com.designpattern.proxy;

/**
 * Created by wchya on 2016-12-22 10:15
 */

public class RealSubject implements SeekInterface {

    private String mName;

    public RealSubject(String name) {
        mName = name;
    }

    @Override
    public String givePresents(String name) {
        return mName + "委托代理给" + name + "送礼物";
    }

    @Override
    public String standTreat(String name) {
        return mName + "委托代理给" + name + "请客";
    }

    @Override
    public String giveFlowers(String name) {
        return mName + "委托代理给" + name + "送花";
    }
}
