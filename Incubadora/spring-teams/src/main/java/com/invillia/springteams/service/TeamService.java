package com.invillia.springteams.service;

import com.invillia.springteams.exception.TeamNotFoundException;
import com.invillia.springteams.model.Team;
import com.invillia.springteams.repository.TeamRepository;
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
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(String.valueOf(id)));
    }

    @Transactional
    public void update(Long id){
        Team team = findById(id);
        teamRepository.save(team);
    }

    @Transactional
    public void delete(Long id) {
        Team team = findById(id);
        teamRepository.delete(team);
    }
}
