package com.restful.onetoone.dto;

import com.restful.onetoone.entity.Person;
import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDepartmentDTO {

    private Long id;
    private String name;
    private Double salary;
    private DepartmentDTO department;

    public PersonDepartmentDTO(Person entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.salary = entity.getSalary();
        this.department = new DepartmentDTO(entity.getDepartment());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(this.getClass() == o.getClass())) return false;

        PersonDepartmentDTO that = (PersonDepartmentDTO) o;

        return Objects.equals(this.getId(), that.getId()) &&
                Objects.equals(this.getName(), that.getName()) &&
                Objects.equals(this.getSalary(), that.getSalary()) &&
                Objects.equals(this.getDepartment(), that.getDepartment());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.getId() == null) ? 0 : this.getId().hashCode());
        hash *= prime + ((this.getName() == null) ? 0 : this.getName().hashCode());
        hash *= prime + ((this.getSalary() == null) ? 0 : this.getSalary().hashCode());
        hash *= prime + ((this.getDepartment() == null) ? 0 : this.getDepartment().hashCode());

        if (hash < 0) 
            hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"department\": " + this.department + ",\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\",\n" +
                "  \"salary\": " + this.salary + "\n" +
                "}";
    }

}
