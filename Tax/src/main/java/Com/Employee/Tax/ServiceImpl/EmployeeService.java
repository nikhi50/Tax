package Com.Employee.Tax.ServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Employee.Tax.Repos.EmployeeRepository;
import Com.Employee.Tax.dto.EmployeeTaxDetails;
import Com.Employee.Tax.model.Employee;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(Employee emp) {
        if (employeeRepository.save(emp) != null) {
            return "Employee data saved successfully";
        } else {
            return "Employee data is not saved";
        }
    }


    public EmployeeTaxDetails calculateTotalTax(Integer id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isEmpty()) {
            throw new IllegalArgumentException("Employee not found");
        }

        Employee employee = emp.get();
        Integer annualSalary = calculateAnnualSalary(employee.getDateOfJoin(), employee.getSalary());

        return EmployeeTaxDetails.builder()
                .employeeCode(employee.getEmployeeID())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .annualSalary(annualSalary)
                .tax(calculateTax(annualSalary))
                .cessTax(calculateCessTax(annualSalary))
                .build();
    }

    private Integer calculateAnnualSalary(String dateOfJoin, Integer monthlySalary) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        Date joiningDate;
        try {
            joiningDate = sdf.parse(dateOfJoin);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        long months = java.time.temporal.ChronoUnit.MONTHS.between(
                java.time.LocalDate.ofInstant(joiningDate.toInstant(), java.time.ZoneId.systemDefault()),
                java.time.LocalDate.now());

        return (int) (months * monthlySalary);
    }

    private Integer calculateTax(Integer annualSalary) {
        int tax = 0;
        if (annualSalary <= 250000) {
            tax = 0;
        } else if (annualSalary <= 500000) {
            tax = ((annualSalary - 250000) * 5) / 100;
        } else if (annualSalary <= 1000000) {
            tax = (250000 * 5) / 100 + ((annualSalary - 500000) * 10) / 100;
        } else {
            tax = (250000 * 5) / 100 + ((annualSalary - 500000) * 10) / 100 + ((annualSalary - 1000000) * 20) / 100;
        }
        return tax;
    }

    private Integer calculateCessTax(Integer annualSalary) {
        int cessTax = 0;
        if (annualSalary > 2500000) {
            cessTax = ((annualSalary - 2500000) * 2) / 100;
        }
        return cessTax;
    }
}