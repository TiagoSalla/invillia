import dao.MemberDAO;
import dao.TeamDAO;
import domain.Member;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "incubadoradoispontozero");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("-----------------------ERROS A PARTIR DAQUI-----------------------");

/*
        Test comands for teams CRUD

        TeamDAO teamDAO = new TeamDAO(entityManager);

        teamDAO.insert(new Team("Melbourne"));

        System.out.println(teamDAO.listAll());

        Team team = teamDAO.findById(3L);

        team.setName("Madonna");
        teamDAO.update(team);
        System.out.println(teamDAO.findById(1L));

        teamDAO.deleteById(2L);

        System.out.println(teamDAO.listAll());

        */

        // Test comands for members CRUD
        /*
        MemberDAO memberDAO = new MemberDAO(entityManager);

        memberDAO.insert(new Member("Jota", team));
        memberDAO.insert(new Member("Maria",1L));

        System.out.println(memberDAO.listAll());

        Member member = memberDAO.findById(3L);
        System.out.println(member);

        System.out.println(memberDAO.findAllByTeamId(3L));

        member.setName("Juan");
        memberDAO.update(member);
        System.out.println(memberDAO.findById(1L));

        memberDAO.deleteById(2L);

        System.out.println(memberDAO.listAll());
        */
    }
}
