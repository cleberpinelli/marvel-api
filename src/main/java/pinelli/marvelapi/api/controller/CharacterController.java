package pinelli.marvelapi.api.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.modelmapper.ModelMapper;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinelli.marvelapi.api.http.resources.request.CharacterRequest;
import pinelli.marvelapi.api.http.resources.response.CharacterResponse;
import pinelli.marvelapi.api.http.resources.response.StoryResponse;
import pinelli.marvelapi.api.http.wrapper.DataWrapper;
import pinelli.marvelapi.domain.model.Character;
import pinelli.marvelapi.domain.model.Story;
import pinelli.marvelapi.domain.service.CharacterService;
import pinelli.marvelapi.domain.service.StoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController extends BaseController {
    private final CharacterService characterService;
    private final StoryService storyService;

    private final ModelMapper modelMapper;

    public CharacterController(CharacterService characterService, StoryService storyService, ModelMapper modelMapper) {
        this.characterService = characterService;
        this.storyService = storyService;
        this.modelMapper = modelMapper;
    }

    @Operation(operationId = "findOne",summary = "Find character by Id",tags={"character"})
    @GetMapping(value = "/{characterId}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable(name = "characterId") Long id) {
        final Character character = characterService.findById(id);
        CharacterResponse response = modelMapper.map(character, CharacterResponse.class);
        return respondOk(response);

    }


    @Operation(operationId = "create",summary = "Create character",tags={"character"})
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody @Valid CharacterRequest characterRequest) {
        Character request = modelMapper.map(characterRequest, Character.class);
        Character created = characterService.create(request);
        CharacterResponse response = modelMapper.map(created, CharacterResponse.class);
        return respondCreated(response);
    }


    @Operation(operationId = "update",summary = "Update character",tags={"character"})
    @PutMapping(value = "/{characterId}")
    @ResponseBody
    public void update(@PathVariable(name = "characterId") Long id, @RequestBody CharacterRequest request) {
        Character data = modelMapper.map(request, Character.class);
        characterService.update(id, data);
    }


    @Operation(operationId = "delete",summary = "Delete character",tags={"character"})
    @DeleteMapping(value = "/{characterId}")
    @ResponseBody
    public void delete(@PathVariable(name = "characterId") Long id) {
        characterService.delete(id);
    }

    @Operation(operationId = "delete",summary = "Delete character",tags={"character"})
    @GetMapping(value = "/teste")
    @ResponseBody
    public void delete(@RequestParam Map<String,List<Long>> allParams) {
        respondOk(allParams.entrySet());
    }


    @Operation(operationId = "findall",summary = "Findall characters",tags={"character"})
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAllCharacters(@QuerydslPredicate(root = Character.class) @Parameter(hidden = true) Predicate predicate,  @ParameterObject Pageable pageable) {
        Page<Character> characterPage = characterService.findAll(predicate, pageable);
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

    @Operation(operationId = "findStories",summary = "Find stories by Id",tags={"character"})
    @GetMapping(value = "/{characterId}/stories")
    @ResponseBody
    public ResponseEntity<?> findStoriesByCharacterId(@QuerydslPredicate(root = Story.class)
                                                      @Parameter(hidden = true) Predicate predicate,
                                                      @ParameterObject Pageable pageable,
                                                      @PathVariable(name = "characterId") Long id) {
        Page<Story> storyPage = storyService.findAllByCharacterId(id,predicate,pageable);
        List<StoryResponse> content = storyPage.stream()
                .map(item -> modelMapper.map(item, StoryResponse.class))
                .collect(Collectors.toList());
        PageImpl<StoryResponse> storyResponses = new PageImpl<>(content, pageable, storyPage.getTotalElements());
        DataWrapper dataWrapper = DataWrapper.builder().data(storyResponses)
                .code(200).status("Ok")
                .copyright("© 2021 MARVEL")
                .attributionText("Data provided by Marvel. © 2021 MARVEL")
                .attributionHTML("<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>")
                .etag("28de51bd80a7091fe67288eb4c6b949ec7aa6491").build();
        return respondOk(dataWrapper);

    }

    @Operation(operationId = "findComics",summary = "Find comics by Id",tags={"character"})
    @GetMapping(value = "/{characterId}/comics")
    @ResponseBody
    public ResponseEntity<?> findComicsByCharacterId(@PathVariable(name = "characterId") Long id) {
        final Character exampleModel = characterService.findById(id);
        CharacterResponse response = modelMapper.map(exampleModel, CharacterResponse.class);
        return respondOk(response);

    }

    @Operation(operationId = "findEvents",summary = "Find events by Id",tags={"character"})
    @GetMapping(value = "/{characterId}/events")
    @ResponseBody
    public ResponseEntity<?> findEventsByCharacterId(@PathVariable(name = "characterId") Long id) {
        final Character exampleModel = characterService.findById(id);
        CharacterResponse response = modelMapper.map(exampleModel, CharacterResponse.class);
        return respondOk(response);

    }

    @Operation(operationId = "findSeries",summary = "Find series by Id",tags={"character"})
    @GetMapping(value = "/{characterId}/series")
    @ResponseBody
    public ResponseEntity<?> findSeriesByCharacterId(@PathVariable(name = "characterId") Long id) {
        final Character exampleModel = characterService.findById(id);
        CharacterResponse response = modelMapper.map(exampleModel, CharacterResponse.class);
        return respondOk(response);

    }

}
