package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.Testservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Controller
@RequestMapping("/cbse")
public class TestController {

    @Autowired
    Testservice testservice;

    @RequestMapping(value = "testdata" ,method= RequestMethod.GET)
    @ResponseBody
    public void testing(@RequestParam int id, @RequestParam String name ,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{

        PrintWriter printWriter = httpServletResponse.getWriter();

        testservice.testLoadData(id,name);
        System.out.println("Sucecss");


    }
}
