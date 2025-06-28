package com.benchmgmt.controller;


import com.benchmgmt.dto.InterviewCycleDTO;
import com.benchmgmt.dto.InterviewDTO;
import com.benchmgmt.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
@RequiredArgsConstructor
@CrossOrigin
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public InterviewDTO createInterview(@RequestBody InterviewDTO dto) {
        return interviewService.saveInterview(dto);
    }

    @GetMapping
    public List<InterviewDTO> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    public InterviewDTO getInterviewById(@PathVariable Integer id) {
        return interviewService.getInterviewById(id);
    }

    @PutMapping("/{id}")
    public InterviewDTO updateInterview(@PathVariable Integer id, @RequestBody InterviewDTO dto) {
        return interviewService.updateInterview(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable Integer id) {
        interviewService.deleteInterview(id);
    }

    @GetMapping("/candidate/{employeeId}")
    public List<InterviewDTO> getInterviewsByCandidateId(@PathVariable Integer employeeId) {
        return interviewService.getInterviewsByCandidateId(employeeId);
    }


    @GetMapping("/candidates/{id}/interview-cycles")
    public List<InterviewCycleDTO> getCycles(@PathVariable Integer id) {
        return interviewService.getInterviewCyclesByCandidateId(id);
    }
    // GET: Fetch all rounds in a given cycle for a candidate
    @GetMapping("/candidates/{employeeId}/interview-cycles/{cycleId}/rounds")
    public List<InterviewDTO> getRoundsByCandidateAndCycle(
            @PathVariable Integer employeeId,
            @PathVariable Integer cycleId) {
        return interviewService.getFullInterviewsByCandidateAndCycle(employeeId, cycleId);
    }

    // POST: Add a new round to a cycle for a candidate
    @PostMapping("/candidates/{employeeId}/interview-cycles/{cycleId}/rounds")
    public InterviewDTO addRoundToCycle(
            @PathVariable Integer employeeId,
            @PathVariable Integer cycleId,
            @RequestBody InterviewDTO dto) {
        return interviewService.addInterviewRoundToCycle(employeeId, cycleId, dto);
    }


    //entering the cycles here like each of the company which happened

    @PostMapping("/interview-cycles")
    public InterviewCycleDTO createCycle(@RequestBody InterviewCycleDTO dto) {
        return interviewService.createInterviewCycle(dto);
    }

    @PostMapping("/interview-cycles/{cycleId}/interviews")
    public InterviewDTO createInterviewForCycle(@PathVariable Long cycleId, @RequestBody InterviewDTO dto) {
        return interviewService.saveInterviewForCycle(cycleId, dto);
    }





}

