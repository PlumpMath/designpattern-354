package designpattern.dzah.wchhuangya.ch.com.designpattern.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import designpattern.dzah.wchhuangya.ch.com.designpattern.BaseActivity;
import designpattern.dzah.wchhuangya.ch.com.designpattern.R;
import designpattern.dzah.wchhuangya.ch.com.designpattern.strategy.ConcreteStrategyA;
import designpattern.dzah.wchhuangya.ch.com.designpattern.strategy.ConcreteStrategyB;
import designpattern.dzah.wchhuangya.ch.com.designpattern.strategy.ConcreteStrategyC;
import designpattern.dzah.wchhuangya.ch.com.designpattern.strategy.Context;

/**
 * Created by wchya on 2016-12-20 14:05
 */

public class StrategyPatternActivity extends BaseActivity {

    @BindView(R.id.strategy_num_et)
    EditText mStrategyNumEt;
    @BindView(R.id.strategy_price_et)
    EditText mStrategyPriceEt;
    @BindView(R.id.strategy_res_tv)
    TextView mStrategyResTv;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strategy_pattern);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.strategy_normal_btn)
    public void normalClick(View view) {
        operate("A");
    }

    @OnClick(R.id.strategy_year_btn)
    public void yearClick(View view) {
        operate("B");
    }

    @OnClick(R.id.strategy_big_btn)
    public void bigClick(View view) {
        operate("C");
    }

    private void operate(String a) {
        if (hasData()) {
            double num = Double.parseDouble(mStrategyNumEt.getText().toString());
            double price = Double.parseDouble(mStrategyPriceEt.getText().toString());
            if (a.equals("A")) {
                mContext = new Context(new ConcreteStrategyA());
                mStrategyResTv.append("\n正常情况商品总价为：\n" + String.valueOf(mContext.ContextInterface(num, price)));
            } else if (a.equals("B")) {
                mContext = new Context(new ConcreteStrategyB());
                mStrategyResTv.append("\n年度促销商品总价为：\n" + String.valueOf(mContext.ContextInterface(num, price)));
            } else {
                mContext = new Context(new ConcreteStrategyC());
                mStrategyResTv.append("\n大幅度降价商品总价为：\n" + String.valueOf(mContext.ContextInterface(num, price)));
            }
        } else {
            Toast.makeText(StrategyPatternActivity.this, "请填写数量和单价", Toast.LENGTH_LONG).show();
        }
    }

    private boolean hasData() {
        if (mStrategyNumEt.getText().toString().trim().equals(""))
            return false;
        else if (mStrategyPriceEt.getText().toString().trim().equals(""))
            return false;
        else
            return true;
    }
}
