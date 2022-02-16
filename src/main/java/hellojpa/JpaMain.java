package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            //저장
            /*Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);*/

            //수정
          /*  Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/

            //전체조회
       /*     List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
            for (Member member : result) {
                System.out.println("member = " + member.getId() + member.getName());
            }*/

            //삭제
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);


            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
