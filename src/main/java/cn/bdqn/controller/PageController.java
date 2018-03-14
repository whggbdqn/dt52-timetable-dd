package cn.bdqn.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.service.ClassesService;

@Controller
public class PageController {
    
    @Autowired
    private ClassesService services;
    
    @RequestMapping("/index")
    public String getIndex() throws Exception{
//        List<Classes> id = services.getClassesById(2);
        return "MyTable1";
    }
    
}
