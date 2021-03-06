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
public class CharacterRequest {

    @Schema(description = "Name")
    private String name;

    @Schema(description = "Description")
    private String description;

}
