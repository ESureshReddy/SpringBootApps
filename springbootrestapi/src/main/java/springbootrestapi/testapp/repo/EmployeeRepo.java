package springbootrestapi.testapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootrestapi.testapp.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
}
