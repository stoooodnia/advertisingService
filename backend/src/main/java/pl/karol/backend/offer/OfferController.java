package pl.karol.backend.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/")
    public ResponseEntity<OfferResponse> getOffers (
            @RequestParam(value="page", defaultValue="0", required=false) int page,
            @RequestParam(value="size", defaultValue="9", required = false) int size) {
        return ResponseEntity.ok(offerService.getOffers(page, size));
    }

    @PostMapping("/")
    public ResponseEntity<OfferDto> createOffer(
            @RequestBody OfferDto offerDto) {
        return ResponseEntity.ok(offerService.createOffer(offerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferDto> updateOffer(
            @PathVariable Integer id,
            @RequestBody OfferDto offerDto) {
        return ResponseEntity.ok(offerService.updateOffer(id, offerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(
            @PathVariable Integer id) {
        offerService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

}
