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
        List<SingleSpecializationDto> content = specializations.stream().map(this::mapToDto).toList();
        return SpecializationResponse.builder()
                .content(content)
                .build();
    }
    public SingleSpecializationDto addSpecialization(SpecializationRequest specializationRequest) {
        Specialization specialization = Specialization.builder()
                .label(specializationRequest.getLabel())
                .build();
        return mapToDto(specializationRepository.save(specialization));
    }

    private SingleSpecializationDto mapToDto(Specialization specialization) {
        return SingleSpecializationDto.builder()
                .id(specialization.getId())
                .label(specialization.getLabel())
                .build();
    }
}
