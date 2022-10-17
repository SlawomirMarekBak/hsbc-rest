package com.sbsoft.grup.model;

import java.io.Serializable;

public class EmployeeResource implements Serializable {
  private Long id;
  private String madeFrom;
  private String madeYear;

  public EmployeeResource(Long id, String madeFrom, String madeYear) {
    this.id = id;
    this.madeFrom = madeFrom;
    this.madeYear = madeYear;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMadeFrom() {
    return madeFrom;
  }

  public void setMadeFrom(String madeFrom) {
    this.madeFrom = madeFrom;
  }

  public String getMadeYear() {
    return madeYear;
  }

  public void setMadeYear(String madeYear) {
    this.madeYear = madeYear;
  }
}
