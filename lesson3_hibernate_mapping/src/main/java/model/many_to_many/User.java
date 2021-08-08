package model.many_to_many;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Team> teams = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}
