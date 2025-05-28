package wom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkLog {
	
	@Id
	long logID;
	String StartTime;
	String EndTime;
	
	
	Long TechnicianId;
	
	@ManyToOne
	@JoinColumn(name="workorder_id")
	WorkOrder WorkOrderID;
	
}
