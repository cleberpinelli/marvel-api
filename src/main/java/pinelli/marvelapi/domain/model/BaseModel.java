package pinelli.marvelapi.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    @LastModifiedDate
    @Column(name = "DT_MODIFICACAO")
    protected LocalDateTime modified;

    @Column(name = "RESOURCE_URI")
    protected String resourceURI;
}
