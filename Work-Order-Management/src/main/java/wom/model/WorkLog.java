package wom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkLog {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long workLogId;
	private String startTime;
	private String endTime;
	private long technicianId;
	
	@ManyToOne
	@JoinColumn(name="workOrderId")
	private WorkOrder workOrder;
	
}
