package pl.karol.backend.specialization;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    public SpecializationResponse getSpecializations() {
        // todo: think about pagination
        List<Specialization> specializations = specializationRepository.findAll();
        List<SpecializationDto> content = specializations.stream().map(this::mapToDto).toList();
        return SpecializationResponse.builder()
                .content(content)
                .build();
    }

    private SpecializationDto mapToDto(Specialization specialization) {
        return SpecializationDto.builder()
                .id(specialization.getId())
                .label(specialization.getLabel())
                .build();
    }
}
