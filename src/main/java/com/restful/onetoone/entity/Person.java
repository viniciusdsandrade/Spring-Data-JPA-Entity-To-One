package com.restful.onetoone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Person")
@Table(name = "tb_person",
        schema = "db_one_to_one")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Person(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Person(Long id,
                  String name,
                  Double salary,
                  Department departmentEntity) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = departmentEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(this.getId(), person.getId()) &&
                Objects.equals(this.getName(), person.getName()) &&
                Objects.equals(this.getSalary(), person.getSalary()) &&
                Objects.equals(this.getDepartment(), person.getDepartment());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.getId() == null) ? 0 : this.getId().hashCode());
        hash *= prime + ((this.getName() == null) ? 0 : this.getName().hashCode());
        hash *= prime + ((this.getSalary() == null) ? 0 : this.getSalary().hashCode());

        Department department = this.getDepartment();
        hash *= prime + ((department == null) ? 0 : department.hashCode());

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