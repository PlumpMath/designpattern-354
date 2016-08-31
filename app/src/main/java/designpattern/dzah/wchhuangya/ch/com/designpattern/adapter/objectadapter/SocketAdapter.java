package designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter;

import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.interfaces.DBSocketInterface;
import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.interfaces.GBSocketInterface;

/**
 * 插座适配器
 * Created by wchya on 16/8/31.
 */
public class SocketAdapter implements DBSocketInterface {

    private GBSocketInterface mGBSocketInterface;

    public SocketAdapter(GBSocketInterface gbSocketInterface) {
        mGBSocketInterface = gbSocketInterface;
    }

    @Override
    public String powerWithTwoRound() {
        return mGBSocketInterface.powerWithThreeFlat();
    }
}
