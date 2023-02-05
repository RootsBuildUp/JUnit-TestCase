package com.rashed.testcaseproject.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.rashed.testcaseproject.model.JsonViews;
import lombok.Data;
import lombok.experimental.Accessors;

//{
//        "id": 1,
//        "name": "Rashedul Islam",
//        "office": "Nitex",
//        "officeUnit": "Tech Team",
//        "officeUnitPost": "Full Stack Enginer"
//        }
@Data
@Accessors(chain = true)
public class TestDto {
    @JsonView({JsonViews.Small.class})
    private Integer id;
    @JsonView({JsonViews.Small.class})
    private String name;
    @JsonView({JsonViews.Brief.class})
    private String office;
    @JsonView({JsonViews.Detail.class})
    private String officeUnit;
    @JsonView({JsonViews.Detail.class})
    private String officeUnitPost;

}
