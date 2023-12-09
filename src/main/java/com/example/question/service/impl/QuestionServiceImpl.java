package com.example.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.question.entity.Question;
import com.example.question.mapper.QuestionMapper;
import com.example.question.service.QuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Question)表服务实现类
 *
 * @author makejava
 * @since 2023-12-09 14:44:30
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;

    @Override
    public List<Question> findByDifficult(String difficult) {
        LambdaQueryWrapper<Question> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Question::getDifficulty,difficult);
        return questionMapper.selectList(queryWrapper);
    }

    @Override
    public boolean saveQuestion(Question question) {
        question.setCreatetime(new Date());
        return save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionMapper.selectList(null);
    }

    @Override
    public void delQuestion(Question question) {
        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Question::getTitle,question.getTitle()).eq(Question::getAnswer,question.getAnswer()).eq(Question::getDifficulty,question.getDifficulty());
        questionMapper.delete(wrapper);
    }

}
