package springbootrestapi.testapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootrestapi.testapp.model.Employee;
import springbootrestapi.testapp.repo.EmployeeRepo;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepo employeeRepo;
	
	/*To Save Employee Details into DB*/
	public Employee save(Employee emp){
		return employeeRepo.save(emp);
	}
	
	/*To Search all employees*/
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
	
	/*To get an Employee by Id*/
	public Employee getEmployee(Long empId){
		return employeeRepo.findOne(empId); 
	}
	
	/*To delete an Employee*/
	public void fireEmp(Employee emp){
		employeeRepo.delete(emp);
	}
}
