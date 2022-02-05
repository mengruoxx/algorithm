package designpattern.strategy.demo1.strategy;

import designpattern.factory.simplefactory.demo2.Add;
import designpattern.factory.simplefactory.demo2.ChildAdd;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mengruo
 * @date 2022/1/2 13:29
 */
@Data
@AllArgsConstructor
public class SaleOffStrategy extends SaleStrategy {
    private double ratio;

    @Override
    public double calSalePrice(double originalPrice) {
        return originalPrice * ratio;
    }

}
