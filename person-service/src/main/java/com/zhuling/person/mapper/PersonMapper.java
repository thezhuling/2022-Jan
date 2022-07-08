package com.zhuling.person.mapper;

import com.zhuling.person.model.Person;
import com.zhuling.person.model.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDto toDto(Person doctor);
}
