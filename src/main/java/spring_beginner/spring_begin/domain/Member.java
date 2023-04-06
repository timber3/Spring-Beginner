package spring_beginner.spring_begin.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    // id:고객이 정하는 ID 가 아니라 System 상에서 처리하기 위해 달아 둔 번호

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
