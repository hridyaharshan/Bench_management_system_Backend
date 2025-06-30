package com.benchmgmt.controller;



import com.benchmgmt.dto.CandidateDTO;
import com.benchmgmt.entity.Candidate;
import com.benchmgmt.repository.CandidateRepository;
import com.benchmgmt.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bench")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService service;

    @PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@Validated @RequestBody CandidateDTO dto) {
        return ResponseEntity.ok(service.addCandidate(dto));
    }

    @GetMapping("/details")
    public ResponseEntity<List<Candidate>> getDetails() {
        return ResponseEntity.ok(service.getAllCandidates());
    }

    @GetMapping("/")
    public String healthCheck() {
        return "Candidate API is running!";
    }
}