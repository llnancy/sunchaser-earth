package com.sunchaser.earth.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarthResponse<T> implements Serializable {
    private static final long serialVersionUID = 8209296184730258865L;
    private String resultCode;
    private String resultMsg;
    private T data;

    public static <T> EarthResponse<T> success(T t) {
        return success(EarthCodeMsg.SUCCESS, t);
    }

    public static <T> EarthResponse<T> success(EarthCodeMsg earthCodeMsg, T t) {
        return new EarthResponse<>(earthCodeMsg.getCode(), earthCodeMsg.getMsg(), t);
    }

    public static <T> EarthResponse<T> success(EarthCodeMsg earthCodeMsg) {
        return success(earthCodeMsg, null);
    }

    public static <T> EarthResponse<T> success(String resultCode, String resultMsg, T t) {
        return new EarthResponse<>(resultCode, resultMsg, t);
    }

    public static <T> EarthResponse<T> success(String resultCode, String resultMsg) {
        return success(resultCode, resultMsg, null);
    }

    public static <T> EarthResponse<T> error(EarthCodeMsg earthCodeMsg) {
        return success(earthCodeMsg, null);
    }

    public static <T> EarthResponse<T> error(String resultCode, String resultMsg) {
        return success(resultCode, resultMsg, null);
    }

    public static <T> EarthResponse<T> error() {
        return error(EarthCodeMsg.FAIL);
    }

    public static <T> EarthResponse<T> error(String resultMsg) {
        return error(EarthCodeMsg.FAIL.getCode(), resultMsg);
    }
}
