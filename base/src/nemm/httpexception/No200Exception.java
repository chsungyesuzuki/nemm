package nemm.httpexception;

import java.net.http.HttpResponse;

public class No200Exception extends RuntimeException {
    public HttpResponse<?> response;
    public No200Exception (HttpResponse<?> response) {
        this.response = response;
    }
}
