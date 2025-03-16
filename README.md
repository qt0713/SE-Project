# SE-Project
软工项目
技术架构
后端架构
基础框架：Spring Boot 3.x

项目结构：Maven多模块项目

核心模块：

scooter-common: 公共基础组件
scooter-plugin: 功能插件集合
scooter-plugin-api: 插件API接口定义
scooter-web-app: 应用程序启动模块
关键插件：

scooter-plugin-auth: 基于Sa-Token的身份认证与权限管理
scooter-plugin-biz: 核心业务功能实现
scooter-plugin-sys: 系统管理功能
scooter-plugin-dev: 开发工具与配置
前端架构
技术栈：基于Vue框架（admin-web目录）
UI框架：Ant Design Vue
构建工具：支持开发与生产环境配置
开发环境与工具
开发工具链
构建工具：Maven
版本控制：Git (托管于Gitee)
IDE支持：
IntelliJ IDEA (完整项目支持)
Visual Studio Code (前端开发支持)
代码质量：ESLint (前端代码规范)
中间件与数据库
缓存中间件：Redis (用于Sa-Token会话管理)
ORM框架：推测使用MyBatis Plus (基于mybatisx目录判断)
已实现功能
当前项目已完成了基础框架搭建和核心功能模块的开发，包括：

身份认证系统：完整的用户登录、认证流程
权限管理：基于Sa-Token的权限控制体系
业务插件：已构建业务功能插件框架，与认证、系统管理模块完成了接口对接
插件化架构：建立了API接口与实现分离的插件化架构
