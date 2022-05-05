package pe.edu.upc.techniciandetailsapi.Easyjobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianDetail;
import pe.edu.upc.techniciandetailsapi.Easyjobs.Entity.TechnicianFile;
import pe.edu.upc.techniciandetailsapi.Easyjobs.service.TechnicianDetailService;

import java.util.List;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value="/TechnicianDetail")
public class TechnicianDetailController {

    @Autowired
    private TechnicianDetailService technicianDetailService;

    @PostMapping("/createTechnicianDetail")
    public ResponseEntity<TechnicianDetail> createTechnicianDetail(@RequestBody TechnicianDetail technicianDetail) {
        TechnicianDetail technicianDetailCreated = technicianDetailService.createTechnicianDetail(technicianDetail);
        return ResponseEntity.ok(technicianDetailCreated);
    }

    @PostMapping("/createTechnicianFile")
    public ResponseEntity<TechnicianFile> createTechnicianFile(@RequestBody TechnicianFile technicianFile) {
        TechnicianFile technicianFileCreated = technicianDetailService.createTechnicianFile(technicianFile);
        return ResponseEntity.ok(technicianFileCreated);
    }

    @PutMapping("/updateTechnicianDetailById/{id}")
    public ResponseEntity<TechnicianDetail> updateTechnicianDetailById(@PathVariable Long id, @RequestBody TechnicianDetail technicianDetail) {
        TechnicianDetail technicianDetailUpdated = technicianDetailService.updateTechnicianDetailById(id, technicianDetail);
        return ResponseEntity.ok(technicianDetailUpdated);
    }

    @PutMapping("/updateTechnicianFileByFileIdAndTechnicianId/{id}")
    public ResponseEntity<TechnicianFile> updateTechnicianFileByFileIdAndTechnicianId(@PathVariable Long id, @RequestBody TechnicianFile technicianFile) {
        TechnicianFile technicianFileUpdated = technicianDetailService.updateTechnicianFileByFileIdAndTechnicianId(id, technicianFile);
        return ResponseEntity.ok(technicianFileUpdated);
    }

    @GetMapping("/technicianDetailByTechnicianId")
    public ResponseEntity<TechnicianDetail> findTechnicianDetailByTechnicianId(@RequestParam(name = "technicianId",required = false) Long technicianId) {
        TechnicianDetail technicianDetail = technicianDetailService.findTechnicianDetailById(technicianId);
        if (technicianDetail == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicianDetail);
    }

    @GetMapping("/technicianFileByFileIdAndTechnicianId")
    public ResponseEntity<TechnicianFile> findTechnicianFileByFileIdAndTechnicianId(@RequestParam(name = "fileId",required = false) Long fileId,
                                                                                     @RequestParam(name = "technicianId",required = false) Long technicianId) {
        TechnicianFile technicianFile = technicianDetailService.findTechnicianFileByFileIdAndTechnicianId(fileId, technicianId);
        if (technicianFile == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicianFile);
    }

    @GetMapping("/AlltechnicianFilesByTechnicianId")
    public ResponseEntity<List<TechnicianFile>> findAllTechnicianFilesByTechnicianId(@RequestParam(name = "technicianId",required = false) Long technicianId) {
        List<TechnicianFile> technicianFiles = technicianDetailService.findAllTechnicianFilesByTechnicianId(technicianId);
        if (technicianFiles == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicianFiles);
    }

    @GetMapping("/technicianDetailById")
    public ResponseEntity<TechnicianDetail> findTechnicianDetailById(@RequestParam(name = "id",required = false) Long id) {
        TechnicianDetail technicianDetail = technicianDetailService.findTechnicianDetailById(id);
        if (technicianDetail == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicianDetail);
    }

    @DeleteMapping("/technicianFileByFileIdAndTechnicianId")
    public ResponseEntity<TechnicianFile> deleteTechnicianFileByFileIdAndTechnicianId(@RequestParam(name = "fileId",required = false) Long fileId,
                                                                                     @RequestParam(name = "technicianId",required = false) Long technicianId) {
        TechnicianFile technicianFile = technicianDetailService.deleteTechnicianFileByFileIdAndTechnicianId(fileId, technicianId);
        if (technicianFile == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicianFile);
    }
}
