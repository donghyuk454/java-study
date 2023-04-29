package main.java.com.dong.chap14.stream.controller.response;

public class BaseResponse <T> {
    protected int status;
    protected T body;
    protected String message;

    private BaseResponse(int status, T body) {
        this.status = status;
        this.body = body;
    }

    private BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static BaseResponse isOk(Object body, Class bodyClass) {
        return new BaseResponse(200, bodyClass.cast(body));
    }

    public static BaseResponse isBadRequest(String message) {
        return new BaseResponse(404, message);
    }

    public T getBody () {
        return body;
    }
}
