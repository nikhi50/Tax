package Com.Employee.Tax.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import Com.Employee.Tax.ServiceImpl.EmployeeService;

import Com.Employee.Tax.model.Employee;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
 
	
    @Autowired
    private EmployeeService empService;

 
	@PostMapping("/save")
      public ResponseEntity createEmployee(@RequestBody  Employee emp){
        return new ResponseEntity(empService.saveEmployee(emp), HttpStatus.CREATED);
    }

    @GetMapping("/Tax/{id}")
   public ResponseEntity<?> calculateEmployeeTax(@PathVariable Integer id){
        return new ResponseEntity(empService.calculateTotalTax(id),HttpStatus.OK);
    }
}