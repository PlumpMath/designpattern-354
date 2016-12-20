package designpattern.dzah.wchhuangya.ch.com.designpattern.strategy;

/**
 * Created by wchya on 2016-12-20 12:00
 */

public class ConcreteStrategyA extends Strategy {
    @Override
    public double algorithmInterface(double num, double price) {
        return num * price;
    }
}
