package com.talentacquisition.applicationservice.dto;

import jakarta.validation.constraints.NotNull;

public class ApplicationRequest {

    @NotNull
    private Long candidateId;

    @NotNull
    private Long jobId;

    public ApplicationRequest() {
    }

    public ApplicationRequest(Long candidateId, Long jobId) {
        this.candidateId = candidateId;
        this.jobId = jobId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}