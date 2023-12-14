package com.restful.onetoone.dto;

import com.restful.onetoone.entity.Department;
import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;

    private String name;

    public DepartmentDTO(Department entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(this.getClass() == o.getClass())) return false;

        DepartmentDTO that = (DepartmentDTO) o;

        return Objects.equals(this.getId(), that.getId()) &&
                Objects.equals(this.getName(), that.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.getId() == null) ? 0 : this.getId().hashCode());
        hash *= prime + ((this.getName() == null) ? 0 : this.getName().hashCode());

        if (hash < 0)
            hash *= -1;
        
        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + this.id + ",\n" +
                "  \"name\": \"" + this.name + "\"\n" +
                "}";
    }
}