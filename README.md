# questionnaire-service

问卷调查服务端，基础框架基于 Spring Boot 2，数据持久化框架基于 Mybatis Plus。

## 准备

- `JDK 1.8` - Java 开发环境
- `MySQL 5.7` - 关系型数据库
- `Redis` - 非关系型数据库
- `IDEA` - Java 开发工具

## 开发流程

1. 克隆工程到本地
    ```bash
    git clone https://gitee.com/mhbseal/questionnaire-service.git
    ```
2. 导入工程到 IDEA 中
3. 通过目录下 db/spring_boot_demo.sql 脚本初始化 Mysql 数据
4. 在目录 src/main/resources 下参考 application-local-example.yml 根据实际情况新建 application-local.yml 配置文件
5. IDEA 中启动工程

## 更多

基础框架 [Spring Boot 2](https://spring.io/projects/spring-boot).  
数据持久化框架 [Mybatis Plus](https://baomidou.com/). 
