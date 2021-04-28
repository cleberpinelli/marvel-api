package pinelli.marvelapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "T_SERIE")
@Data
@SuperBuilder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Serie extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SERIE")
    private Long id;

    @Column(name = "NM_TITLE")
    private String title;

    @Column(name = "DS_SERIE")
    private String description;

    //urls (Array[Url], optional): A set of public web site URLs for the resource.,
//    startYear (int, optional): The first year of publication for the series.,
//    endYear (int, optional): The last year of publication for the series (conventionally, 2099 for ongoing series) .,
//    rating (string, optional): The age-appropriateness rating for the series.,
//    thumbnail (Image, optional): The representative image for this series.,
//    comics (ComicList, optional): A resource list containing comics in this series.,
//    stories (StoryList, optional): A resource list containing stories which occur in comics in this series.,
//    events (EventList, optional): A resource list containing events which take place in comics in this series.,
//    characters (CharacterList, optional): A resource list containing characters which appear in comics in this series.,
//    creators (CreatorList, optional): A resource list of creators whose work appears in comics in this series.,
//    next (SeriesSummary, optional): A summary representation of the series which follows this series.,
//    previous (SeriesSummary, optional): A summary representation of the series which preceded this series.
}
