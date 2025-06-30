package com.benchmgmt.service;



import com.benchmgmt.dto.CandidateDTO;
import com.benchmgmt.entity.Candidate;
import com.benchmgmt.repository.CandidateRepository;
import com.benchmgmt.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    @Override
    public Candidate addCandidate(CandidateDTO dto) {
        Candidate candidate = Candidate.builder()

                .name(dto.getName())
                .doj(dto.getDoj())
                .primarySkill(dto.getPrimarySkill())
                .level(dto.getLevel())
                .location(dto.getLocation())
                .email(dto.getEmail())
                .departmentName(dto.getDepartmentName())
                .benchStartDate(dto.getBenchStartDate())
                .benchEndDate(dto.getBenchEndDate())
                .isDeployable(dto.getIsDeployable())
                .blockingStatus(dto.getBlockingStatus())
                .build();
        return repository.save(candidate);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }
}
