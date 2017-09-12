package com.aiwhale.controller;

import com.aiwhale.model.User;
import com.aiwhale.service.HelloService;
import com.aiwhale.tool.Code;
import com.aiwhale.tool.Return;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wendong
 * @email wendong@aiwhale.com
 * @date 2017/8/16.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Return hello() {
        logger.info("【提示】调用 /hello/hello 接口");
        try {
            List<User> s = helloService.selectBy();
            logger.info("【提示】调用 /hello/hello 接口完成");
            return Return.SUCCESS(Code.SUCCESS).put("data", s);
        } catch (Exception e) {
            logger.info("【异常】调用 /hello/hello 接口异常", e);
            e.printStackTrace();
            return Return.FAIL(Code.INTERNAL_SERVER_ERROR);
        }
    }

}
