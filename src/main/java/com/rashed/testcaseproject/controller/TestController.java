package com.rashed.testcaseproject.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rashed.testcaseproject.dto.TestDto;
import com.rashed.testcaseproject.model.JsonViews;
import com.rashed.testcaseproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rashedul Islam
 * @version 0.1
 * @since 03-02-2023
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping
    public TestDto add(@RequestBody TestDto testDto){
        return testService.save(testDto);
    }

    @PutMapping
    public TestDto updated(@RequestBody TestDto testDto){
        return testService.updated(testDto);
    }

    @GetMapping("/get/{id}")
    public TestDto getItemById(@PathVariable Integer id){
        return testService.getTestDto(id);
    }
    @JsonView(JsonViews.Brief.class)
    @GetMapping("/get/all/brief")
    public List<TestDto> getAllBrief(){
        return testService.getAllTestDto();
    }
    @JsonView(JsonViews.Small.class)
    @GetMapping("/get/all/small")
    public List<TestDto> getAllSmall(){
        return testService.getAllTestDto();
    }
    @JsonView(JsonViews.Detail.class)
    @GetMapping("/get/all/details")
    public List<TestDto> getAllDetails(){
        return testService.getAllTestDto();
    }

    @DeleteMapping("/get/{id}")
    public List<TestDto> testDtoDeleted(@PathVariable Integer id){
        return testService.deletedDto(id);
    }
}
