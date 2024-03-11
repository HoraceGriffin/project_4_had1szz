package cn.had1szz.cyzy.response;

import lombok.Data;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Data
public class Result<T> {
    private Integer code;
    private Boolean success;
    private String msg;
    private T data;

    private Result() {}

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("OK");
        result.setSuccess(true);
        result.setData(data);

        return result;
    }

    public static Result<?> ok() {
        return Result.ok("");
    }

    public static <T> Result<T> fail(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);

        return result;
    }
}
