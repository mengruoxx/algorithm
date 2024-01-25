import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/**
 * @author mengruo
 * @date 2022/10/18 16:10
 */
public class Test {

    @Data
    public static class Test1 {
        private int a = -1;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<>(map);
        newMap.put(0, newMap.get(0) + 1);
        System.out.println("");
    }

}
