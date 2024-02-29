package kz.iitu.detector.domain.purchase.repository;

import kz.iitu.detector.domain.purchase.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
