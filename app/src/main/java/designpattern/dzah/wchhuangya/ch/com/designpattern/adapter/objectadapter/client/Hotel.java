package designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.client;

import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.interfaces.DBSocketInterface;

/**
 * 德国旅馆：充当 client 的角色
 * Created by wchya on 16/8/31.
 */
public class Hotel {

    // 德标的插口
    private DBSocketInterface dbSocket;

    public Hotel() {};

    public Hotel(DBSocketInterface dbSocket) {
        this.dbSocket = dbSocket;
    }

    public void setSocket(DBSocketInterface dbSocketInterface) {
        dbSocket = dbSocketInterface;
    }

    /** 旅馆的充电功能 */
    public String charge() {

        // 使用德标插口充电
        return dbSocket.powerWithTwoRound();
    }
}
