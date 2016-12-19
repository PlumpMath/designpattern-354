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
import designpattern.dzah.wchhuangya.ch.com.designpattern.factory.simplef.PhoneFactory;

/**
 * Created by wchya on 2016-12-19 10:10
 */

public class SimpleFactoryPatternActivity extends BaseActivity {

    @BindView(R.id.res_tv)
    TextView mResTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_factory_pattern);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.xiaomi_btn)
    public void xiamiClick(View view) {
        mResTv.append(PhoneFactory.factory("xiaomi") + "\n");
    }

    @OnClick(R.id.samsong_btn)
    public void samsungClick(View view) {
        mResTv.append(PhoneFactory.factory("samsung") + "\n");
    }

    @OnClick(R.id.huawei_btn)
    public void huaweiClick(View view) {
        mResTv.append(PhoneFactory.factory("huawei") + "\n");
    }
}
