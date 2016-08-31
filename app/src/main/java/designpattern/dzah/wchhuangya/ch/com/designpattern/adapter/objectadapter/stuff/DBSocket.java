package designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.stuff;

import android.util.Log;

import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.interfaces.DBSocketInterface;

/**
 * 德国插座
 * Created by wchya on 16/8/31.
 */
public class DBSocket implements DBSocketInterface {
    @Override
    public String powerWithTwoRound() {
        Log.d("design_pattern", "德国插座：使用两项圆头的插孔供电");
        return "德国插座：使用两项圆头的插孔供电";
    }
}
