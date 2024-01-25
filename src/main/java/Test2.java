/**
 * @author mengruo
 * @date 2022/10/18 16:10
 */
public class Test2 {

    public static void main(String[] args) {
        try (SpinContext spinContext = new SpinContext(1000, 10014)) {
            throw new NullPointerException();
        } catch (SlotsValidationException e) {
            // 捕获自定义的校验异常
            System.out.println("自定义异常");
        }
    }

}
