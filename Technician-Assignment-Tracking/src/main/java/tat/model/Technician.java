package tat.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "technician")
public class Technician {
	
	@Id
//	@GeneratedValue
	@Column(name = "technician_id", nullable = false)
	private long technicianId;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "skill_set")
	private String skillSet;
	@Column(name = "region")
	private String region;  
	
	@OneToMany(mappedBy = "technician", cascade = CascadeType.ALL)
	private List<Assignment>assignments;
	
}
