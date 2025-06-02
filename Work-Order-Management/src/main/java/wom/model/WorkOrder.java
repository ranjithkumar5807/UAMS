package wom.model;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrder {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long workOrderId;
	private long planId;
	private Date scheduledDate;
	private String status;

}
