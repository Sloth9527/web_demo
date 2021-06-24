package com.jk.demo.configuration.aspect;

import com.jk.demo.Utils.JwtUtils;
import com.jk.demo.configuration.response.ResponseException;
import com.jk.demo.configuration.response.UnauthorizedResponse;
import com.jk.demo.dao.entity.User;
import com.jk.demo.service.UserServiceInterface;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AuthorityAspect {
  @Autowired UserServiceInterface userServiceImpl;

  @Around("@annotation(authority)")
  public Object authority(ProceedingJoinPoint joinPoint, Authority authority) throws Throwable {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

    this.unauthorizedThrow(requestAttributes == null);

    assert requestAttributes != null;

    ServletRequestAttributes servletRequestAttributes =
        (ServletRequestAttributes) requestAttributes;

    HttpServletRequest httpRequest = servletRequestAttributes.getRequest();

    String token = httpRequest.getHeader("Authorization");

    this.unauthorizedThrow(token == null);

    String username = JwtUtils.getUsername(token);

    this.unauthorizedThrow(username == null);

    User user = this.userServiceImpl.queryByUsername(username);

    this.unauthorizedThrow(user == null);

    this.unauthorizedThrow(!JwtUtils.verify(token, user));

    return joinPoint.proceed();
  }

  private void unauthorizedThrow(Boolean isUnauthorized) throws Exception {
    if (isUnauthorized) {
      throw new ResponseException(UnauthorizedResponse.failed());
    }
  }
}
