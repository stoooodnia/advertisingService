package pl.karol.backend.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
