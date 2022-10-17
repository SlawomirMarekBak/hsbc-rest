package com.sbsoft.grup.controller;

import com.sbsoft.grup.utils.EmployeeSpecificationBuilder;
import com.sbsoft.grup.model.EmployeeSearch;
import com.sbsoft.grup.model.SearchCriteria;
import com.sbsoft.grup.model.Employee;
import com.sbsoft.grup.service.EmployeeService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:10101/swagger-ui.html

@RestController
public class EmployeeController {

  EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  List<Employee> all() {
    final List<Employee> employees = new LinkedList<>();
    employeeService.findAll().forEach(employees::add);
    return employees;
  }

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable long id) {

    return employeeService.findById(id);
  }

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee employee, @PathVariable Long id) {
    return employeeService.update(employee, id);
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    employeeService.deleteById(id);
  }

  @PostMapping("/employees/search")
  public List<Employee> searchEmployees(
      @RequestBody EmployeeSearch employeeSearch){
    System.out.println("employeeSearch:" + employeeSearch);
    EmployeeSpecificationBuilder builder = new EmployeeSpecificationBuilder();
    List<SearchCriteria> criteriaList = employeeSearch.getSearchCriteriaList();
    if(criteriaList != null){
      criteriaList.forEach(x-> {x.setDataOption(employeeSearch.getDataOption());
        builder.with(x);
      });
    }
    return employeeService.findBySearchCriteria(builder.build());
  }


}
