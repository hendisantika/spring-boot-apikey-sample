package id.my.hendisantika.apikeysample.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-apikey-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 05/04/25
 * Time: 06.37
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
public class Response<T> {

    boolean success;
    private int code;
    private String message;
    private T data;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response() {
        this.code = HttpStatus.OK.value();
        this.message = "Operation Successful";
    }

    public static <T> Response<T> failedResponse(String message) {
        return failedResponse(HttpStatus.BAD_REQUEST, message, null);
    }

    public static <T> Response<T> failedResponse(HttpStatus httpStatus, String message) {
        return failedResponse(httpStatus, message, null);
    }

    public static <T> Response<T> failedResponse(HttpStatus httpStatus, String message, T data) {
        Response<T> response = new Response<>(httpStatus.value(), message);
        response.setSuccess(false);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> successfulResponse(String message, T data) {
        return successfulResponse(HttpStatus.OK, message, data);
    }

    public static <T> Response<T> successfulResponse(HttpStatus httpStatus, String message, T data) {
        Response<T> response = new Response<>(httpStatus.value(), message);
        response.setSuccess(true);
        response.setData(data);
        return response;
    }
}
