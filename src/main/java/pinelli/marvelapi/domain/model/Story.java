package pinelli.marvelapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_STORY")
@Data
@SuperBuilder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Story extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_STORY")
    private Long id;

    @Column(name = "NM_TITLE")
    private String title;

    @Column(name = "DS_STORY")
    private String description;

    @Column(name = "TP_STORY")
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_IMAGE", foreignKey = @ForeignKey(name = "ST_IMG_FK"))
    private Image thumbnail;

    @ManyToMany
    @JoinTable(name = "T_STORY_COMICS",
            joinColumns = @JoinColumn(name = "ID_STORY", foreignKey = @ForeignKey(name = "STCM_ST_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_COMICS", foreignKey = @ForeignKey(name = "STCM_CM_FK")))
    List<Comics> comicList;

    @ManyToMany
    @JoinTable(name = "T_STORY_EVENT",
            joinColumns = @JoinColumn(name = "ID_STORY", foreignKey = @ForeignKey(name = "STEV_ST_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_EVENT", foreignKey = @ForeignKey(name = "STEV_EV_FK")))
    List<Event> eventList;

    @ManyToMany
    @JoinTable(name = "T_STORY_SERIE",
            joinColumns = @JoinColumn(name = "ID_STORY", foreignKey = @ForeignKey(name = "STSE_ST_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_SERIE", foreignKey = @ForeignKey(name = "STSE_SE_FK")))
    List<Serie> seriesList;

    @ManyToMany
    @JoinTable(name = "T_STORY_CHARACTER",
            joinColumns = @JoinColumn(name = "ID_STORY", foreignKey = @ForeignKey(name = "STCH_ST_FK")),
            inverseJoinColumns = @JoinColumn(name = "ID_CHARACTER", foreignKey = @ForeignKey(name = "STCH_CH_FK")))
    List<Character> characterList;

//    creators (CreatorList, optional): A resource list of creators who worked on this story.,
//    originalissue (ComicSummary, optional): A summary representation of the issue in which this story was originally published.

}
