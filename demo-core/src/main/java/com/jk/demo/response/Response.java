package com.jk.demo.response;

public class Response<T> extends BaseResponse<T> {

  public Response(ResponseCode responseCode, T data) {
    super(responseCode.code(), responseCode.message(), data);
  }

  public Response(ResponseCode responseCode) {
    this(responseCode, null);
  }

  public Response() {
    this(ResponseCode.SUCCESS);
  }

  public static <T> Response<T> success() {
    return success(null);
  }

  public static <T> Response<T> success(T data) {
    return new Response<T>(ResponseCode.SUCCESS, data);
  }
}
