package designpattern.dzah.wchhuangya.ch.com.designpattern.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import designpattern.dzah.wchhuangya.ch.com.designpattern.BaseActivity;
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
public class AdapterPatternActivity extends BaseActivity {

    @BindView(R.id.adapter_pattern_tv)
    TextView mAdapterPatternTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_pattern);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.adapter_pattern_dbsocket_btn)
    public void dbClick(View view) {
        DBSocketInterface dbSocketInterface = new DBSocket();
        Hotel hotel = new Hotel(dbSocketInterface);
        mAdapterPatternTv.setText(hotel.charge());
    }

    @OnClick(R.id.adapter_pattern_gbsocket_btn)
    public void gbClick(View view) {
        GBSocketInterface gbSocketInterface = new GBSocket();
        SocketAdapter socketAdapter = new SocketAdapter(gbSocketInterface);
        Hotel hotel = new Hotel();
        hotel.setSocket(socketAdapter);
        mAdapterPatternTv.setText(hotel.charge());
    }
}
