package com.example.springmvc.basic.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@Slf4j
public class MemberRepository {

    public void save(Member member) {
        try {
            log.info("member save: success");
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Member> findAll() {
        log.info("member findAll: success");
        return new ArrayList<>();
    }
}
