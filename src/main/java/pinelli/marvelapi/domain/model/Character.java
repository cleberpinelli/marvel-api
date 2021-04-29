package pinelli.marvelapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_CHARACTER")
@Data
@SuperBuilder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Character extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CHARACTER")
    private Long id;

    @Column(name = "NM_CHARACTER")
    private String name;

    @Column(name = "DS_CHARACTER")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_IMAGE", foreignKey = @ForeignKey(name = "CH_IMG_FK"))
    private Image thumbnail;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_CHARACTER_COMICS",
            joinColumns = @JoinColumn(name = "ID_CHARACTER", foreignKey = @ForeignKey(name = "CHCM_CH_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_COMICS", foreignKey = @ForeignKey(name = "CHCM_CM_FK")))
    List<Comics> comicsList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_CHARACTER_STORY",
            joinColumns = @JoinColumn(name = "ID_CHARACTER", foreignKey = @ForeignKey(name = "CHST_CH_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_STORY", foreignKey = @ForeignKey(name = "CHST_ST_FK")))
    List<Story> storyList;

    @ManyToMany
    @JoinTable(name = "T_CHARACTER_EVENT",
            joinColumns = @JoinColumn(name = "ID_CHARACTER", foreignKey = @ForeignKey(name = "CHEV_CH_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_EVENT", foreignKey = @ForeignKey(name = "CHEV_EV_FK")))
    List<Event> eventList;

    @ManyToMany
    @JoinTable(name = "T_CHARACTER_SERIE",
            joinColumns = @JoinColumn(name = "ID_CHARACTER", foreignKey = @ForeignKey(name = "CHSE_CH_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_SERIE", foreignKey = @ForeignKey(name = "CHSE_SE_FK")))
    List<Serie> seriesList;
}
