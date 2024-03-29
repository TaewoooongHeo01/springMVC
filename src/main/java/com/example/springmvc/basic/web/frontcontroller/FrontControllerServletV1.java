package com.example.springmvc.basic.web.frontcontroller;

import com.example.springmvc.basic.web.frontcontroller.v1.ControllerV1;
import com.example.springmvc.basic.web.frontcontroller.v1.MemberFormControllerV1;
import com.example.springmvc.basic.web.frontcontroller.v1.MemberListControllerV1;
import com.example.springmvc.basic.web.frontcontroller.v1.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/form",
                new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/save",
                new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/list",
                new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");
        String requestURI = request.getRequestURI();

        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return; }
        controller.process(request, response);
    }
}
