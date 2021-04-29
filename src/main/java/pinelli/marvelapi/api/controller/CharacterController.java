package pinelli.marvelapi.api.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinelli.marvelapi.api.http.resources.request.CharacterRequest;
import pinelli.marvelapi.api.http.resources.response.CharacterResponse;
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

    @ApiOperation(value = "Buscar character por Id", nickname = "getCharacterById", notes = "Returns a single character", response = CharacterResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CharacterResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "character not found")})

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        final Character exampleModel = service.findById(id);
        CharacterResponse response = modelMapper.map(exampleModel, CharacterResponse.class);
        return respondOk(response);

    }


    @ApiOperation(value = "Criar novo character", nickname = "addCharacter", notes = "Criar character")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody @Valid CharacterRequest exampleModelRequest) {
        Character request = modelMapper.map(exampleModelRequest, Character.class);
        Character created = service.create(request);
        CharacterResponse response = modelMapper.map(created, CharacterResponse.class);
        return respondCreated(response);
    }


    @ApiOperation(value = "Atualizar character existente ", nickname = "updateCharacterModel", notes = "Atualiza character", response = CharacterResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "successful operation", response = CharacterResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "character not found")})

    @PutMapping(value = "/{characterId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "characterId") Long id, @RequestBody CharacterRequest request) {
        Character data = modelMapper.map(request, Character.class);
        service.update(id, data);
    }


    @ApiOperation(value = "Deletar character existente ", nickname = "deleteCharacterModel", notes = "deleta character", response = CharacterResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CharacterResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "character not found")})

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void delete(@PathVariable(name = "characterId") Long id) {
        service.delete(id);
    }


    @ApiOperation(value = "Buscar characters", nickname = "findAll", notes = "Multiple search parasm can be provided", response = Character.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Character.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAllCharacters(@QuerydslPredicate(root = Character.class) Predicate predicate, Pageable pageable) {
        Page<Character> characterPage = service.findAll(predicate, pageable);
        List<CharacterResponse> content = characterPage.stream()
                .map(item -> modelMapper.map(item, CharacterResponse.class))
                .collect(Collectors.toList());

        PageImpl<CharacterResponse> characterResponses = new PageImpl<>(content, pageable, characterPage.getTotalElements());
        return respondOk(characterResponses);
    }



//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<?> findAll(Pageable pageable) {
//        Page<Character> exampleModelPage = service.findAll(pageable);
//        List<CharacterResponse> content = exampleModelPage.stream()
//                .map(item -> modelMapper.map(item, CharacterResponse.class))
//                .collect(Collectors.toList());
//        Page<CharacterResponse> exampleModelResponses = new PageImpl<>(content, pageable, exampleModelPage.getTotalElements());
//        return respondOk(exampleModelResponses);
//    }
}
