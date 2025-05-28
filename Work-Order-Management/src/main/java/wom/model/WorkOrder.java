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
	long WorkOrderId;
	@OneToMany(mappedBy="workorder", cascade = CascadeType.ALL)
	String PlanId;
	Date ScheduledDate;
	String Status;

}
