package com.alix.product.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alix
 * @date 2019-03-14 13:49
 */
@RestController
public class ServiceController {

    @GetMapping("/getMsg")
    public String msg(){
        return "hello this is a product smg";
    }


}
