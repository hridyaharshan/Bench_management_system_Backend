package com.benchmgmt.controller;



import com.benchmgmt.entity.Candidate;
import com.benchmgmt.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
@CrossOrigin
public class CandidateController {

    private final CandidateRepository candidateRepository;

    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @GetMapping("/{empId}")
    public Candidate getCandidateById(@PathVariable Integer empId) {
        return candidateRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }
}

