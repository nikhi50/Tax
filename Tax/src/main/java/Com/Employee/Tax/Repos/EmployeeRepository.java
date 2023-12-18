package Com.Employee.Tax.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Com.Employee.Tax.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
