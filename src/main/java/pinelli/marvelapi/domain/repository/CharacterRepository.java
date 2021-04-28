package pinelli.marvelapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import pinelli.marvelapi.domain.model.Character;

public interface CharacterRepository extends RevisionRepository<Character, Long, Integer>, JpaRepository<Character, Long> {
}
