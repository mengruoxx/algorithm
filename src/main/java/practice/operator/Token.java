package practice.operator;

import practice.streamtoken.TokenType;

/**
 * @author mengruo
 * @date 2022/12/23 17:58
 */
public class Token {

    public TokenType tokenType;
    public Object value;

    public Token(TokenType tt, Object v) {
        this.tokenType = tt;
        this.value = v;
    }

    @Override
    public String toString() {
        if (tokenType.equals(TokenType.BLANK)) {
            return "";
        }
        return "{" + tokenType.name() + ", " + "\"" + tokenType.getValue() + "\"" + "}";
    }
}
