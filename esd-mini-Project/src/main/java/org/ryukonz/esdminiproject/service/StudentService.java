package org.ryukonz.esdminiproject.service;

import org.ryukonz.esdminiproject.dto.StudentReqDto;
import org.ryukonz.esdminiproject.model.Domains;
import org.ryukonz.esdminiproject.model.Specializations;
import org.ryukonz.esdminiproject.model.Students;
import org.ryukonz.esdminiproject.repo.DomainsRepo;
import org.ryukonz.esdminiproject.repo.SpecializationRepo;
import org.ryukonz.esdminiproject.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private DomainsRepo domainRepository;

    @Autowired
    private SpecializationRepo specializationRepository;

    public Students saveStudent(StudentReqDto dto) {
        Domains domain = domainRepository.findById(dto.getDomainId())
                .orElseThrow(() -> new RuntimeException("Invalid Domain ID: " + dto.getDomainId()));
        Specializations specialization = specializationRepository.findById(dto.getSpecializationId())
                .orElseThrow(() -> new RuntimeException("Invalid Specialization ID: " + dto.getSpecializationId()));

        String programCode = getProgramCode(domain.getProgram());
        long count = studentRepository.countByDomainAndGraduationYear(domain.getProgram(), dto.getGraduationYear());
        String rollNumber = programCode + dto.getGraduationYear() + String.format("%04d", count + 1);

        // Create student entity
        Students student = new Students();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setCgpa(dto.getCgpa());
        student.setTotalCredits(dto.getTotalCredits());
        student.setGraduationYear(dto.getGraduationYear());
        student.setDomain(domain);
        student.setSpecialization(specialization);
        student.setRollNumber(rollNumber);

        return studentRepository.save(student);
    }

    private String getProgramCode(String program) {
        if (program.contains("IMTech")) {
            return "IM";
        } else if (program.contains("MTech")) {
            return "MT";
        } else if (program.contains("BT")) {
            return "BT";
        } else {
            throw new RuntimeException("Unknown program: " + program);
        }
    }
}

