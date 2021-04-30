package pinelli.marvelapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.history.RevisionRepository;
import pinelli.marvelapi.domain.model.QStory;
import pinelli.marvelapi.domain.model.Story;

public interface StoryRepository extends RevisionRepository<Story, Long, Integer>, JpaRepository<Story, Long>,
        QuerydslPredicateExecutor<Story>, QuerydslBinderCustomizer<QStory> {

    @Override
    default void customize(QuerydslBindings bindings, QStory root){
        //bindings.bind(root.oid).first(SimpleExpression::in);
        //bindings.bind(root.titulo).first(StringExpression::containsIgnoreCase);
        //bindings.bind(root.descricao).first(StringExpression::containsIgnoreCase);
    }
}
