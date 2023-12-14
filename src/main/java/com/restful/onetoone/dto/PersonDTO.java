package com.restful.onetoone.dto;

import com.restful.onetoone.entity.Person;
import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private Double salary;
    private Long departmentId;

    public PersonDTO(Person entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.salary = entity.getSalary();
        this.departmentId = entity.getDepartment().getId();
    }

    public PersonDTO(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(this.getClass() == o.getClass())) return false;

        PersonDTO that = (PersonDTO) o;

        return Objects.equals(this.getId(), that.getId()) &&
                Objects.equals(this.getName(), that.getName()) &&
                Objects.equals(this.getSalary(), that.getSalary()) &&
                Objects.equals(this.getDepartmentId(), that.getDepartmentId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.getId() == null) ? 0 : this.getId().hashCode());
        hash *= prime + ((this.getName() == null) ? 0 : this.getName().hashCode());
        hash *= prime + ((this.getSalary() == null) ? 0 : this.getSalary().hashCode());
        hash *= prime + ((this.getDepartmentId() == null) ? 0 : this.getDepartmentId().hashCode());

        if (hash < 0) 
            hash *= -1;

        return hash;
    }


    @Override
    public String toString() {
        return "{\n" +
                "  \"departmentId\": " + this.departmentId + ",\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\",\n" +
                "  \"salary\": " + this.salary + "\n" +
                "}";
    }

}
