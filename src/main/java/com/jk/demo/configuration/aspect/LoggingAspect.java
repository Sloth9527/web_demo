package com.jk.demo.configuration.aspect;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
  @Pointcut(
      "@annotation(org.springframework.web.bind.annotation.RequestMapping)||@annotation(org.springframework.web.bind.annotation.GetMapping)||@annotation(org.springframework.web.bind.annotation.PostMapping)||@annotation(org.springframework.web.bind.annotation.PutMapping)||@annotation(org.springframework.web.bind.annotation.PatchMapping)||@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
  public void requestMappingPointCut() {}

  @Before("requestMappingPointCut()")
  public void loggingRequest() throws Throwable {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

    assert requestAttributes != null;

    ServletRequestAttributes servletRequestAttributes =
        (ServletRequestAttributes) requestAttributes;

    HttpServletRequest httpRequest = servletRequestAttributes.getRequest();

    StringBuilder sb = new StringBuilder();

    sb.append(httpRequest.getMethod()).append(" ").append(httpRequest.getRequestURI());

    Enumeration<String> names = httpRequest.getParameterNames();
    String name = null;
    while (names.hasMoreElements()) {
      if (name == null) {
        sb.append("?");
      } else {
        sb.append("&");
      }
      name = names.nextElement();
      String value = httpRequest.getParameter(name);
      sb.append(name).append("=").append(value);
    }

    log.info(sb.toString());
  }
}
