package practice.operator;

import java.util.List;

/**
 * @author mengruo
 * @date 2022/12/23 16:39
 * ((A>0 && B>0) || !(C>0 && D>0))
 */
public class OperatorTranslate {

    public static class LogicOperator {
        private String op;
        /**
         * size一定是2
         */
        private List<LogicOperator> children;
        private String key;
        private String value;
    }


    public static void main(String[] args) {


    }
}
