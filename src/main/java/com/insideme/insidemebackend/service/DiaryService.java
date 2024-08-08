package com.insideme.insidemebackend.service;

import com.insideme.insidemebackend.domain.Diary;
import com.insideme.insidemebackend.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    @Autowired
    DiaryRepository diaryRepository;

    public Diary saveDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    public List<Diary> getAllDiary(){
        return diaryRepository.findAll();
    }


}
