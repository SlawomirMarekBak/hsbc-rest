package com.sbsoft.grup.utils;

import com.sbsoft.grup.model.Employee;
import com.sbsoft.grup.model.SearchCriteria;
import com.sbsoft.grup.model.SearchOperation;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecificationBuilder {

    private final List<SearchCriteria> params;

    public EmployeeSpecificationBuilder(){
        this.params = new ArrayList<>();
    }

    public final EmployeeSpecificationBuilder with(SearchCriteria searchCriteria){
        params.add(searchCriteria);
        return this;
    }

    public Specification<Employee> build(){
        if(params.size() == 0){
            return null;
        }

        Specification<Employee> result = new EmployeeSpecification(params.get(0));
        for (int idx = 1; idx < params.size(); idx++){
            SearchCriteria criteria = params.get(idx);
            result = SearchOperation.getDataOption(criteria.getDataOption()) == SearchOperation.ALL
                    ? Specification.where(result).and(new EmployeeSpecification(criteria))
                    : Specification.where(result).or(new EmployeeSpecification(criteria));
        }

        return result;
    }
}
