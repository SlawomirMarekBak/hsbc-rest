package com.sbsoft.grup.service;


import com.sbsoft.grup.model.Employee;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public interface EmployeeService {

  Iterable<Employee> findAll();

  Employee save(Employee employee);

  Employee findById(Long id);

  void deleteById(Long id);

  Employee update(Employee employee, Long id);
  List<Employee> findBySearchCriteria(Specification<Employee> spec);
}
