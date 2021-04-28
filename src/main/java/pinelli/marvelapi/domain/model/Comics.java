package pinelli.marvelapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "T_COMICS")
@Data
@SuperBuilder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Comics extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_COMICS")
    private Long id;

    @Column(name = "ID_DIGITAL")
    private Integer digitalId;

    @Column(name = "NM_TITLE")
    private String title;

    @Column(name = "NR_ISSUE")
    private Long issueNumber;

    @Column(name = "DS_VARIANT")
    private String variantDescription;

    @Column(name = "DS_COMICS")
    private String description;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "UPC")
    private String upc;

    @Column(name = "CD_DIAMOND")
    private String diamondCode;

    @Column(name = "EAN")
    private String ean;

    @Column(name = "ISSN")
    private String issn;

    @Column(name = "FORMAT")
    private String format;

    @Column(name = "CT_PAGE")
    private String pageCount;

    //textObjects
//    resourceURI (string, optional): The canonical URL identifier for this resource.,
//    urls (Array[Url], optional): A set of public web site URLs for the resource.,
//    series (SeriesSummary, optional): A summary representation of the series to which this comic belongs.,
//    variants (Array[ComicSummary], optional): A list of variant issues for this comic (includes the "original" issue if the current issue is a variant).,
//    collections (Array[ComicSummary], optional): A list of collections which include this comic (will generally be empty if the comic's format is a collection).,
//            collectedIssues (Array[ComicSummary], optional): A list of issues collected in this comic (will generally be empty for periodical formats such as "comic" or "magazine").,
//    dates (Array[ComicDate], optional): A list of key dates for this comic.,
//    prices (Array[ComicPrice], optional): A list of prices for this comic.,
//    thumbnail (Image, optional): The representative image for this comic.,
//    images (Array[Image], optional): A list of promotional images associated with this comic.,
//    creators (CreatorList, optional): A resource list containing the creators associated with this comic.,
//    characters (CharacterList, optional): A resource list containing the characters which appear in this comic.,
//    stories (StoryList, optional): A resource list containing the stories which appear in this comic.,
//    events (EventList, optional): A resource list containing the events in which this comic appears.

}
