package designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.stuff;

import android.util.Log;

import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.interfaces.GBSocketInterface;

/**
 * 国标插座
 * Created by wchya on 16/8/31.
 */
public class GBSocket implements GBSocketInterface {
    @Override
    public String powerWithThreeFlat() {
        Log.d("design_pattern", "国标:使用三项扁头插孔供电");
        return "国标插座:使用三项扁头插孔供电";
    }
}
