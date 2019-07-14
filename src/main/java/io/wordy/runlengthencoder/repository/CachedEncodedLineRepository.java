package io.wordy.runlengthencoder.repository;

import io.wordy.runlengthencoder.model.CachedEncodedLine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface CachedEncodedLineRepository extends PagingAndSortingRepository<CachedEncodedLine, Long> {

    @Query("select l from CachedEncodedLine l where l.startIndex <= ?1 and l.endIndex >= ?1")
    Optional<CachedEncodedLine> findByIndex(long index);

    @Query("select MAX(l.endIndex) from CachedEncodedLine l")
    Long findLastCachedEncodedLine();
}
