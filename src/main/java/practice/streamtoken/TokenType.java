package practice.streamtoken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author mengruo
 * @date 2022/12/23 18:15
 */
@AllArgsConstructor
@Getter
public enum TokenType {
    LPAR("("),
    RPAR(")"),
    PLUS("+"),
    MINUS("-"),
    MULT("*"),
    DIV("/"),
    INT(""),
    BLANK(""),
    NONE(""),
    ;
    private final String value;

    public static TokenType getEnumByValue(String value) {
        for (TokenType tokenType : TokenType.values()) {
            if (tokenType.getValue().equals(value)) {
                return tokenType;
            }
        }
        if (StringUtils.isNumeric(value)) {
            return INT;
        }
        if (StringUtils.isBlank(value)) {
            return BLANK;
        }
        return NONE;
    }
}
