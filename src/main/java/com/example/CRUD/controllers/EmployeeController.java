package com.example.CRUD.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD.dto.EmployeeDTO;
import com.example.CRUD.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService){
        this.employeeService= employeeService;
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") long employeeId) {
        return employeeService.getEmployeeById(employeeId);
        // return new EmployeeDTO(1,"Aman",LocalDate.of(2024,2,2),true);
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }
    @PutMapping("/{id}")
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
        try {
            employeeService.saveOrUpdate(employeeDTO,id);
            return "Employee Details updated SuccessFully!!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @PatchMapping("/{id}")
    public String updateEmployeeByFields(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
        try {
            employeeService.saveOrUpdateByFields(employeeDTO,id);
            return "Employee Details updated SuccessFully!!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @DeleteMapping("/{id}")
    public String deleteEmployeeByid(@PathVariable long id) {
        return employeeService.deleteEmployeeById(id);
    }
}