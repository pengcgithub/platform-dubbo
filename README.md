# platform-dubbo

## 简介

platform-dubbo以学习dubbo分布式框架为基础搭建的项目，接下来会根据实际项目的需求叠加技术点。


## 目录结构 

##### platform-parent |   父类依赖包，版本控制

##### platform-common  |   工具类

##### platform-user  |  用户服务
* platform-api-user      |  用户服务接口
* platform-server-user   |  用户服务提供者
* platform-web-user      |  用户服务消费者

##### docs              |  platform文档

##### sql               |  platform 依赖sql


## 技术说明

- spring 4.2.0.RELEASE
- mybatis 3.4.0
- druid 1.0.20
- lombok 1.18.0
- logback
- dubbo 2.8.4
- zookeeper 3.4.6
- pageHelper
- swagger 2.4.0

- 计划引入的技术
    - redis
    - fastDFS
    - 接口验证
    - mapper通用接口
    - sharding-jdbc
    - 统一异常处理
    - Docker
    
## 本地运行

- 克隆项目到本地： `https://github.com/pengcgithub/platform-dubbo.git`
- 启动服务提供者： platform-service-user下的`Provide.java`文件
- 启动服务消费者： `platform-web-user`
- 启动成功，访问swagger地址： `http://localhost:8888/user/swagger-ui.html`

    
## 联系方式

- 邮件：pengcheng3211@163.com

