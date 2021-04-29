package pinelli.marvelapi.domain.service;

import com.querydsl.core.types.Predicate;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pinelli.marvelapi.domain.exception.NotFoundException;
import pinelli.marvelapi.domain.model.Character;
import pinelli.marvelapi.domain.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Character create(Character entity) {
        return repository.save(entity);
    }

    @Override
    public Character findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Exemplo não encontrado."));
    }

    @Override
    public Page<Character> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Character> findAll(Predicate predicate, Pageable pageable) {
        return repository.findAll(predicate, pageable);
    }

    @Override
    public void update(Long id, Character entity) {
        Character character = findById(id);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        mapper.map(entity, character);

        repository.save(character);
    }

    @Override
    public void delete(Long id) {
        Character character = findById(id);
        repository.delete(character);
    }
}
