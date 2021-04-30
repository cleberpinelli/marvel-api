package pinelli.marvelapi.api.http.resources.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoryResponse {
    @Schema(description = "resourceURI")
    private String resourceURI;

    @Schema(description = "Name")
    private String title;

    @Schema(description = "Type")
    private String type;
}
