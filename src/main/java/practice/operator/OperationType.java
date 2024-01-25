package practice.operator;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mengruo
 * @date 2022/12/23 18:15
 */
@AllArgsConstructor
@Getter
public enum OperationType {
    LOGIC(1),
    ALGORITHM(2)
    ;
    private final int value;
}
