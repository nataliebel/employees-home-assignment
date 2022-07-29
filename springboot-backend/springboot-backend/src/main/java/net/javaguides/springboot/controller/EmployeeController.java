package net.javaguides.springboot.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.EmployeeSpecification;
import net.javaguides.springboot.repository.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(name="email", required=false) String email){
        if(email != null) {
            EmployeeSpecification spec = new EmployeeSpecification(new SearchCriteria(email));
            return employeeRepository.findAll(spec);
        }
        return employeeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee) throws URISyntaxException {
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.created(new URI("/api/v1/employees/" + savedEmployee.getId())).body(savedEmployee);
    }


}
