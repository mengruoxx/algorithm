package designpattern.factory.simplefactory.demo1;

/**
 * @author Mengruo
 * @date 2022/1/2 00:45
 * 这样写可以将业务与界面分离，
 * 但是如果要加一个算法，比如平方根，就需要修改已经包含原先四种算法的类，这是有风险的。
 * 要将每个方法单独封装成类
 */
public class Operation {
    public double calResult(double a, double b, String operateType) throws Exception {
        switch (operateType) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new Exception("不支持的操作符");
        }
    }
}
