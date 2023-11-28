package com.example.siverbellschool.controller;

import com.example.siverbellschool.dto.ApplyRequest;
import com.example.siverbellschool.service.LectureService;
import com.example.siverbellschool.service.ScoreService;
import com.example.siverbellschool.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/score")
public class ScoreController {

    private final LectureService lectureService;
    private final StudentService studentService;
    private final ScoreService scoreService;

    @GetMapping("/apply")
    public String showLectureApplyForm(Model model) {
        model.addAttribute("lectures", lectureService.getLectures());
        model.addAttribute("students", studentService.getStudents());
        return "score/apply";
    }

    @PostMapping("/apply")
    public String applyLecture(ApplyRequest applyRequest) {
        scoreService.applyLecture(applyRequest);
        return "redirect:/score/list";
    }

    @GetMapping("/list")
    public String showScoreLectureList(Model model) {
        model.addAttribute("lectures", scoreService.getLecturesWithScore());
        return "score/list";
    }

    @GetMapping("/{lectureId}")
    public String showLectureScore(@PathVariable long lectureId, Model model) {
        model.addAttribute("scores", scoreService.getScore(lectureId));
        return "score/detail";
    }
}

