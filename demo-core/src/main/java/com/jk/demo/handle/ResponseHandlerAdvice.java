package com.jk.demo.handle;

import com.jk.demo.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice
public class ResponseHandlerAdvice implements ResponseBodyAdvice {

  @Override
  public boolean supports(MethodParameter methodParameter, Class aClass) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(
      Object o,
      MethodParameter methodParameter,
      MediaType mediaType,
      Class aClass,
      ServerHttpRequest serverHttpRequest,
      ServerHttpResponse serverHttpResponse) {
    Response<?> resp = null;
    if (o instanceof Response) {
      resp = (Response<?>) o;
      HttpStatus status = HttpStatus.resolve(resp.getCode());
      if (status == null) {
        status = HttpStatus.OK;
      }
      serverHttpResponse.setStatusCode(status);
    } else {
      resp = Response.success(o);
    }

    log.info(
        serverHttpRequest.getMethod()
            + " "
            + serverHttpRequest.getURI()
            + " -> "
            + resp.toString());

    return resp;
  }
}
