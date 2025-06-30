package com.benchmgmt.dto;


import com.benchmgmt.model.Level;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;


@Getter
@Setter
public class CandidateDTO {

    @NotNull
    private Integer empId;


    private String name;

    @NotNull
    private LocalDate doj;


    private String primarySkill;

    @NotNull
    private Level level;


    private String location;



    private String email;


    private String departmentName;

    private LocalDate benchStartDate;
    private LocalDate benchEndDate;

    private Boolean isDeployable;
    private Boolean blockingStatus;
}
