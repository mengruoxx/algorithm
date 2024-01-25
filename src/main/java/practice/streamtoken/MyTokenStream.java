package practice.streamtoken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author mengruo
 * @date 2022/12/23 18:00
 */
public class MyTokenStream implements TokenStream {
    private int index;
    private char[] expression;

    private final InputStream in;

    public MyTokenStream(InputStream inputStream) throws IOException {
        in = inputStream;
        expression = new char[256];
        InputStreamReader reader = new InputStreamReader(in);
        reader.read(expression);
    }

    @Override
    public Token getToken() throws IOException {
        if (index >= expression.length) {
            return new Token(TokenType.NONE, null);
        }
        char element = expression[index];
        TokenType tokenType = TokenType.getEnumByValue(String.valueOf(element));
        Token token;
        if (tokenType.equals(TokenType.INT)) {
            token = new Token(tokenType, Integer.valueOf(String.valueOf(element)));
        } else {
            token = new Token(tokenType, String.valueOf(element));
        }
        return token;
    }

    @Override
    public void consumeToken() {
        index++;

    }
}
