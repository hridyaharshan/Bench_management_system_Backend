package com.benchmgmt.service;

import com.benchmgmt.dto.CandidateDTO;
import com.benchmgmt.entity.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate addCandidate(CandidateDTO dto);
    List<Candidate> getAllCandidates();
}