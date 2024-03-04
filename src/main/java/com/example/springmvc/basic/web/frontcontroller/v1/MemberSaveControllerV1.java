package com.example.springmvc.basic.web.frontcontroller.v1;

import com.example.springmvc.basic.web.Member;
import com.example.springmvc.basic.web.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = new MemberRepository();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);
        request.setAttribute("member", member);
        String viewPath = "/response/save";

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
