package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.interfaces.RSAKey;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

//  build add employee REST API
@PostMapping
public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
    EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
    return  new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
}
//  build get employee REST API
@GetMapping("{id}")
public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
    EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
    return ResponseEntity.ok(employeeDto);
}
//  build get ALl employee REST API
@GetMapping
public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
    List<EmployeeDto> employees = employeeService.getAllEmployees();
    return ResponseEntity.ok(employees);
    }

//  build get ALl employee REST API
@PutMapping("{id}")
public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId ,
                                                  @RequestBody EmployeeDto updatedEmployee){
    EmployeeDto employeeDto = employeeService.updateEmployee(employeeId , updatedEmployee);
    return ResponseEntity.ok(employeeDto);
}

//  build get ALl employee REST API
@DeleteMapping("{id}")
public ResponseEntity<String > deleteEmployee(@PathVariable("id") Long employeeId){
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.ok("Employee deleted successfully..!!!");
}
}
