package kz.iitu.detector.domain.word.repository;

import kz.iitu.detector.domain.word.model.Words;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends CrudRepository<Words, Long> {

}
