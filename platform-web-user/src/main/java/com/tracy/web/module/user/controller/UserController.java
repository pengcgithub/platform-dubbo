package com.tracy.web.module.user.controller;

import com.tracy.api.order.service.OrderService;
import com.tracy.api.user.entity.UserBean;
import com.tracy.api.user.service.UserService;
import com.tracy.web.module.user.service.UserServiceMock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @see com.tracy.web.module.user.controller
 * @since 2018/6/6
 */
@Api(value="用户",description="用户相关操作")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserServiceMock userServiceMock;

//    @Autowired
//    private UserSearchService userSearchService;

    @ApiOperation(value="分页查询用户", notes="分页查询用户信息", response = UserBean.class)
    @RequestMapping(value = "/queryUserByPage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public List<UserBean> queryUserByPage(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int rows) {
        List<UserBean> userList = userService.queryUserList(page, rows);
        return userList;
    }

    @ApiOperation(value="队列中发送消息", notes="队列中发送消息", response = String.class)
    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public void sendMessage(@RequestParam String message) {
        userService.sendMessage(message);
    }

    @ApiOperation(value="测试solr服务", notes="测试solr服务", response = String.class)
    @RequestMapping(value = "/testSolrService", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Boolean testSolrService(@RequestParam String queryParam) {
//        try {
//            userSearchService.searchItems(queryParam, 0, 10);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return Boolean.TRUE;
    }

    @ApiOperation(value="测试solr服务", notes="测试solr服务", response = String.class)
    @RequestMapping(value = "/mockOrder", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Boolean mockOrder(@RequestParam String userId, @RequestParam String productId, @RequestParam Integer count) {
        return userServiceMock.mockOrder(userId, productId, count);
    }



}
