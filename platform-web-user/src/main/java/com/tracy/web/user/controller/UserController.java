package com.tracy.web.user.controller;

import com.tracy.api.user.entity.UserBean;
import com.tracy.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.web.user.controller
 * @since 2018/6/6
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUserByPage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public List<UserBean> queryUserByPage(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int rows) {
        List<UserBean> userList = userService.queryUserList(page, rows);
        return userList;
    }

}
