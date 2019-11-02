package springbootrestapi.testapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootrestapi.testapp.dao.EmployeeDAO;
import springbootrestapi.testapp.model.Employee;

@RestController
@RequestMapping("/epfo")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO empDAOObj;
	
	/*To save/create an Employee*/
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp){
		return empDAOObj.save(emp);
	}

	/*To get all Employees in organisation*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empDAOObj.findAll();
	}
	
	/*To get an Employee by id*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empId){
		Employee empObj = empDAOObj.getEmployee(empId);
		if(empObj==null){
			return ResponseEntity.notFound().build();
		}else{
			return ResponseEntity.ok().body(empObj);
		}
	}
	
	/*To update an Employee details*/
	@PutMapping("/employees/update/{id}")
	public ResponseEntity<Employee> updateEmpDetails(@PathVariable(value="id") Long empId, @Valid @RequestBody Employee empDetls){
		Employee empObj = empDAOObj.getEmployee(empId);
		if(empObj==null){
			return ResponseEntity.notFound().build();
		}else{
			empObj.setName(empDetls.getName());
			empDetls.setDesignation(empDetls.getDesignation());
			empDetls.setExpertise(empDetls.getExpertise());
			
			Employee updateEmployee = empDAOObj.save(empDetls);
			return ResponseEntity.ok().body(updateEmployee);
		}
	}
	
	/*To delete an Employee*/
	@DeleteMapping("/employees/fireEmp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empId){
		Employee empObj = empDAOObj.getEmployee(empId);
		if(empObj==null){
			return ResponseEntity.notFound().build();
		}else{
			empDAOObj.fireEmp(empObj);
			return ResponseEntity.ok().build();
		}
	}
	
}
