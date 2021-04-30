package pinelli.marvelapi.domain.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pinelli.marvelapi.domain.model.Story;

public interface StoryService extends BaseService<Story>{
    Page<Story> findAllByCharacterId(Long characterId, Predicate predicate, Pageable pageable);
}
