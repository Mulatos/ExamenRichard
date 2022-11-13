package ucll.examen.practicum.Richard.repository;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name ="description")
    private String description;

    @Column(name = "study_points")
    private String study_points;

//    @ManyToMany(mappedBy = "course")
//    private Set<Person> person = new HashSet<>();
//    @OneToMany(mappedBy = "course")
//    private Set<Session> sessions;

    public Course() {
    }

    public Course(long id, String name, String description, String study_points) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.study_points = study_points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudy_points() {
        return study_points;
    }

    public void setStudy_points(String study_points) {
        this.study_points = study_points;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", study_points='" + study_points + '\'' +
                '}';
    }

    @ManyToMany(mappedBy = "course")
    private Collection<Person> people;

    public Collection<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people = people;
    }
}
