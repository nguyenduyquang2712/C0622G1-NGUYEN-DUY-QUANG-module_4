package com.codegym.controller;

import com.codegym.dto.StudentDto;
import com.codegym.model.ClassRoom;
import com.codegym.model.Course;
import com.codegym.model.Student;
import com.codegym.service.IClassRoomService;
import com.codegym.service.ICourseService;
import com.codegym.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService classRoomService;
    @Autowired
    private ICourseService courseService;
    @GetMapping("")
    public ModelAndView showList(@RequestParam(value = "nameSearch",defaultValue = "")String nameSearch,
                                 @RequestParam(value = "classRoom",defaultValue = "")String classRoom,
                                 @PageableDefault (value = 2) Pageable pageable){
        Page<Student> studentPage = studentService.findAllByNameAndClassName(nameSearch, classRoom,pageable);
        List<ClassRoom> classRoomList = classRoomService.findAll();
        List<Course> courseList = courseService.findAll();
        ModelAndView modelAndView = new ModelAndView("student/list");
        modelAndView.addObject("studentList", studentPage);
        modelAndView.addObject("classRoomList", classRoomList);
        modelAndView.addObject("courseList", courseList);
        modelAndView.addObject("nameSearch",nameSearch);
        modelAndView.addObject("classRoom", classRoom);
        modelAndView.addObject("studentDto", new StudentDto());
        return modelAndView;
    }
//    @GetMapping("/create")
//    public String showCreatePage(Model model){
//        model.addAttribute("classRoomList",classRoomService.findAll());
//        model.addAttribute("courseList",courseService.findAll());
//        model.addAttribute("studentDto", new StudentDto());
//        return "student/create";
//    }
    @GetMapping("/create")
    public String returnList(){
        return "redirect:/students";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute @Validated StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,@RequestParam(value = "nameSearch",defaultValue = "")String nameSearch,
                                @RequestParam(value = "classRoom",defaultValue = "")String classRoom,
                                @PageableDefault (value = 2) Pageable pageable, Model model){
        if(bindingResult.hasFieldErrors()){
            nameSearch = "";
            classRoom="";
            model.addAttribute("studentList", studentService.findAllByNameAndClassName(nameSearch, classRoom,pageable));
            model.addAttribute("classRoomList", classRoomService.findAll());
            model.addAttribute("courseList", courseService.findAll());
            model.addAttribute("message","error");
//            model.addAttribute("nameSearch","");
//            model.addAttribute("classRoom", "");
            return "student/list";
        }
        studentDto.getAccount().setDateCreate(new Date(System.currentTimeMillis()));
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message","Create student "+student.getName()+" OK");
        return "redirect:/students";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("idDelete") int idDelete){
        studentService.remove(idDelete);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable("id") int id){
        Optional<Student> student = studentService.findById(id);
        StudentDto studentDto = new StudentDto();
        ModelAndView modelAndView = new ModelAndView("student/edit");
        if(!student.isPresent()){
            modelAndView.addObject("message", "Customer not found");
            return modelAndView;
        }
        BeanUtils.copyProperties(student.get(), studentDto);
        modelAndView.addObject("classRoomList",classRoomService.findAll());
        modelAndView.addObject("courseList",courseService.findAll());
        modelAndView.addObject("studentDto", studentDto);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editStudent(@ModelAttribute @Validated StudentDto studentDto,BindingResult bindingResult, RedirectAttributes redirect, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("classRoomList", classRoomService.findAll());
            model.addAttribute("courseList", courseService.findAll());
            return "student/edit";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        redirect.addFlashAttribute("message", "Update thành công");
        return "redirect:/students";
    }

}
