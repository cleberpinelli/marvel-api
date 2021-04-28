package pinelli.marvelapi.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
@RequestMapping(value = "/exemplo")
public class CharacterController extends BaseController {
    private final CharacterService service;

    private final ModelMapper modelMapper;

    public CharacterController(CharacterService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(value = "Buscar exemplo por ID", nickname = "getExemploById", notes = "Returns a single Exemplo", response = CharacterResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CharacterResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Exemplo not found")})

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        final Character exampleModel = service.findById(id);
        CharacterResponse response = modelMapper.map(exampleModel, CharacterResponse.class);
        return respondOk(response);

    }


    @ApiOperation(value = "Criar novo exemplo", nickname = "addExemplo", notes = "Criar exemplo")
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


    @ApiOperation(value = "Atualizar ExampleModel existente ", nickname = "updateExampleModel", notes = "Atualiza ExampleModel", response = CharacterResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "successful operation", response = CharacterResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})

    @PutMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "id") Long id, @RequestBody CharacterRequest request) {
        Character data = modelMapper.map(request, Character.class);
        service.update(id, data);
    }


    @ApiOperation(value = "Deletar ExampleModel existente ", nickname = "deleteExampleModel", notes = "deleta ExampleModel", response = CharacterResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CharacterResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "ExampleModel not found")})

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }


    @ApiOperation(value = "Buscar ExampleModels", nickname = "findAll", notes = "Multiple search parasm can be provided", response = Character.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Character.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAll(Pageable pageable) {
        Page<Character> exampleModelPage = service.findAll(pageable);
        List<CharacterResponse> content = exampleModelPage.stream()
                .map(item -> modelMapper.map(item, CharacterResponse.class))
                .collect(Collectors.toList());
        Page<CharacterResponse> exampleModelResponses = new PageImpl<>(content, pageable, exampleModelPage.getTotalElements());
        return respondOk(exampleModelResponses);
    }
}
