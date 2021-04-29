package pinelli.marvelapi.api.http.resources.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoryRequest {
    @Schema(description = "resourceURI")
    private String resourceURI;

    @Schema(description = "Name")
    private String title;

    @Schema(description = "Type")
    private String type;

}
