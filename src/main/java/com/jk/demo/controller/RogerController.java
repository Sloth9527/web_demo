package com.jk.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jk.demo.configuration.response.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RogerController extends BaseController {
  @GetMapping(value = "/link")
  @ResponseBody
  public Response<String> index(
      @RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "names", required = false) List<String> nameList,
      @RequestParam(value = "ids", required = false) List<Integer> ids,
      @RequestParam(value = "start_date", required = false) LocalDate startDate,
      @RequestParam(value = "end_date", required = false) @DateTimeFormat(pattern = "yyyy/MM/dd")
          LocalDate endDate) {
    System.out.println(page);
    System.out.println(nameList);
    System.out.println(ids);
    System.out.println(startDate);
    System.out.println(endDate);
    return Response.success("Roger that!");
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class LinkPayload {
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
  }
}
