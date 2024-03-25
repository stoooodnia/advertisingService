package pl.karol.backend.specialization;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/specializations")
@RequiredArgsConstructor
public class SpecializationController {

        private final SpecializationService specializationService;

    @GetMapping("/")
    public ResponseEntity<SpecializationResponse> getSpecializations() {
        return ResponseEntity.ok(specializationService.getSpecializations());
    }
}
