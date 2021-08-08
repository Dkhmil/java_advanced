package model.many_to_many;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
@Entity
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;

    @Column(name = "team_name")
    private String teamName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_team", joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> users = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
