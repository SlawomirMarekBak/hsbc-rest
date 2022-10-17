package com.sbsoft.grup.repository;


import com.sbsoft.grup.model.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>,
    JpaSpecificationExecutor<Employee> {

}
