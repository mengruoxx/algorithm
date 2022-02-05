package designpattern.factory.simplefactory.demo2;

/**
 * @author Mengruo
 * @date 2022/1/2 10:58
 */
public class Service {
    public double calculate(double a, double b, String operateType) throws Exception {
        Operation operation = OperateFactory.createOperation(operateType);
        return operation.calResult(a,b);
    }
}
