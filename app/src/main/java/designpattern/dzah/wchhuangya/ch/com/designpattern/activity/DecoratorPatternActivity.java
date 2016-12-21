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
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.BigTrouser;
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.ConcretePerson;
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.LeatherShoes;
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.Person;
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.Sneakers;
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.Suit;
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.TShirts;
import designpattern.dzah.wchhuangya.ch.com.designpattern.decorator.Tie;

/**
 * Created by wchya on 2016-12-21 14:47
 */

public class DecoratorPatternActivity extends BaseActivity {

    @BindView(R.id.res_tv)
    TextView mResTv;
    private Person mPerson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decorator_pattern);
        ButterKnife.bind(this);

        mPerson = new ConcretePerson("小菜");
    }

    @OnClick(R.id.mode1_btn)
    public void mode1Click(View view) {
        Sneakers sneakers = new Sneakers();
        BigTrouser bigTrouser = new BigTrouser();
        TShirts tShirts = new TShirts();

        sneakers.setComponent(mPerson);
        bigTrouser.setComponent(sneakers);
        tShirts.setComponent(bigTrouser);

        mResTv.append(tShirts.show() + "\n");
    }

    @OnClick(R.id.mode2_btn)
    public void mode2Click(View view) {
        LeatherShoes leatherShoes = new LeatherShoes();
        Tie tie = new Tie();
        Suit suit = new Suit();

        leatherShoes.setComponent(mPerson);
        tie.setComponent(leatherShoes);
        suit.setComponent(tie);

        mResTv.append(suit.show() + "\n");
    }

    @OnClick(R.id.mode3_btn)
    public void mode3Click(View view) {
        Sneakers sneakers = new Sneakers();
        LeatherShoes leatherShoes = new LeatherShoes();
        BigTrouser bigTrouser = new BigTrouser();
        Tie tie = new Tie();

        sneakers.setComponent(mPerson);
        leatherShoes.setComponent(sneakers);
        bigTrouser.setComponent(leatherShoes);
        tie.setComponent(bigTrouser);

        mResTv.append(tie.show() + "\n");
    }
}
