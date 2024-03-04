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
import java.util.List;


public class MemberListControllerV1 implements ControllerV1 {

    private final MemberRepository memberRepository = new MemberRepository();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
        String viewPath = "/response/list";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
