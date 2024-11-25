package org.ryukonz.esdminiproject.repo;

import org.ryukonz.esdminiproject.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {

    // Method to count students in a specific domain and graduation year
    @Query("SELECT COUNT(s) FROM Students s WHERE s.domain.program = :program AND s.graduationYear = :year")
    long countByDomainAndGraduationYear(@Param("program") String program, @Param("year") String graduationYear);
}
