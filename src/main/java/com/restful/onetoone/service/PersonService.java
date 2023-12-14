package com.restful.onetoone.service;

import com.restful.onetoone.dto.PersonDTO;
import com.restful.onetoone.dto.PersonDepartmentDTO;

public interface PersonService {

    PersonDepartmentDTO insert(PersonDepartmentDTO dto);

    PersonDTO insert(PersonDTO dto);
}
