package pl.karol.backend.specialization;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specializations")
@RequiredArgsConstructor
public class SpecializationController {

        private final SpecializationService specializationService;

    @GetMapping("")
    public ResponseEntity<SpecializationResponse> getSpecializations() {
        return ResponseEntity.ok(specializationService.getSpecializations());
    }

    @PostMapping("")
    public ResponseEntity<SingleSpecializationDto> addSpecialization(
            @Valid
            @RequestBody
            SpecializationRequest specializationRequest) {
        return ResponseEntity.ok(specializationService.addSpecialization(specializationRequest));
    }

}
