package pinelli.marvelapi.api.http.resources.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pinelli.marvelapi.api.http.resources.request.StoryRequest;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponse {

    @Schema(description = "Id")
    private Long id;

    @Schema(description = "Name")
    private String name;

    @Schema(description = "Description")
    private String description;

    @Schema(description = "Modified")
    private String modified;

    @Schema(description = "resourceURI")
    private String resourceURI;

    @Schema(description = "stories")
    List<StoryRequest> storyList;
//    private Url[] urls;
//
//    private Image thumbnail;
//
//    List<Comics> comicsList;
//
//    List<Event> eventList;
//
//    List<Serie> seriesList;
}
