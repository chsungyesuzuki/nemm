package nemm.http.exception;

import java.net.http.HttpResponse;

/**
 * an exception about that the response code is not 200.
 * @version 0.0.0
 * @since 0.0.0
 * @author chsungyesuzuki
 */
public class No200Exception extends RuntimeException {
    /**
     * the response whose code is not 200.
     * @since 0.0.0
     */
    public HttpResponse<?> response;
    /**
     * constructor.
     * @since 0.0.0
     * @param response response.
     */
    public No200Exception (HttpResponse<?> response) {
        this.response = response;
    }
}
