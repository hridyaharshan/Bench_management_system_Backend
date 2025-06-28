package com.benchmgmt.entity;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interviewId;

    @ManyToOne
    @JoinColumn
    private Candidate candidate;



    private LocalDate date;
    private String panel;

    @Enumerated(EnumType.STRING)
    private InterviewStatus status;

    @Enumerated(EnumType.STRING)
    private Feedback feedback;

    private String detailedFeedback;
    private String review;
    private int round;
    private String department;
    private String client;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn
    private InterviewCycle interviewCycle; // ✅ THIS is sufficient
}

