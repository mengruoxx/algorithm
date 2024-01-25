import lombok.Getter;
import lombok.Setter;

/**
 * @author mengruo
 * @date 2022/2/21 16:20
 */
@Getter
@Setter
public class SpinContext implements AutoCloseable {

    public static ThreadLocal<SpinContext> contextThreadLocal = new ThreadLocal<>();

    /**
     * 基本信息
     */
    private Integer userId;

    private Integer slotsId;

    public SpinContext(int userId, int slotsId) {
        this.userId = userId;
        this.slotsId = slotsId;
        contextThreadLocal.set(this);
    }

    @Override
    public void close() {
        contextThreadLocal.remove();
        System.out.println("contextThreadLocal remove销毁");
    }

}
