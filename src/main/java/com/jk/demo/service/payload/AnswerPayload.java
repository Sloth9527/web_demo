package com.jk.demo.service.payload;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPayload {
  Integer degreeLow;
  Integer degreeUp;
  List<String> letterGrade;
  List<Integer> sNos;
  List<Integer> cNos;
  String sName;
  List<String> sSexes;
  Date startStuDate;
  Date endStuDate;
  List<String> classNums;

  Integer page = 1;
  Integer pageSize = 20;
  Integer offset = 0;

  String sortColumnName;
  String sortDirection;

  public void buildRowBounds() {
    Integer offset = this.getPage() * this.getPageSize();
    this.setOffset(offset);
  }
}
