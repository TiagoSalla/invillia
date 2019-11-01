package com.invillia.springteams.repository;

import com.invillia.springteams.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(
            "SELECT a FROM Member a JOIN FETCH a.team p where p.id = :id_team")
    List<Member> findAllByIdTeam(@Param("id_team") Long id);

    //        @Query(
//    value = "SELECT * FROM member m JOIN team t on m.team_id = t.id WHERE t.id = :id_team", nativeQuery = true
//        )
//    List<Member> findAllByIdTeam(@Param("id_team") Long id);
}
