package com.jk.demo.configuration.response;

public class UnauthorizedResponse<T> extends Response<T> {
  public UnauthorizedResponse() {
    super(ResponseCode.UNAUTHORIZED);
  }

  public static <T> Response<T> failed() {
    return UnauthorizedResponse.failed(null);
  }

  public static <T> Response<T> failed(T data) {
    Response<T> resp = new UnauthorizedResponse<>();
    resp.setData(data);
    return resp;
  }
}
