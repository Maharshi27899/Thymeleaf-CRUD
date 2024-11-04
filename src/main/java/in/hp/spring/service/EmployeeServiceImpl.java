package in.hp.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hp.spring.entity.Employee;
import in.hp.spring.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> byId = repository.findById(id);
		Employee employee = null;
		if(byId.isPresent()) {
			employee = byId.get();
		}
		else {
			throw new RuntimeException(" Employee Not Found For Id :: "+id);
		}
		return employee;
	}

}
