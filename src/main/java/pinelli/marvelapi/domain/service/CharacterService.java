package pinelli.marvelapi.domain.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pinelli.marvelapi.domain.model.Character;

public interface CharacterService extends BaseService<Character> {
    Page<Character> findAll(Predicate predicate, Pageable pageable);
}
