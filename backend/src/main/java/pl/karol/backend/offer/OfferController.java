package pl.karol.backend.offer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("")
    public ResponseEntity<OfferResponse> getOffers (
            @RequestParam(value="page", defaultValue="0", required=false) int page,
            @RequestParam(value="size", defaultValue="8", required=false) int size) {
        return ResponseEntity.ok(offerService.getOffers(page, size));
    }

    @GetMapping("/{search}")
    public ResponseEntity<OfferResponse> searchOffers (
            @PathVariable String search,
            @RequestParam(value="page", defaultValue="0", required=false) int page,
            @RequestParam(value="size", defaultValue="8", required=false) int size) {
        return ResponseEntity.ok(offerService.searchOffers(search, page, size));
    }

    @PostMapping("")
    public ResponseEntity<SingleOfferDto> createOffer(
            @Valid
            @RequestBody OfferRequest offerRequest) {
        return ResponseEntity.ok(offerService.createOffer(offerRequest));
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<SingleOfferDto> updateOffer(
            @PathVariable Integer id,
            @Valid
            @RequestBody OfferRequest offerRequest) {
        return ResponseEntity.ok(offerService.updateOffer(id, offerRequest));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(
            @PathVariable Integer id) {
        offerService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

}
