package com.sbsoft.grup.service;

import com.sbsoft.grup.model.Employee;
import com.sbsoft.grup.model.EmployeeNotFoundException;
import com.sbsoft.grup.repository.EmployeeRepository;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

  EmployeeRepository employeeRepository;

  public EmployeeServiceImp(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Iterable<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee findById(Long id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public Employee update(Employee newEmployee, Long id) {
    return employeeRepository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setSurname(newEmployee.getSurname());
          employee.setGrade(newEmployee.getGrade());
          employee.setSalary(newEmployee.getSalary());
          return employeeRepository.save(employee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return employeeRepository.save(newEmployee);
        });
  }

  @Override
  public List<Employee> findBySearchCriteria(Specification<Employee> spec){
    List<Employee> searchResult = employeeRepository.findAll(spec);
    return searchResult;
  }
}
