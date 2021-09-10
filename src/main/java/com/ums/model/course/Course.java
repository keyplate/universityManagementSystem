package com.ums.model.course;

import com.ums.model.lecturer.Lecturer;
import com.ums.model.subject.Subject;
import lombok.Data;
import javax.persistence.*;


@Table(name = "course")
@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
