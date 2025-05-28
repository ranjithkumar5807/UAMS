package arhm.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;


@Entity
@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long assetId;
	private String name;
	private String type;
	private LocalDate InstallationDate;
	private String status;
	

	@OneToOne(mappedBy = "asset", cascade = CascadeType.ALL)
	private Location location;

}
