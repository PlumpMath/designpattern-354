package designpattern.dzah.wchhuangya.ch.com.designpattern.strategy;

/**
 * Created by wchya on 2016-12-20 14:02
 */

public class Context {

    private Strategy mStrategy;

    public Context(Strategy strategy) {
        mStrategy = strategy;
    }

    public double ContextInterface(double num, double price) {
        return mStrategy.algorithmInterface(num, price);
    }
}
