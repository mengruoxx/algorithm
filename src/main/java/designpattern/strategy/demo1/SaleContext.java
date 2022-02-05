package designpattern.strategy.demo1;

import designpattern.strategy.demo1.strategy.FillMunisStrategy;
import designpattern.strategy.demo1.strategy.NormalStrategy;
import designpattern.strategy.demo1.strategy.SaleOffStrategy;
import designpattern.strategy.demo1.strategy.SaleStrategy;

import java.util.List;

/**
 * @author Mengruo
 * @date 2022/1/2 19:09
 */
public class SaleContext {

    private SaleStrategy saleStrategy;

    public double calSalePrice(List<GoodItem> goodItemList, Integer strategyType) throws Exception {
        switch (strategyType) {
            case 0:
                saleStrategy = new NormalStrategy();
                break;
            case 1:
                saleStrategy= new SaleOffStrategy(0.8);
                break;
            case 2:
                saleStrategy= new FillMunisStrategy(200, 50);
                break;
            default:
                throw new Exception("参数错误");
        }
        Double sum = goodItemList.stream().map(e -> e.getPrice() * e.getAmount()).reduce(Double::sum).get();
        return calSalePrice(saleStrategy, sum);
    }

    public double calSalePrice(SaleStrategy saleStrategy, double originalPrice) throws Exception {
        return saleStrategy.calSalePrice(originalPrice);
    }
}
