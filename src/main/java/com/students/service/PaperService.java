package com.students.service;

import com.students.bean.Paper;
import com.students.bean.PaperExample;
import com.students.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    private PaperMapper paperMapper;

    public List<Paper> getAll(){
        PaperExample example = new PaperExample();
        return paperMapper.selectByExample(example);
    }
}