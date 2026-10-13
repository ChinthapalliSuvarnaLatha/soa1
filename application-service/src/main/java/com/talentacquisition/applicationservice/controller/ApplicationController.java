package com.talentacquisition.applicationservice.controller;

import com.talentacquisition.applicationservice.dto.ApplicationRequest;
import com.talentacquisition.applicationservice.entity.Application;
import com.talentacquisition.applicationservice.entity.ApplicationStatus;
import com.talentacquisition.applicationservice.service.ApplicationService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application applyForJob(
            @Valid @RequestBody ApplicationRequest request) {

        return applicationService.applyForJob(request);
    }

    @GetMapping("/candidate/{candidateId}")
    public List<Application> getCandidateApplications(
            @PathVariable("candidateId") Long candidateId) {

        return applicationService.getCandidateApplications(candidateId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getJobApplications(
            @PathVariable("jobId") Long jobId) {

        return applicationService.getJobApplications(jobId);
    }

    @GetMapping("/{id}")
    public Application getApplication(
            @PathVariable("id") Long id) {

        return applicationService.getApplication(id);
    }

    @PutMapping("/{id}/status")
    public Application updateStatus(
            @PathVariable("id") Long id,
            @RequestParam("status") ApplicationStatus status) {

        return applicationService.updateStatus(id, status);
    }

    @PutMapping("/{id}/shortlist")
    public Application shortlistCandidate(
            @PathVariable("id") Long id) {

        return applicationService.shortlistCandidate(id);
    }

    @PutMapping("/{id}/reject")
    public Application rejectCandidate(
            @PathVariable("id") Long id) {

        return applicationService.rejectCandidate(id);
    }

    @PutMapping("/{id}/select")
    public Application selectCandidate(
            @PathVariable("id") Long id) {

        return applicationService.selectCandidate(id);
    }
}