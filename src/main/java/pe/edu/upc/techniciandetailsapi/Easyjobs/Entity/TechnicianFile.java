package pe.edu.upc.techniciandetailsapi.Easyjobs.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="tbl_technicianDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicianFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 200)
    private String type;

    @Column(unique = true, length = 200)
    private String nameFile;

    @Column(unique = true, length = 200)
    private String urlFile;

    @Column(unique = true, length = 200)
    private boolean Active;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id",unique = true)
    private Technician technician;
}
