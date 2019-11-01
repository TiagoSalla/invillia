package com.invillia.springteams.controller;

import com.invillia.springteams.exception.ActionNotPermitedException;
import com.invillia.springteams.model.Member;
import com.invillia.springteams.model.Team;
import com.invillia.springteams.repository.TeamRepository;
import com.invillia.springteams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/teams")
    public String teams(Model model){
        model.addAttribute("teams", teamService.findAll());
        return "team/teams";
    }

    @GetMapping("/teams/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        teamService.delete(id);
        model.addAttribute("teams", teamService.findAll());
        return "redirect:/teams";
    }

    @GetMapping("/teams/signup")
    public String showSignUpForm(Team team) {
        return "team/add-team";
    }

    @PostMapping("/teams/addteam")
    public String addTeam(@Valid Team team, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "team/add-team";
        }
        teamService.insert(team);
        model.addAttribute("teams", teamService.findAll());
        return "redirect:/teams";
    }

    @GetMapping("/teams/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Team team = teamService.findById(id);
        model.addAttribute("team", team);
        return "team/update-team";
    }

    @PostMapping("/teams/update/{id}")
    public String updateMember(@PathVariable("id") long id, @Valid Team team, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "team/update-team";
        }
        Team t = teamService.findById(id);
        team.setCreatedAt(t.getCreatedAt());
        teamService.insert(team);
        model.addAttribute("teams", teamService.findAll());
        return "redirect:/teams";
    }

    @ExceptionHandler(ActionNotPermitedException.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
    }
}
