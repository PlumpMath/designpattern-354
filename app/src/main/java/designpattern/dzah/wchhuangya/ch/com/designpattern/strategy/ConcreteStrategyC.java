package designpattern.dzah.wchhuangya.ch.com.designpattern.strategy;

/**
 * Created by wchya on 2016-12-20 12:01
 */

public class ConcreteStrategyC extends Strategy {
    @Override
    public double algorithmInterface(double num, double price) {
        double total = num * price;
        return total - (total > 300 ? (((int)(total / 300)) * 100) : 0);
    }
}
