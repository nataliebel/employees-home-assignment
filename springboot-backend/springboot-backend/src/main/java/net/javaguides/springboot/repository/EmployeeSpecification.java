package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class EmployeeSpecification implements Specification<Employee> {

    private SearchCriteria criteria;
    public EmployeeSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }
    @Override
    public Predicate toPredicate
            (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getEmail() != null) {
            return builder.like(
                    root.<String> get("email"), "%" + criteria.getEmail() + "%");
        }
        return null;
    }
}
