package pe.edu.upc.techniciandetailsapi.Easyjobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.Technician;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianDetail;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianFile;

import java.util.List;

@Service
public interface TechnicianDetailService {
    TechnicianDetail createTechnicianDetail(TechnicianDetail technicianDetail);
    TechnicianFile createTechnicianFile(TechnicianFile technicianFile);
    TechnicianDetail updateTechnicianDetailById(Long id, TechnicianDetail technicianDetail);
    TechnicianFile updateTechnicianFileByFileIdAndTechnicianId(Long id, TechnicianFile technicianFile);
    List<TechnicianFile> findAllTechnicianFilesByTechnicianId(Long id);
    TechnicianFile findTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId);
    TechnicianDetail findTechnicianDetailById(Long id);

    TechnicianFile deleteTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId);
}
