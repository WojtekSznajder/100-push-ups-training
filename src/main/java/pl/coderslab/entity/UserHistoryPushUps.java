package pl.coderslab.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class UserHistoryPushUps {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;

    @OneToOne
    @JoinColumn(name = "pushups_id")
    private Pushups pushups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Pushups getPushups() {
        return pushups;
    }

    public void setPushups(Pushups pushups) {
        this.pushups = pushups;
    }
}
