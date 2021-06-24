package com.jk.demo.configuration.response;

public class BadRequestResponse<T> extends Response<T> {
  public BadRequestResponse() {
    super(ResponseCode.BAD_REQUEST);
  }

  public static <T> Response<T> failed() {
    return BadRequestResponse.failed(null);
  }

  public static <T> Response<T> failed(T data) {
    Response<T> resp = new BadRequestResponse<>();
    resp.setData(data);
    return resp;
  }
}
