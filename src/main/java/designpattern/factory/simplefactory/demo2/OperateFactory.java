package designpattern.factory.simplefactory.demo2;

/**
 * @author Mengruo
 * @date 2022/1/2 12:09
 */
public class OperateFactory {
    public static Operation createOperation(String operateType) throws Exception {
        switch (operateType) {
            case "+":
                return new Add();
            case "-":
                return new Minus();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            default:
                throw new Exception("不支持的操作符");
        }
    }
}
