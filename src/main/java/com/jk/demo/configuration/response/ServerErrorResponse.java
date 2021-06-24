package com.jk.demo.configuration.response;

public class ServerErrorResponse<T> extends Response<T> {
  public ServerErrorResponse() {
    super(ResponseCode.SERVER_ERROR);
  }

  public static <T> Response<T> failed() {
    return ServerErrorResponse.failed(null);
  }

  public static <T> Response<T> failed(T data) {
    Response<T> resp = new ServerErrorResponse<>();
    resp.setData(data);
    return resp;
  }

  public static <T> Response<T> failed(String message, T data) {
    Response<T> resp = new ServerErrorResponse<>();
    resp.setMessage(message);
    resp.setData(data);
    return resp;
  }
}
