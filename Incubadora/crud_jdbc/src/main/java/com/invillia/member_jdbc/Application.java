package com.invillia.member_jdbc;

public class Application {

    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAO();

        Member member = new Member(1, "Tiago", 2);

        UpdateMemberRequest updateMemberRequest = new UpdateMemberRequest("Tetis", 1L);

       // memberDAO.insert(member);
       // System.out.println(memberDAO.listAll());
       // System.out.println(memberDAO.findById(2L));
       // memberDAO.update(2L, updateMemberRequest);
       // memberDAO.deleteById(2L);
    }
}
