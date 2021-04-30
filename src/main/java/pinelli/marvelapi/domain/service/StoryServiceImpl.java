package pinelli.marvelapi.domain.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pinelli.marvelapi.domain.model.Story;
import pinelli.marvelapi.domain.repository.CharacterRepository;
import pinelli.marvelapi.domain.repository.StoryRepository;

@Service
public class StoryServiceImpl implements StoryService{
    private final StoryRepository repository;

    public StoryServiceImpl(StoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Story> findAllByCharacterId(Long characterId, Predicate predicate, Pageable pageable) {
        return null;//repository.findAllByCharacterId(predicate, pageable,characterId);
    }

    @Override
    public Story create(Story entity) {
        return null;
    }

    @Override
    public Story findById(Long id) {
        return null;
    }

    @Override
    public Page<Story> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(Long id, Story entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
