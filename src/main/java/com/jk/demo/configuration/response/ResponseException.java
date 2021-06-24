package com.jk.demo.configuration.response;

public class ResponseException extends RuntimeException {
  private Response<?> response;

  public ResponseException(Response<?> response) {
    super(response.getMessage());
    this.response = response;
  }

  public Response<?> getResponse() {
    return this.response;
  }

  public void setResponse(Response<?> response) {
    this.response = response;
  }
}
