package com.rashed.testcaseproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rashed.testcaseproject.dto.TestDto;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TestService {

    List<TestDto> list = new ArrayList<>();

    public TestDto save(TestDto testDto) {
        list.add(testDto);
        return testDto;
    }

    public TestDto updated(TestDto testDto) {
        return list.stream().filter(ob -> ob.getId() == testDto.getId()).findFirst().map(ob -> ob.setName(testDto.getName())
                .setOffice(testDto.getOffice())
                .setOfficeUnit(testDto.getOfficeUnit())
                .setOfficeUnitPost(testDto.getOfficeUnitPost())).orElse(null);
    }

    public TestDto getTestDto(Integer id) {
        return list.stream().filter(ob -> ob.getId().equals(id)).findAny().orElse(null);
    }

    public List<TestDto> getAllTestDto() {
        return list;
    }

    public List<TestDto> deletedDto(Integer id) {
        return list = list.stream().filter(testDto -> testDto.getId() != id).collect(Collectors.toList());
    }
}
