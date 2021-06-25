package com.jk.demo.response;

public abstract class ErrorResponse<T> extends Response<T> {
  public abstract Response<T> failed();

  public abstract Response<T> failed(String message, T data);

  public abstract Response<T> failed(T data);
}
