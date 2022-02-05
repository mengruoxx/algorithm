package designpattern.strategy.demo1.strategy;

import designpattern.factory.simplefactory.demo2.Add;
import lombok.Data;

/**
 * @author Mengruo
 * @date 2022/1/2 13:23
 */
@Data
public abstract class SaleStrategy {

    private Integer id;

    public abstract double calSalePrice(double originalPrice);
}
