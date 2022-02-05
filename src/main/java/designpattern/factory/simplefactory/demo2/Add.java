package designpattern.factory.simplefactory.demo2;

/**
 * @author Mengruo
 * @date 2022/1/2 10:27
 */
public class Add implements Operation {
    @Override
    public double calResult(double a, double b) {
        return a + b;
    }
}
