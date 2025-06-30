package com.benchmgmt.entity;

import com.benchmgmt.model.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;




import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "candidates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;


    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate doj;

    @Column(name = "primary_skill")
    private String primarySkill;

    @Enumerated(EnumType.STRING)
    private Level level;

    private String location;


    private String email;

    @Column(name = "department_name")
    private String departmentName;

    @CreationTimestamp
    @Column(name = "creation_time", updatable = false)
    private LocalDateTime creationTime;

    @UpdateTimestamp
    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    @Column(name = "bench_start_date")
    private LocalDate benchStartDate;

    @Column(name = "bench_end_date")
    private LocalDate benchEndDate;

    @Column(name = "is_deployable")
    private Boolean isDeployable;

    @Column(name = "blocking_status")
    private Boolean blockingStatus;

    // Not persisted in DB
    @Transient
    private Integer agingDays;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void calculateAgingDays() {
        if (benchStartDate != null) {
            LocalDate effectiveEndDate = (benchEndDate != null) ? benchEndDate : LocalDate.now();
            this.agingDays = (int) ChronoUnit.DAYS.between(benchStartDate, effectiveEndDate);
        } else {
            this.agingDays = null;
        }
    }

    // Override getter to return current date if benchEndDate is null
    public LocalDate getBenchEndDate() {
        return (this.benchEndDate != null) ? this.benchEndDate : LocalDate.now();
    }
}