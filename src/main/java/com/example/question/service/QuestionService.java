package com.example.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.question.entity.Question;

import java.util.List;


/**
 * (Question)表服务接口
 *
 * @author makejava
 * @since 2023-12-09 14:44:30
 */
public interface QuestionService extends IService<Question> {
    List<Question> findByDifficult(String difficult);

    boolean saveQuestion(Question question);

    List<Question> getAllQuestion();

    void delQuestion(Question question);
}

