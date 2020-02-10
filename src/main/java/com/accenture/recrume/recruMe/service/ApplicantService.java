package com.accenture.recrume.recruMe.service;

import com.accenture.recrume.recruMe.model.Applicant;
import com.accenture.recrume.recruMe.model.JobOffer;
import com.accenture.recrume.recruMe.model.Status;
import com.accenture.recrume.recruMe.repository.ApplicantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ApplicantService {
    private ApplicantsRepository applicantsRepo;

    @Autowired
    public ApplicantService(ApplicantsRepository applicantsRepo){
        this.applicantsRepo = applicantsRepo;
    }

    public List<Applicant> getApplicantsByAgeRange(int ageFrom, int ageTo) {
//    /20,40
        int thisYear = GregorianCalendar.getInstance().get(Calendar.YEAR);
        int yearTo = thisYear - ageFrom; //2000
        int yearFrom = thisYear - ageTo; //1980
        System.out.println(yearFrom);
        System.out.println(yearTo);
        System.out.println("==========================");
        return applicantsRepo.getByAgeRange(yearTo, yearFrom);
    }

    Applicant applicant = new Applicant();
    public void setApplicantInactive(int appId) {
        applicant = applicantsRepo.getApplicantById(appId);
        applicant.setStatus(Status.INACTIVE);
        applicantsRepo.save(applicant);
    }
}
