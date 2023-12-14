package com.restful.onetoone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Department")
@Table(name = "tb_department",
        schema = "db_one_to_one")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department")
    @Setter(AccessLevel.NONE)
    private List<Person> people = new ArrayList<>();

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(this.getClass() == o.getClass())) return false;

        Department that = (Department) o;

        return Objects.equals(this.getId(), that.getId()) &&
                Objects.equals(this.getName(), that.getName()) &&
                Objects.equals(this.getPeople(), that.getPeople());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.getId() == null) ? 0 : this.getId().hashCode());
        hash *= prime + ((this.getName() == null) ? 0 : this.getName().hashCode());

        List<Person> people = this.getPeople();
        hash *= prime + ((people == null) ? 0 : people.hashCode());

        if (hash < 0) 
            hash *= -1;
        
        return hash;
    }


    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\",\n" +
                "  \"people\": " + this.people +
                "\n}";
    }
}