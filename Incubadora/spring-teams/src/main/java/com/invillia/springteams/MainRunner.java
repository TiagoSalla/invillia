package com.invillia.springteams;


import com.invillia.springteams.model.Member;
import com.invillia.springteams.model.Team;
import com.invillia.springteams.service.MemberService;
import com.invillia.springteams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {

    final TeamService teamService;
    final MemberService memberService;

    @Autowired
    public MainRunner(TeamService teamService, MemberService memberService) {
        this.teamService = teamService;
        this.memberService = memberService;
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
