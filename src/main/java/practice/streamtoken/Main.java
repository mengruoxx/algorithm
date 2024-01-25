package practice.streamtoken;

import java.io.IOException;

/**
 * @author mengruo
 * @date 2022/12/23 17:59
 */
public class Main {
    public static void main(String[] args) throws IOException {
        TokenStream ts = new MyTokenStream(System.in);
        while (ts.getToken().tokenType != TokenType.NONE) {
            Token token = ts.getToken();
            System.out.println(token.toString());
            ts.consumeToken();
        }
    }
}
