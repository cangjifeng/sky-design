package org.jerfan.design.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jerfan.cang
 * @date 2019/8/28  9:54
 */
@RestController
public class ServerController {

    @ResponseBody
    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public String start(){
        return "design model application server started successfully";
    }
}
