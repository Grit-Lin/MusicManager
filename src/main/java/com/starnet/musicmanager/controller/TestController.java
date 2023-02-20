package com.starnet.musicmanager.controller;

import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.common.TokenContext;
import com.starnet.musicmanager.common.VerifyToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:
 * @date:
 * @description 测试和C++端的数据交换
 */

@RestController
public class TestController {

    @GetMapping("/test/{string}")
    public String test(@PathVariable String string) {
        if(string != null) {
            return string;
        }
        return "传递的数据为空!";
    }

    @GetMapping("/test_verify/{string}")
    @VerifyToken
    public R<TokenContext> verifyTest(@PathVariable String string, @RequestAttribute TokenContext ctx) {
        return R.success(ctx);
    }
}
