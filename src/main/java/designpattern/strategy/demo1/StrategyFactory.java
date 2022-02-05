package designpattern.strategy.demo1;

import designpattern.strategy.demo1.strategy.FillMunisStrategy;
import designpattern.strategy.demo1.strategy.NormalStrategy;
import designpattern.strategy.demo1.strategy.SaleOffStrategy;
import designpattern.strategy.demo1.strategy.SaleStrategy;

/**
 * @author Mengruo
 * @date 2022/1/2 18:36
 */
public class StrategyFactory {
    public static SaleStrategy createStrategy(Integer index, Double ratio, Double fillAmount, Double minusAmount) throws Exception {
        switch (index) {
            case 0:
                return new NormalStrategy();
            case 1:
                return new SaleOffStrategy(ratio);
            case 2:
                return new FillMunisStrategy(fillAmount, minusAmount);
            default:
                throw new Exception("参数错误");
        }
    }
}
