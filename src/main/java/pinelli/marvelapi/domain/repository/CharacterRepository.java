package pinelli.marvelapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.history.RevisionRepository;
import pinelli.marvelapi.domain.model.Character;
import pinelli.marvelapi.domain.model.QCharacter;

public interface CharacterRepository extends RevisionRepository<Character, Long, Integer>, JpaRepository<Character, Long>,
        QuerydslPredicateExecutor<Character>, QuerydslBinderCustomizer<QCharacter> {

    @Override
    default void customize(QuerydslBindings bindings, QCharacter root){
        //bindings.bind(root.oid).first(SimpleExpression::in);
        //bindings.bind(root.titulo).first(StringExpression::containsIgnoreCase);
        //bindings.bind(root.descricao).first(StringExpression::containsIgnoreCase);
    }
}
