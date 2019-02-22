package com.tracy.web.module.user.job;

import com.tracy.api.user.entity.UserBean;
import com.tracy.api.user.service.UserService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;


/**
 * 任务Handler示例（Bean模式）
 * 
 * 开发步骤：
 * 1、继承"IJobHandler"：“com.xxl.job.core.handler.IJobHandler”；
 * 2、注册到Spring容器：添加“@Component”注解，被Spring容器扫描为Bean实例；
 * 3、注册到执行器工厂：添加“@JobHandler(value="自定义jobhandler名称")”注解，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 * 
 * @author xuxueli 2015-12-19 19:43:36
 */
@JobHandler(value="demoJobHandler")
@Component
public class UserJobHandler extends IJobHandler {

	@Resource
	private UserService userService;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		System.out.println("进入方法。。。。。。");
        UserBean userBean = userService.queryByPhone(18262632337L);
        System.out.println(userBean.toString());
        return SUCCESS;
	}
	
}
