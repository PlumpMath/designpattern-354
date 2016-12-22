package designpattern.dzah.wchhuangya.ch.com.designpattern.proxy;

/**
 * Created by wchya on 2016-12-22 10:14
 */

public class Proxy implements SeekInterface {

    private RealSubject mRealSubject;

    public Proxy(String realSubjectName) {
        mRealSubject = new RealSubject(realSubjectName);
    }

    @Override
    public String givePresents(String name) {
        return mRealSubject.givePresents(name);
    }

    @Override
    public String standTreat(String name) {
        return mRealSubject.standTreat(name);
    }

    @Override
    public String giveFlowers(String name) {
        return mRealSubject.giveFlowers(name);
    }
}
