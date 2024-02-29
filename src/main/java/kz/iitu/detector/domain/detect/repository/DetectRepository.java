package kz.iitu.detector.domain.detect.repository;

import kz.iitu.detector.domain.detect.model.Detect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectRepository extends CrudRepository<Detect, Long> {



}
