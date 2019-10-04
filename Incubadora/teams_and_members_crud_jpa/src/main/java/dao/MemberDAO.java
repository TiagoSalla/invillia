package dao;

import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemberDAO {
    private final EntityManager entityManager;

    public MemberDAO(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(final Member member){
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(member);
        transaction.commit();
    }

    public List<Member> listAll(){
        final TypedQuery<Member> member = entityManager.createQuery("from Member", Member.class);
        return member.getResultList();
    }

    public Member findById(final long id){
        return entityManager.find(Member.class, id);
    }

    public void update(final Member member){
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(member);
        transaction.commit();
    }

    public void deleteById(final long id){
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Member member= findById(id);
        entityManager.remove(member);
        transaction.commit();
    }
}
