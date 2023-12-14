package com.restful.onetoone.service.impl;

import com.restful.onetoone.dto.PersonDTO;
import com.restful.onetoone.dto.PersonDepartmentDTO;
import com.restful.onetoone.entity.Department;
import com.restful.onetoone.entity.Person;
import com.restful.onetoone.mapper.PersonMapper;
import com.restful.onetoone.repository.DepartmentRepository;
import com.restful.onetoone.repository.PersonRepository;
import com.restful.onetoone.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * Implementação da interface PersonService que gerencia operações relacionadas a Person.
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final DepartmentRepository departmentRepository;

    /**
     * Construtor que injeta as dependências necessárias para a classe.
     *
     * @param personRepository     O repositório de PersonRepository a ser injetado.
     * @param departmentRepository O repositório de DepartmentRepository a ser injetado.
     */
    public PersonServiceImpl(PersonRepository personRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;
    }

    /**
     * Insere uma nova entidade Person com base nos dados fornecidos no DTO.
     *
     * @param dto O DTO contendo os dados da entidade Person a ser inserida.
     * @return Um PersonDepartmentDTO representando a entidade Person recém-inserida.
     * @throws IllegalArgumentException Se o departamento não for encontrado.
     */
    @Override
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        // Converte DTO para entidade Person
        Person person = PersonMapper.toEntityPerson(dto);

        // Obtém o nome do departamento usando o DepartmentRepository
        String departmentName = departmentRepository.findById(dto.getDepartment().getId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found"))
                .getName();

        // Define o nome do departamento na entidade Person
        person.getDepartment().setName(departmentName);

        // Salva a entidade Person no repositório
        personRepository.save(person);

        // Converte a entidade Person de volta para DTO
        return PersonMapper.toDto(person);
    }

    /**
     * Insere uma nova entidade Person com base nos dados fornecidos no DTO.
     *
     * @param dto O DTO contendo os dados da entidade Person a ser inserida.
     * @return Um PersonDTO representando a entidade Person recém-inserida.
     */
    public PersonDTO insert(PersonDTO dto) {
        // Converte DTO para entidade Person
        Person person = PersonMapper.toEntityPerson(dto);
        
        Department department = new Department();
        department.setId(dto.getDepartmentId());
        person.setDepartment(department);
        
        // Salva a entidade Person no repositório
        personRepository.save(person);
        
        // Converte a entidade Person de volta para DTO
        return PersonMapper.toEntityPersonDTO(person);
    }
}