package com.jk.demo.configuration.response;

public enum ResponseCode {
  SUCCESS(200, "Successful"),
  BAD_REQUEST(400, "Bad Request"),
  UNAUTHORIZED(401, "Unauthorized"),
  SERVER_ERROR(500, "Internal Server Error");

  private final Integer code;
  private final String message;

  ResponseCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer code() {
    return this.code;
  }

  public String message() {
    return this.message;
  }
}
