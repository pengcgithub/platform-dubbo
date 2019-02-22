# platform-dubbo

## 简介

platform-dubbo以学习dubbo分布式框架为基础搭建的项目，根据实际项目的需求叠加技术点。


## 目录结构 

##### platform-parent |   父类依赖包，版本控制

##### platform-common  |   工具类

##### platform-search  | 搜索服务
* platform-api-search      |  搜索服务接口
* platform-server-search   |  搜索服务提供者

##### platform-order  | 订单服务
* platform-api-order      |  订单服务接口
* platform-server-order   |  订单服务提供者

##### platform-user  |  用户服务
* platform-api-user      |  用户服务接口
* platform-server-user   |  用户服务提供者
* platform-web-user      |  用户服务消费者

##### docs              |  platform文档

##### sql               |  platform 依赖sql


## 技术说明

- 已引入的技术
    - spring 4.2.0.RELEASE
    - mybatis 3.4.0
    - druid 1.0.20
    - lombok 1.18.0
    - logback
    - dubbo
    - zookeeper 3.4.6
    - pageHelper
    - swagger 2.4.0
    - solr
    - [tcc-transaction](https://github.com/changmingxie/tcc-transaction)
    - [nacos配置中心](https://github.com/alibaba/nacos)
    - [xxl-job](https://github.com/xuxueli/xxl-job)

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
- 执行数据库脚本文件： `sql/database.sql`
- 准备基础环境以及配置参数：
    - [dubbo环境搭建](https://github.com/pengcgithub/java-development-environment/blob/master/dubbo.md)
    - [zookeeper环境搭建](https://github.com/pengcgithub/java-development-environment/blob/master/zookeeper.md)
    - [mysql环境搭建](https://github.com/pengcgithub/java-development-environment/blob/master/mysql/mysql%E5%AE%89%E8%A3%85.md)
    - 修改配置文件： `jdbc.properties`、`mq.properties`、`system.properties`
- 启动服务提供者： `platform-service-user/Provide.java`文件
- 启动服务消费者： `platform-web-user`
- 启动成功，访问swagger地址： `http://localhost:端口/user/swagger-ui.html`

    
## 联系方式

- 邮件：pengcheng3211@163.com

