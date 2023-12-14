package com.restful.onetoone;

import com.restful.onetoone.dto.DepartmentDTO;
import com.restful.onetoone.dto.PersonDTO;
import com.restful.onetoone.dto.PersonDepartmentDTO;
import com.restful.onetoone.entity.Department;
import com.restful.onetoone.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }

    private static void testEntityEquality(Object entity1, Object entity2) {
        // Testar equals
        boolean equalsResult = entity1.equals(entity2);
        System.out.println("Equals result: " + equalsResult);  // Deve imprimir true

        // Testar hashCode
        int hashCode1 = entity1.hashCode();
        int hashCode2 = entity2.hashCode();
        System.out.println("HashCode 1: " + hashCode1);
        System.out.println("HashCode 2: " + hashCode2);
        System.out.println("HashCode result: " + (hashCode1 == hashCode2));  // Deve imprimir true
    }

    private static void testDTOEquality(Object dto1, Object dto2) {
        // Testar equals
        boolean equalsResult = dto1.equals(dto2);
        System.out.println("Equals result: " + equalsResult);  // Deve imprimir true

        // Testar hashCode
        int hashCode1 = dto1.hashCode();
        int hashCode2 = dto2.hashCode();
        System.out.println("HashCode 1: " + hashCode1);
        System.out.println("HashCode 2: " + hashCode2);
        System.out.println("HashCode result: " + (hashCode1 == hashCode2));  // Deve imprimir true
    }

    private static void testToString() {
        // Exemplo: Criar instâncias de Person, Department, PersonDTO, DepartmentDTO, PersonDepartmentDTO
        Department department = new Department(1L, "IT Department");
        Person person = new Person(1L, "John Doe", 50000.0, department);
        PersonDTO personDTO = new PersonDTO(1L, "Jane Doe", 60000.0);
        DepartmentDTO departmentDTO = new DepartmentDTO(2L, "HR Department");
        PersonDepartmentDTO personDepartmentDTO = new PersonDepartmentDTO(2L, "Alice", 70000.0, departmentDTO);

        // Imprimir resultados do método toString
        System.out.println("Department " + department);
        System.out.println("Person " + person);
        System.out.println("PersonDTO " + personDTO);
        System.out.println("DepartmentDTO " + departmentDTO);
        System.out.println("PersonDepartmentDTO " + personDepartmentDTO);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Testes de toString para as entidades
            testToString();

            // Testes de equals e hashCode para Department
            testEntityEquality(new Department(1L, "IT Department"), new Department(1L, "IT Department"));

            // Testes de equals e hashCode para Person
            Department department = new Department(1L, "IT Department");
            testEntityEquality(new Person(1L, "John Doe", 50000.0, department),
                    new Person(1L, "John Doe", 50000.0, department));

            // Testes de equals e hashCode para PersonDTO
            testDTOEquality(new PersonDTO(1L, "John Doe", 50000.0),
                    new PersonDTO(1L, "John Doe", 50000.0));

            // Testes de equals e hashCode para PersonDepartmentDTO
            DepartmentDTO departmentDTO = new DepartmentDTO(1L, "IT Department");
            testDTOEquality(new PersonDepartmentDTO(1L, "Alice", 70000.0, departmentDTO),
                    new PersonDepartmentDTO(1L, "Alice", 70000.0, departmentDTO));

            // Testes de equals e hashCode para DepartmentDTO
            testDTOEquality(new DepartmentDTO(1L, "IT Department"),
                    new DepartmentDTO(1L, "IT Department"));
        };
    }
}