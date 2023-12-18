package Com.Employee.Tax.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Data
@NoArgsConstructor
@Table(name="phonetable")
public class Phone {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name="emp_id",referencedColumnName = "employeeid" )
	    private Employee employee;

	    @NonNull
	    private Long phoneNumber;
}
