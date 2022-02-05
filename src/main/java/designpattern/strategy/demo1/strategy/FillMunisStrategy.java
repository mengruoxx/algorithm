package designpattern.strategy.demo1.strategy;

import designpattern.strategy.demo1.strategy.SaleStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mengruo
 * @date 2022/1/2 13:28
 */
@Data
@AllArgsConstructor
public class FillMunisStrategy extends SaleStrategy {
    private double fillAmount;

    private double minusAmount;

    @Override
    public double calSalePrice(double originalPrice) {
        double minusAmountCount = Math.floor(originalPrice / fillAmount);
        return originalPrice - minusAmountCount *  minusAmount;
    }
}
