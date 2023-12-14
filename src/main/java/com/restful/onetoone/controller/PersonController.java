package com.restful.onetoone.controller;

import com.restful.onetoone.dto.PersonDTO;
import com.restful.onetoone.dto.PersonDepartmentDTO;
import com.restful.onetoone.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Controlador REST para manipular operações relacionadas à entidade Person.
 */
@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

    private final PersonService personService;

    /**
     * Construtor para injetar a dependência do serviço PersonService.
     *
     * @param personService O serviço PersonService a ser injetado.
     */
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Endpoint para inserir uma nova entidade Person com base nos dados fornecidos no DTO.
     *
     * @param dto O DTO contendo os dados da entidade Person a ser inserida.
     * @return Uma resposta HTTP com o corpo contendo o PersonDepartmentDTO resultante da inserção.
     */
    @PostMapping
    public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody PersonDepartmentDTO dto) {
        // Realiza a inserção utilizando o serviço PersonService
        dto = personService.insert(dto);

        // Constrói a URI para o recurso recém-criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        // Retorna uma resposta com o código HTTP 201 (Created) e o corpo contendo o DTO
        return ResponseEntity.created(uri).body(dto);
    }

    /**
     * Endpoint para inserir uma nova entidade Person com base nos dados fornecidos no DTO.
     *
     * @param dto O DTO contendo os dados da entidade Person a ser inserida.
     * @return Uma resposta HTTP com o corpo contendo o PersonDTO resultante da inserção.
     */
    @PostMapping("/insert")
    public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO dto) {
        dto = personService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
