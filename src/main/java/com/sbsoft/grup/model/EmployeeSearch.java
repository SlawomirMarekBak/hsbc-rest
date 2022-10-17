package com.sbsoft.grup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearch {

    private List<SearchCriteria> searchCriteriaList;
    private String dataOption;

}
