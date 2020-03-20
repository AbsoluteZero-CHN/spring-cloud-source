package cn.noload.consumer.model;

import java.util.Objects;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-03-17 11:27
 */
public class WebResult<T> {
    public static final String SUCCESS_CODE = "200";
    public static final String CLINT_ERROR_CODE = "403";
    public static final String SERVER_ERROR_CODE = "500";
    private String code;
    private String message;
    private T result;

    public WebResult() {
    }

    public WebResult(T result) {
        this.code = "200";
        this.result = result;
    }

    public WebResult(String code, T result) {
        this.code = code;
        this.result = result;
    }

    public WebResult(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public boolean success() {
        return Objects.equals("200", this.code);
    }

    public String getCode() {
        return this.code;
    }

    public WebResult<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public WebResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getResult() {
        return this.result;
    }

    public WebResult<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public static <T> WebResult<T> success(T result) {
        return new WebResult("200", result);
    }

    public static <T> WebResult<T> fail(String code, String message) {
        WebResult<T> webResult = new WebResult();
        webResult.setCode(code);
        webResult.setMessage(message);
        return webResult;
    }
}
