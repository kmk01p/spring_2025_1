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

            if((title == null || title.isEmpty()) && (author == null || author.isEmpty())){
                return list;
            }//이거는 abc 중에 한 글자라도 있으면 검색이 되는거...아무것도 검색어를 넣지 않아도 전부 조회 (모든 검색은 이 방식)

//        if ((title == null && title.isEmpty()) && (author == null && author.isEmpty())) {
//            return list;
//        } abc a랑 똑같은 거니까 a 만 넣고 검색하면 abc 안뜸

            else {

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
