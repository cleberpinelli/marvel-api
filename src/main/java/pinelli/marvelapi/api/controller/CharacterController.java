package pinelli.marvelapi.api.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinelli.marvelapi.api.http.resources.request.CharacterRequest;
import pinelli.marvelapi.api.http.resources.response.CharacterResponse;
import pinelli.marvelapi.api.http.wrapper.DataWrapper;
import pinelli.marvelapi.domain.model.Character;
import pinelli.marvelapi.domain.service.CharacterService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/character")
public class CharacterController extends BaseController {
    private final CharacterService service;

    private final ModelMapper modelMapper;

    public CharacterController(CharacterService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @Operation(operationId = "findOne",summary = "Find character by Id",tags={"character"})
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        final Character exampleModel = service.findById(id);
        CharacterResponse response = modelMapper.map(exampleModel, CharacterResponse.class);
        return respondOk(response);

    }


    @Operation(operationId = "create",summary = "Create character",tags={"character"})
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody @Valid CharacterRequest exampleModelRequest) {
        Character request = modelMapper.map(exampleModelRequest, Character.class);
        Character created = service.create(request);
        CharacterResponse response = modelMapper.map(created, CharacterResponse.class);
        return respondCreated(response);
    }


    @Operation(operationId = "update",summary = "Update character",tags={"character"})
    @PutMapping(value = "/{characterId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "characterId") Long id, @RequestBody CharacterRequest request) {
        Character data = modelMapper.map(request, Character.class);
        service.update(id, data);
    }


    @Operation(operationId = "delete",summary = "Delete character",tags={"character"})
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void delete(@PathVariable(name = "characterId") Long id) {
        service.delete(id);
    }


    @Operation(operationId = "findall",summary = "Findall characters",tags={"character"})
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAllCharacters(@QuerydslPredicate(root = Character.class) @Parameter(hidden = true) Predicate predicate,  @ParameterObject Pageable pageable) {
        Page<Character> characterPage = service.findAll(predicate, pageable);
        List<CharacterResponse> content = characterPage.stream()
                .map(item -> modelMapper.map(item, CharacterResponse.class))
                .collect(Collectors.toList());

        PageImpl<CharacterResponse> characterResponses = new PageImpl<>(content, pageable, characterPage.getTotalElements());
        DataWrapper dataWrapper = DataWrapper.builder().data(characterResponses)
                .code(200).status("Ok")
                .copyright("© 2021 MARVEL")
                .attributionText("Data provided by Marvel. © 2021 MARVEL")
                .attributionHTML("<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>")
                .etag("28de51bd80a7091fe67288eb4c6b949ec7aa6491").build();
        return respondOk(dataWrapper);
    }

}
