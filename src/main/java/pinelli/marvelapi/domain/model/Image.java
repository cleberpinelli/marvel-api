package pinelli.marvelapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "T_IMAGE")
@Audited
@Data
@SuperBuilder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_IMAGE")
    private Long id;

    @Column(name = "PATH")
    private String path;

    @Column(name = "EXTENSION")
    private String extension;
}
