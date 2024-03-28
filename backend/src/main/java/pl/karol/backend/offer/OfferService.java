package pl.karol.backend.offer;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.karol.backend.specialization.SpecializationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final SpecializationRepository specializationRepository;

    public OfferResponse getOffers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Offer> pageResult = offerRepository.findAll(paging);
        List<Offer> listOfOffers =  pageResult.getContent();
        List<SingleOfferDto> content = listOfOffers.stream().map(this::mapToDto).toList();
        return OfferResponse.builder()
                .content(content)
                .pageNo(page)
                .pageSize(size)
                .totalPages(pageResult.getTotalPages())
                .totalElements(pageResult.getTotalElements())
                .build();
    }



    public SingleOfferDto updateOffer(Integer id, OfferRequest offerRequest) {
        var specialization = specializationRepository.findById(offerRequest.getSpecializationId()).orElseThrow();

        Offer offer = offerRepository.findById(id).orElseThrow();
        offer = Offer.builder()
                .id(offer.getId())
                .firstname(offerRequest.getFirstname())
                .lastname(offerRequest.getLastname())
                .specialization(specialization)
                .content(offerRequest.getContent())
                .createdAt(offerRequest.getCreatedAt())
                .build();
        return mapToDto(offerRepository.save(offer));
    }

    public void deleteOffer(Integer id) {
        offerRepository.deleteById(id);
    }

    public SingleOfferDto createOffer(OfferRequest offerRequest) {

        var specialization = specializationRepository.findById(offerRequest.getSpecializationId()).orElseThrow();

        Offer offer = Offer.builder()
                .firstname(offerRequest.getFirstname())
                .lastname(offerRequest.getLastname())
                .specialization(specialization)
                .content(offerRequest.getContent())
                .createdAt(offerRequest.getCreatedAt())
                .build();
        return mapToDto(offerRepository.save(offer));
    }
    private SingleOfferDto mapToDto(Offer offer) {
        return SingleOfferDto.builder()
                .id(offer.getId())
                .firstname(offer.getFirstname())
                .lastname(offer.getLastname())
                .specialization(offer.getSpecialization())
                .content(offer.getContent())
                .createdAt(offer.getCreatedAt())
                .build();
    }
}
