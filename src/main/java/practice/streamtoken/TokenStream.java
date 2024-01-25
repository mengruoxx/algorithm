package practice.streamtoken;

import java.io.IOException;

/**
 * @author mengruo
 * @date 2022/12/23 17:58
 */
public interface TokenStream {

    public Token getToken()  throws IOException;

    public void consumeToken();
}
