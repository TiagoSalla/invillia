package com.invillia.springteams.service;

import com.invillia.springteams.model.Member;
import com.invillia.springteams.model.Team;
import com.invillia.springteams.repository.MemberRepository;
import com.invillia.springteams.repository.TeamRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void insert(Team team){
        teamRepository.save(team);
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team findById(Long id){
        return teamRepository.findById(id).get();
    }

    @Transactional
    public void update(Long id){
        Team team = findById(id);
        //Inserir futuros métodos
        teamRepository.save(team);
    }

    @Transactional
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }
}
