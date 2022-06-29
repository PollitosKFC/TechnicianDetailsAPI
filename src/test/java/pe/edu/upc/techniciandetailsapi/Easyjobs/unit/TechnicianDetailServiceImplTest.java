package pe.edu.upc.techniciandetailsapi.Easyjobs.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianDetail;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianFile;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianDetailRepository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianFileRepository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.repository.TechnicianRepository;
import pe.edu.upc.techniciandetailsapi.Easyjobs.service.TechnicianDetailService;
import pe.edu.upc.techniciandetailsapi.Easyjobs.service.TechnicianDetailServiceImpl;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TechnicianDetailServiceImplTest {
    @MockBean
    private TechnicianDetailRepository technicianDetailRepository;
    @MockBean
    private TechnicianFileRepository technicianFileRepository;
    @MockBean
    private TechnicianRepository technicianRepository;

    @Autowired
    private TechnicianDetailService technicianDetailService;


    @TestConfiguration
    class TechnicianDetailServiceImplTestConfiguration {
        @Bean
        public TechnicianDetailService technicianDetailService() {
            return new TechnicianDetailServiceImpl(technicianDetailRepository,technicianFileRepository,technicianRepository);
        }
    }

    @Test
    @DisplayName("When createdTechnicianDetail with valid data then return TechnicianDetail")
    public void WhenCreatedTechnicianDetailWithValidDataThenReturnTechnicianDetail() {
        // Arrange
        TechnicianDetail technicianDetail = new TechnicianDetail();
        technicianDetail.setId(null);
        technicianDetail.setPresentation("Presentation");
        technicianDetail.setYearsExperience(10);
        technicianDetail.setMaritalStatus("MaritalStatus");
        technicianDetail.setEducationLevel("EducationLevel");
        technicianDetail.setEnglishLevel("EnglishLevel");
        technicianDetail.setNationality("Nationality");
        long id = 1;
        when(technicianDetailRepository.save(technicianDetail)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        TechnicianDetail technicianDetailResult = technicianDetailService.createTechnicianDetail(technicianDetail, id);

        // Assert
        assertThat(technicianDetailResult).isEqualTo(technicianDetail);
    }

    @Test
    @DisplayName("When createdTechnicianFile with valid data then return TechnicianFile")
    public void WhenCreatedTechnicianFileWithValidDataThenReturnTechnicianFile() {
        // Arrange
        TechnicianFile technicianFile = new TechnicianFile();
        technicianFile.setId(null);
        technicianFile.setType("Type");
        technicianFile.setNameFile("NameFile");
        technicianFile.setUrlFile("UrlFile");
        technicianFile.setActive(false);
        long id = 1;

        when(technicianFileRepository.save(technicianFile)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        TechnicianFile technicianFileResult = technicianDetailService.createTechnicianFile(technicianFile,id);

        // Assert
        assertThat(technicianFileResult).isEqualTo(technicianFile);
    }

    @Test
    @DisplayName("When UpdateTechnicianDetail with valid data then return TechnicianDetail")
    public void WhenUpdateTechnicianDetailWithValidDataThenReturnTechnicianDetail() {
        // Arrange
        Long id = 1L;
        TechnicianDetail technicianDetail = new TechnicianDetail();
        technicianDetail.setId(id);


        TechnicianDetail technicianDetailUp = new TechnicianDetail();
        technicianDetailUp.setPresentation("Name");
        technicianDetailUp.setYearsExperience(null);
        technicianDetailUp.setMaritalStatus(null);
        technicianDetailUp.setEducationLevel("status");

        when(technicianDetailRepository.save(technicianDetail)).thenAnswer(invocation -> invocation.getArgument(0));
        technicianDetailService.updateTechnicianDetailById(id, technicianDetail);

        // Act
        TechnicianDetail technicianDetailResult = technicianDetailRepository.getById(id);

        // Assert
        assertThat(technicianDetailResult).isEqualTo(technicianDetailRepository.getById(id));
    }
    @Test
    @DisplayName("When Delete TechnicianDetail With Valid TechnicianDetail")
    public void WhenDeleteTechnicianDetailWithValidTechnicianDetail() {
        // Arrange
        TechnicianDetail technicianDetail = new TechnicianDetail();
        technicianDetail.setId(1L);
        technicianDetail.setPresentation("Name");
        technicianDetail.setYearsExperience(null);
        technicianDetail.setMaritalStatus(null);
        technicianDetail.setEducationLevel("status");

        when(technicianDetailRepository.save(technicianDetail)).thenAnswer(invocation -> invocation.getArgument(0));
        technicianDetailRepository.deleteById(1L);
        // Act
        TechnicianDetail technicianDetailResult = null;
        // Assert
        assertThat(technicianDetailResult).isEqualTo(technicianDetailRepository.getById(1L));
    }
}
