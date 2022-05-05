package pe.edu.upc.techniciandetailsapi.Easyjobs.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianFile;

import java.util.List;

@Qualifier("technicianFileRepository")
@Repository
public interface TechnicianFileRepository extends JpaRepository<TechnicianFile, Long> {
    @Query(value ="SELECT tf FROM TechnicianFile tf WHERE tf.technician.id = ?1")
    List<TechnicianFile> TechnicianFilesByTechnicianId(Long id);
    @Query(value ="SELECT tf FROM TechnicianFile tf WHERE tf.technician.id = ?1 and tf.id = ?2")
    TechnicianFile findTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId);
}
