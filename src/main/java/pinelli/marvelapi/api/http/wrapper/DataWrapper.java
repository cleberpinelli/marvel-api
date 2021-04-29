package pinelli.marvelapi.api.http.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageImpl;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataWrapper {
    private Integer code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private PageImpl<?> data;
}
