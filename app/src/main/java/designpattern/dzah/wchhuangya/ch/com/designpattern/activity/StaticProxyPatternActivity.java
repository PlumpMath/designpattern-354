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
import designpattern.dzah.wchhuangya.ch.com.designpattern.proxy.Proxy;

/**
 * Created by wchya on 2016-12-22 10:24
 */

public class StaticProxyPatternActivity extends BaseActivity {

    @BindView(R.id.res_tv)
    TextView mResTv;
    private Proxy mProxy;
    private String mGirlName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_proxy_pattern);
        ButterKnife.bind(this);

        mProxy = new Proxy("小菜");
        mGirlName = "小丽";
    }

    @OnClick(R.id.give_presents_btn)
    public void givePresents(View view) {
        mResTv.append(mProxy.givePresents(mGirlName) + "\n");
    }

    @OnClick(R.id.stand_treat_btn)
    public void standTreat(View view) {
        mResTv.append(mProxy.standTreat(mGirlName) + "\n");
    }

    @OnClick(R.id.give_flower_btn)
    public void giveFlower(View view) {
        mResTv.append(mProxy.giveFlowers(mGirlName) + "\n");
    }
}
