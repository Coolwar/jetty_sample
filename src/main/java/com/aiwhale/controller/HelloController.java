package com.aiwhale.controller;

import com.aiwhale.tool.Code;
import com.aiwhale.tool.Return;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wendong
 * @email wendong@aiwhale.com
 * @date 2017/8/16.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public Return hello() {
        return Return.SUCCESS(Code.SUCCESS);
    }

}
