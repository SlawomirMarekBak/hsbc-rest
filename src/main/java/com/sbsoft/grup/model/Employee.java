package com.sbsoft.grup.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

  @Id @GeneratedValue
  private Long id;
  private String name;
  private String surname;
  private Integer grade;
  private Integer salary;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Employee)) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(getId(), employee.getId()) && Objects.equals(getName(),
        employee.getName()) && Objects.equals(getSurname(), employee.getSurname())
        && Objects.equals(getGrade(), employee.getGrade()) && Objects.equals(
        getSalary(), employee.getSalary());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSurname(), getGrade(), getSalary());
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", grade=" + grade +
        ", salary=" + salary +
        '}';
  }
}
