package com.talentacquisition.applicationservice.service;

import com.talentacquisition.applicationservice.client.JobServiceClient;
import com.talentacquisition.applicationservice.client.ProfileServiceClient;
import com.talentacquisition.applicationservice.dto.ApplicationRequest;
import com.talentacquisition.applicationservice.entity.Application;
import com.talentacquisition.applicationservice.entity.ApplicationStatus;
import com.talentacquisition.applicationservice.repository.ApplicationRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobServiceClient jobServiceClient;
    private final ProfileServiceClient profileServiceClient;

    public ApplicationService(
            ApplicationRepository applicationRepository,
            JobServiceClient jobServiceClient,
            ProfileServiceClient profileServiceClient) {

        this.applicationRepository = applicationRepository;
        this.jobServiceClient = jobServiceClient;
        this.profileServiceClient = profileServiceClient;
    }

    public Application applyForJob(ApplicationRequest request) {

        jobServiceClient.getJobById(request.getJobId());

        profileServiceClient.getProfileById(request.getCandidateId());

        Application application = new Application();

        application.setCandidateId(request.getCandidateId());
        application.setJobId(request.getJobId());
        application.setStatus(ApplicationStatus.APPLIED);
        application.setAppliedAt(LocalDateTime.now());

        return applicationRepository.save(application);
    }

    public List<Application> getCandidateApplications(Long candidateId) {

        return applicationRepository.findByCandidateId(candidateId);
    }

    public List<Application> getJobApplications(Long jobId) {

        return applicationRepository.findByJobId(jobId);
    }

    public Application getApplication(Long id) {

        return applicationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Application not found"));
    }

    public Application updateStatus(Long id, ApplicationStatus status) {

        Application application = getApplication(id);

        application.setStatus(status);

        return applicationRepository.save(application);
    }

    public Application shortlistCandidate(Long id) {

        return updateStatus(id, ApplicationStatus.SHORTLISTED);
    }

    public Application rejectCandidate(Long id) {

        return updateStatus(id, ApplicationStatus.REJECTED);
    }

    public Application selectCandidate(Long id) {

        return updateStatus(id, ApplicationStatus.SELECTED);
    }
}