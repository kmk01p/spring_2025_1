package com.example.spring20251.service;

import com.example.spring20251.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {
    int create(String title, String content, String author);
    List<Map<String, Object>> list(String title, String author); //검색 기능 추가
}
