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
public class TechnicianDetail {
    @Id
    @Column(unique = true, length = 200)
    private Long id;

    @NotNull
    @Column(unique = true, length = 200)
    private String presentation;

    @NotNull
    @Column(unique = true)
    private Integer yearsExperience;

    @NotNull
    @Column(unique = true)
    private String maritalStatus;

    @NotNull
    @Column(unique = true)
    private String educationLevel;

    @NotNull
    @Column(unique = true)
    private String englishLevel;

    @NotNull
    @Column(unique = true)
    private String nationality;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id",unique = true)
    private Technician technician;
}
