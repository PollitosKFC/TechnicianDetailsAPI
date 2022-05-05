package pe.edu.upc.techniciandetailsapi.Easyjobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianDetail;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianFile;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianDetailRepository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianFileRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianDetailServiceImpl  implements TechnicianDetailService {
    @Autowired
    private final TechnicianDetailRepository technicianDetailRepository;
    @Autowired
    private final TechnicianFileRepository technicianFileRepository;

    @Override
    public TechnicianDetail createTechnicianDetail(TechnicianDetail technicianDetails) {
        TechnicianDetail technicianDetail = new TechnicianDetail();
        technicianDetail.setId(technicianDetails.getId());
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setPresentation(technicianDetails.getPresentation());
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setEducationLevel(technicianDetails.getEducationLevel());
        technicianDetail.setNationality(technicianDetails.getNationality());
        technicianDetail.setEnglishLevel(technicianDetails.getEnglishLevel());
        return technicianDetailRepository.save(technicianDetail);
    }

    @Override
    public TechnicianFile createTechnicianFile(TechnicianFile technicianFiles){
        TechnicianFile technicianFile = new TechnicianFile();
        technicianFile.setNameFile(technicianFiles.getNameFile());
        technicianFile.setType(technicianFiles.getType());
        technicianFile.setUrlFile(technicianFiles.getUrlFile());
        technicianFile.setActive(true);
        return technicianFileRepository.save(technicianFile);
    }

    @Override
    public TechnicianDetail updateTechnicianDetailById(Long id, TechnicianDetail technicianDetails) {
        TechnicianDetail technicianDetail = technicianDetailRepository.findTechnicianDetailById(id);
        if (technicianDetail == null) {
            return null;
        }
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setPresentation(technicianDetails.getPresentation());
        technicianDetail.setYearsExperience(technicianDetails.getYearsExperience());
        technicianDetail.setEducationLevel(technicianDetails.getEducationLevel());
        technicianDetail.setNationality(technicianDetails.getNationality());
        technicianDetail.setEnglishLevel(technicianDetails.getEnglishLevel());
        return technicianDetailRepository.save(technicianDetail);
    }

    @Override
    public TechnicianFile updateTechnicianFileByFileIdAndTechnicianId(Long technicianId, TechnicianFile technicianFiles) {
        TechnicianFile technicianFile = technicianFileRepository.findTechnicianFileByFileIdAndTechnicianId(technicianId, technicianFiles.getId());
        if (technicianFile == null) {
            return null;
        }
        technicianFile.setNameFile(technicianFiles.getNameFile());
        technicianFile.setType(technicianFiles.getType());
        technicianFile.setUrlFile(technicianFiles.getUrlFile());
        return technicianFileRepository.save(technicianFile);
    }

    @Override
    public List<TechnicianFile> findAllTechnicianFilesByTechnicianId(Long id) {
        return technicianFileRepository.TechnicianFilesByTechnicianId(id);
    }

    @Override
    public TechnicianDetail findTechnicianDetailById(Long id) {
        return technicianDetailRepository.findTechnicianDetailById(id);
    }

    @Override
    public TechnicianFile findTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId) {
        return technicianFileRepository.findTechnicianFileByFileIdAndTechnicianId(technicianId, fileId);
    }

    @Override
    public TechnicianFile deleteTechnicianFileByFileIdAndTechnicianId(Long technicianId, Long fileId) {
        TechnicianFile technicianFile = technicianFileRepository.findTechnicianFileByFileIdAndTechnicianId(technicianId, fileId);
        if (technicianFile == null) {
            return null;
        }
        technicianFile.setActive(false);
        return technicianFileRepository.save(technicianFile);
    }
}
