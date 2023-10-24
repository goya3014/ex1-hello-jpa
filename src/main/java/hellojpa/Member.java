package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

/*    @Column(name = "TEAM_ID")
    private Long teamId;*/
    //객체지향 모델링으로 변경

    @ManyToOne
    @JoinColumn(name = "TEAM_ID") //다대일
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;

        //순수 객체 상태를 고려하여 항상 양쪽에 값 설정필요.
        //연관관계 편의 메소드 생성.
        team.getMembers().add(this);
    }
}
