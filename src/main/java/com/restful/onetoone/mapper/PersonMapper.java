package com.restful.onetoone.mapper;

import com.restful.onetoone.dto.DepartmentDTO;
import com.restful.onetoone.dto.PersonDTO;
import com.restful.onetoone.dto.PersonDepartmentDTO;
import com.restful.onetoone.entity.Department;
import com.restful.onetoone.entity.Person;

/**
 * Uma classe de mapeamento para converter entre entidades e DTOs relacionados às entidades Person e Department.
 * Esta classe fornece métodos estáticos para mapear entidades Person para PersonDTOs, entidades Person para
 * PersonDepartmentDTOs e vice-versa, bem como mapear entidades Department para DepartmentDTOs e vice-versa.
 */
public class PersonMapper {

    /**
     * Converte uma entidade Person para um PersonDTO.
     *
     * @param entity A entidade Person a ser convertida.
     * @return Um PersonDTO representando a entidade convertida.
     */
    public static PersonDTO toEntityPersonDTO(Person entity) {
        return new PersonDTO(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                entity.getDepartment().getId()
        );
    }

    /**
     * Converte um PersonDTO para uma entidade Person.
     *
     * @param dto O PersonDTO a ser convertido.
     * @return Uma entidade Person representando o DTO convertido.
     */
    public static Person toEntityPerson(PersonDTO dto) {
        return new Person(
                dto.getId(),
                dto.getName(),
                dto.getSalary()
        );
    }

    /**
     * Converte uma entidade Person para um PersonDepartmentDTO.
     *
     * @param entity A entidade Person a ser convertida.
     * @return Um PersonDepartmentDTO representando a entidade convertida.
     */
    public static PersonDepartmentDTO toDto(Person entity) {
        return new PersonDepartmentDTO(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                toDepartmentDto(entity.getDepartment())
        );
    }

    /**
     * Converte um PersonDepartmentDTO para uma entidade Person.
     *
     * @param dto O PersonDepartmentDTO a ser convertido.
     * @return Uma entidade Person representando o DTO convertido.
     */
    public static Person toEntityPerson(PersonDepartmentDTO dto) {
        return new Person(
                dto.getId(),
                dto.getName(),
                dto.getSalary(),
                toDepartmentEntity(dto.getDepartment())
        );
    }

    /**
     * Converte uma entidade Department para um DepartmentDTO.
     *
     * @param department A entidade Department a ser convertida.
     * @return Um DepartmentDTO representando a entidade convertida.
     */
    private static DepartmentDTO toDepartmentDto(Department department) {
        return new DepartmentDTO(
                department.getId(),
                department.getName()
        );
    }

    /**
     * Converte um DepartmentDTO para uma entidade Department.
     *
     * @param departmentDTO O DepartmentDTO a ser convertido.
     * @return Uma entidade Department representando o DTO convertido.
     */
    private static Department toDepartmentEntity(DepartmentDTO departmentDTO) {
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getName()
        );
    }
}