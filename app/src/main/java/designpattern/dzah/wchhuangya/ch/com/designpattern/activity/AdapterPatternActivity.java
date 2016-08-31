package designpattern.dzah.wchhuangya.ch.com.designpattern.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import designpattern.dzah.wchhuangya.ch.com.designpattern.R;
import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.SocketAdapter;
import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.client.Hotel;
import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.interfaces.DBSocketInterface;
import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.interfaces.GBSocketInterface;
import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.stuff.DBSocket;
import designpattern.dzah.wchhuangya.ch.com.designpattern.adapter.objectadapter.stuff.GBSocket;

/**
 * 适配器模式演示
 * Created by wchya on 16/8/31.
 */
public class AdapterPatternActivity extends FragmentActivity {
    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_pattern);

        mTv = (TextView) findViewById(R.id.adapter_pattern_tv);

        findViewById(R.id.adapter_pattern_dbsocket_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBSocketInterface dbSocketInterface = new DBSocket();
                Hotel hotel = new Hotel(dbSocketInterface);
                mTv.setText(hotel.charge());
            }
        });

        findViewById(R.id.adapter_pattern_gbsocket_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GBSocketInterface gbSocketInterface = new GBSocket();
                SocketAdapter socketAdapter = new SocketAdapter(gbSocketInterface);
                Hotel hotel = new Hotel();
                hotel.setSocket(socketAdapter);
                mTv.setText(hotel.charge());
            }
        });
    }
}
