package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "session")
@IdClass(SessionPk.class)
public class Session {

    @Id
    @NotNull
    @Column(name = "time")
    private Timestamp sessionTime;

    @NotNull
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "track_id", referencedColumnName = "id")
    private Track track;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;

    @Basic
    @NotNull
    @Column(name = "cost")
    private int cost;

    //region getAndSet

    public Timestamp getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(Timestamp sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Track getTrack() {
        return track;
    }
    public void setTrack(Track track) {
        this.track = track;
    }

    //endregion
}
