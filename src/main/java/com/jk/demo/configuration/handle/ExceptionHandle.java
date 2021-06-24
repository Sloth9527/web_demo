package com.jk.demo.configuration.handle;

import com.jk.demo.configuration.response.Response;
import com.jk.demo.configuration.response.ResponseException;
import com.jk.demo.configuration.response.ServerErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {
  @ExceptionHandler(value = Exception.class)
  public @ResponseBody Response<?> exceptionHandle(Exception e) {
    log.error("Exception Handle:" + e.toString(), e);

    if (e instanceof ResponseException) {
      return ((ResponseException) e).getResponse();
    }

    return ServerErrorResponse.failed(e.toString(), null);
  }
}
