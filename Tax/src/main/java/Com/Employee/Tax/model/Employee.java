package Com.Employee.Tax.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="Empolyetax")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeid")
	//private Integer empID;
    private Integer employeeID;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    @OneToMany(mappedBy="employee")
    private List<Phone> phoneNumbers;

    @NonNull
    private String dateOfJoin;

    @NonNull
    private Integer salary;

}

