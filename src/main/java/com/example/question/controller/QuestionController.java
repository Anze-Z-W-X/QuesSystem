package com.example.question.controller;

import com.example.question.entity.Question;
import com.example.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * (Question)表控制层
 *
 * @author makejava
 * @since 2023-12-09 14:44:28
 */
@RestController
@CrossOrigin("*")
public class QuestionController{
    @Autowired
    private QuestionService questionService;

    @GetMapping("/ks/all")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/d/{difficulty}")
    public List<Question> getQuestions(@PathVariable("difficulty")String difficult){
        return questionService.findByDifficult(difficult);
    }

    @PostMapping("/save")
    public boolean saveQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @DeleteMapping("/del")
    public void delQuestion(@RequestBody Question question){
        questionService.delQuestion(question);
    }
}

