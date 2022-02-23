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
           /* Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);*/

            //비영속
            /*Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");*/

            //영속
            /*em.persist(member);
            //1차 캐시에서 먼저 조회하므로 select 쿼리가 날라가지 않음.
            Member findMember = em.find(Member.class, 100L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
*/

            //이제 DB에 저장되어 있으므로 2번 조회를 하면 select 쿼리는 한번. 두번째는 캐시에서 조회.
           /* Member findMember1 = em.find(Member.class, 100L);
            Member findMember2 = em.find(Member.class, 100L);*/

            //트랜잭션을 지원하는 쓰기 지연
       /*     Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("==================");*/
            //commit 시점에 Insert 쿼리가 날라가게 됨됨

            //변경 감지
           /* Member member = em.find(Member.class, 150L);
            member.setName("Change");
            System.out.println("==================");*/

            //플러시
            Member member = new Member(200L, "member200");
            em.persist(member);
            em.flush();
            System.out.println("=====================");
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
