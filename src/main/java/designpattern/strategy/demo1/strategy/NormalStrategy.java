package designpattern.strategy.demo1.strategy;

import designpattern.strategy.demo1.strategy.SaleStrategy;

/**
 * @author Mengruo
 * @date 2022/1/2 18:34
 */
public class NormalStrategy extends SaleStrategy {

    @Override
    public double calSalePrice(double originalPrice) {
        return originalPrice;
    }
}
