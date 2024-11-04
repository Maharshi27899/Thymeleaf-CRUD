package in.hp.spring.service;

import java.util.List;

import in.hp.spring.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeById(long id);
}
