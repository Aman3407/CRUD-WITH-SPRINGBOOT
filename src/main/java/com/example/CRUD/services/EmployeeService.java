package com.example.CRUD.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.CRUD.Entities.EmployeeEntity;
import com.example.CRUD.dto.EmployeeDTO;
import com.example.CRUD.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    // @Autowired  
    final EmployeeRepository employeeRepository;
    final ModelMapper modelmapper;
    
    public EmployeeService (EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository= employeeRepository;
        this.modelmapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(long id){
        @SuppressWarnings("deprecation")
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelmapper.map(employeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelmapper.map(employeeDTO, EmployeeEntity.class);
        return modelmapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
        .stream()
        .map(employeeEntity -> modelmapper.map(employeeEntity,EmployeeDTO.class))
        .collect(Collectors.toList());
    }

    public String deleteEmployeeById(long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return "Employee Not Found!!!" ;
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully!!!";
    }

    public void saveOrUpdate( EmployeeDTO employeeDTO, long id) {
        @SuppressWarnings("deprecation")
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setDateOfJoining(employeeDTO.getDateOfJoining());
        employeeEntity.setId(id);
        employeeEntity.setIsActive(employeeDTO.getIsActive());
        employeeRepository.save(employeeEntity);
    }

    public void saveOrUpdateByFields(EmployeeDTO employeeDTO, long id) {
        @SuppressWarnings("deprecation")
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        System.err.println(employeeEntity);
        if(employeeEntity != null)
            employeeEntity.setId(id);
        if(employeeDTO.getName() != null)
            employeeEntity.setName(employeeDTO.getName());
        // if(employeeDTO.getPassword() != null)
        //         employeeEntity.setPassword(employeeDTO.getPassword());
        if(employeeDTO.getDateOfJoining() != null)
            employeeEntity.setDateOfJoining(employeeDTO.getDateOfJoining());
        if(employeeDTO.getIsActive() != null)
            employeeEntity.setIsActive(employeeDTO.getIsActive());
        employeeRepository.save(employeeEntity);
    }

}