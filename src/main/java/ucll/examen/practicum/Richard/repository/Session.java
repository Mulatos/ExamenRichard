package ucll.examen.practicum.Richard.repository;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "session")


public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_ID")
    private int course_ID;

    @Column(name = "start_date_time")
    private Date start_date_time;

    @Column(name = "end_date_time")
    private Date end_date_time;

    @ManyToOne
    @JoinColumn( name = "course_id", nullable = false)
    private Course courses;

    public Session() {
    }

    public Session(Long id, int course_ID, Date start_date_time, Date end_date_time, Course course, Course course1) {
        this.id = id;
        this.course_ID = course_ID;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    public Date getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(Date start_date_time) {
        this.start_date_time = start_date_time;
    }

    public Date getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(Date end_date_time) {
        this.end_date_time = end_date_time;
    }


    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", course_ID=" + course_ID +
                ", start_date_time=" + start_date_time +
                ", end_date_time=" + end_date_time +
                '}';
    }
}


