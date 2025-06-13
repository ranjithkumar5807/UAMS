package arhm.model;
 
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String region;
    private String siteCode;
 
    @OneToOne
    @JoinColumn(name = "assetId")
    @JsonManagedReference
    private Asset asset;
}
 
 