package com.ums.controller;

import com.ums.model.entity.subject.Subject;
import com.ums.model.request.*;
import com.ums.model.response.*;
import com.ums.repository.LecturerRepository;
import com.ums.service.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/dean")
public class DeanController {

    private StudentGroupService groupService;
    private LecturerService lecturerService;
    private CourseService courseService;
    private SubjectService subjectService;
    private DeanService deanService;

    public DeanController(StudentGroupService groupService, LecturerService lecturerService,
                          CourseService courseService, SubjectService subjectService, DeanService deanService) {
        this.groupService = groupService;
        this.courseService = courseService;
        this.lecturerService = lecturerService;
        this.subjectService = subjectService;
        this.deanService = deanService;
    }

    @PostMapping("/create_group")
    public StudentGroupResponse createStudentGroup(@RequestBody @Valid StudentGroupRequest groupRequest) {
        return groupService.create(groupRequest);
    }

    @PostMapping("/create_lecturer")
    public SaveLecturerResponse createLecturer(@RequestBody @Valid SaveLecturerRequest lecturerRequest) {
        return lecturerService.createLecturer(lecturerRequest);
    }

    @PostMapping("/create_course")
    public CourseResponse createCourse(@RequestBody @Valid CourseRequest courseRequest) {
        return courseService.create(courseRequest);
    }

    @PostMapping("/create_subject")
    public SubjectResponse createSubject(@RequestBody @Valid SubjectRequest subjectRequest) {
        return subjectService.create(subjectRequest);
    }

    @PostMapping("/create_dean")
    public SaveDeanResponse createDean(@RequestBody @Valid SaveDeanRequest deanRequest) {
        return deanService.create(deanRequest);
    }

    @DeleteMapping("/delete_group/{name}")
    public void deleteStudentGroup(@PathVariable String name) {
        groupService.delete(name);
    }

    @DeleteMapping("/delete_course/{id}")
    public void deleteCourse(@PathVariable long id) {
        courseService.delete(id);
    }

    @DeleteMapping("/delete_lecturer/{email}")
    public void deleteLecturer(@PathVariable String email){
        lecturerService.deleteLecturerByEmail(email);
    }

    @DeleteMapping("delete_dean/{email}")
    public void deleteDean(@PathVariable String email) {
        deanService.deleteDean(email);
    }

}