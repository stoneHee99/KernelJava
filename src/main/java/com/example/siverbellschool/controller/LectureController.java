package com.example.siverbellschool.controller;

import com.example.siverbellschool.dto.AddLectureRequest;
import com.example.siverbellschool.enumerate.LectureType;
import com.example.siverbellschool.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/list")
    public String showLectureList(Model model) {
        model.addAttribute("lectures", lectureService.getLectures());
        return "lecture/list";
    }

    @GetMapping("/add")
    public String showLectureAddForm(Model model) {
        model.addAttribute("lectureTypes", LectureType.values());
        return "lecture/add";
    }

    @PostMapping("/add")
    public String addLecture(AddLectureRequest addLectureRequest) {
        lectureService.addLecture(addLectureRequest);
        return "redirect:/lecture/list";
    }

}
