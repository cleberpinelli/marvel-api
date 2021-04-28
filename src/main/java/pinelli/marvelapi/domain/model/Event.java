package pinelli.marvelapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "T_EVENT")
@Data
@SuperBuilder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_EVENT")
    private Long id;

    @Column(name = "NM_TITLE")
    private String title;

    @Column(name = "DS_EVENT")
    private String description;

//    urls (Array[Url], optional): A set of public web site URLs for the event.,
//    modified (Date, optional): The date the resource was most recently modified.,
//    start (Date, optional): The date of publication of the first issue in this event.,
//    end (Date, optional): The date of publication of the last issue in this event.,
//    thumbnail (Image, optional): The representative image for this event.,
//    comics (ComicList, optional): A resource list containing the comics in this event.,
//    stories (StoryList, optional): A resource list containing the stories in this event.,
//    series (SeriesList, optional): A resource list containing the series in this event.,
//    characters (CharacterList, optional): A resource list containing the characters which appear in this event.,
//    creators (CreatorList, optional): A resource list containing creators whose work appears in this event.,
//    next (EventSummary, optional): A summary representation of the event which follows this event.,
//    previous (EventSummary, optional): A summary representation of the event which preceded this event.
}
