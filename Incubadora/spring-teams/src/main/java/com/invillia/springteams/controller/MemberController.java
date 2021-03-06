package com.invillia.springteams.controller;

import com.invillia.springteams.exception.ActionNotPermitedException;
import com.invillia.springteams.model.Member;
import com.invillia.springteams.model.Team;
import com.invillia.springteams.service.MemberService;
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

@Controller
@RequestMapping("/")
public class MemberController {
    private final MemberService memberService;
    private final TeamService teamService;

    @Autowired
    public MemberController(MemberService memberService, TeamService teamService) {
        this.memberService = memberService;
        this.teamService = teamService;
    }

    @GetMapping("/members")
    public String members(Model model){
        model.addAttribute("members", memberService.findAll());
        return "member/members";
    }


    @GetMapping("/members/list-members/{id}")
    public String listMembers(@PathVariable("id") long id, Model model){
        model.addAttribute("members", memberService.findAllMembers(id));
        return "member/members";
    }

    @GetMapping("/members/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        memberService.deleteById(id);
        model.addAttribute("members", memberService.findAll());
        return "redirect:/members";
    }

    @GetMapping("/members/signup")
    public String showSignUpForm(Member member, Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "member/add-member";
    }

    @PostMapping("/members/addmember")
    public String addMember(@Valid Member member, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "member/add-member";
        }
        memberService.insert(member);
        model.addAttribute("members", memberService.findAll());
        return "redirect:/members";
    }

    @GetMapping("/members/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Member member = memberService.findById(id);
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("member", member);
        return "member/update-member";
    }

    @PostMapping("/members/update/{id}")
    public String updateMember(@PathVariable("id") long id, @Valid Member member, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "member/update-member";
        }
        Member m = memberService.findById(id);
        member.setCreatedAt(m.getCreatedAt());
        memberService.insert(member);
        model.addAttribute("members", memberService.findAll());
        return "redirect:/members";
    }

    @ExceptionHandler(ActionNotPermitedException.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
    }
}
