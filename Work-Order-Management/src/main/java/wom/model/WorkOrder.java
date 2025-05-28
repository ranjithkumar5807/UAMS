package wom.model;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrder {
	
	@Id
	long workOrderId;
	long planId;
	Date scheduledDate;
	String status;

}
