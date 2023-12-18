package Com.Employee.Tax.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class EmployeeTaxDetails {
    private Integer employeeCode;
    private String firstName;
    private String lastName;
    private Integer annualSalary;
    private Integer tax;
    private Integer cessTax;
}
