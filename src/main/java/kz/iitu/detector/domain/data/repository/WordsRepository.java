package kz.iitu.detector.domain.data.repository;

import kz.iitu.detector.domain.data.model.Words;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends CrudRepository<Words, Long> {

}
