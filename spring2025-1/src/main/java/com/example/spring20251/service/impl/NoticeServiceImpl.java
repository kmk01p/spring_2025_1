package com.example.spring20251.service.impl;

import com.example.spring20251.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    public int create(String title, String content, String author) {

        Map<String, Object> notice = new HashMap<String, Object>();
        notice.put("title", title);
        notice.put("content", content);
        notice.put("author", author);
        notice.put("id", list.size() + 1);

        list.add(notice);

        return 200;
    }

    @Override
    public List<Map<String, Object>> list(String title, String author) {
        List<Map<String,Object>> returnList = new ArrayList<Map<String, Object>>();

        for(Map<String, Object> each: list) {
            if ((title == null && title.isEmpty()) && (author == null && author.isEmpty())) {
                return list;
            } else {

                boolean needToAdd = false;

                String eachTitle = (String) each.get("title");
                String eachAuthor = (String) each.get("author");

                if (title != null && !title.isEmpty()) {
                    if (eachTitle.contains(title)) {
                        // returnList.add(each);
                        needToAdd = true;
                    }
                }

                if (author != null && !author.isEmpty()) {
                    if (eachAuthor.contains(author)) {
                        //  returnList.add(each);
                        needToAdd = true;
                    }
                }
                if (needToAdd) {
                    returnList.add(each);
                }
            }
        }
        return returnList;
    }

}
