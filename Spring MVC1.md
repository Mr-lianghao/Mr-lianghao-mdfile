# Spring MVC

## 1.大概流程

## 2.入门案例
1. 创建web工程
2. 导入jar包-SpringMVC
3. 创建itemList.jsp
4. 创建ItemsController——注解
5. 创建springmvc.xml——配置注解扫描
6. 配置前段控制器

## 3.架构和过程
1. 用户发送请求至前端控制器DispatcherServlet
2. DispatcherServlet收到请求调用HandlerMapping处理器映射器。
3. 处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。
4. DispatcherServlet通过HandlerAdapter处理器适配器调用处理器
5. 执行处理器(Controller，也叫后端控制器)。
6. Controller执行完成返回ModelAndView
7. HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet
8. DispatcherServlet将ModelAndView传给ViewReslover视图解析器
9. ViewReslover解析后返回具体View
10. DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）。
11. DispatcherServlet响应用户

----------

### 处理器映射器HandlerMapping、HandlerAdapter处理器适配器、ViewResolve视图解析器

----------
## 3.1
1. 注解扫描：
2. 注解驱动：最新版处理器映射器+处理器适配器的配置
3. 视图解析器：视图解析器的配置，默认是jsp——prefix：前缀，suffix：后缀 作用：在controller中制定路径就不用写路径的完整路径

## 4.springMVC整合Mybatis
1. 导入jar包
2. 配置文件
	1. sqlmapConfig.xml——不用编写任何东西
	2. applicatonContext-dao.xml:数据源、sessionFactory、注解扫描器
	3. db.properties：配置连接相关
	4. applicationContext-service.xml:配置注解扫描service目录
	5. springmvc.xml:扫描controller类，加载注解驱动，视图解析器
	6. web.xml：配置前置过滤器
1. dao：使用逆向工程
2. service：接口和实现类
3. controller：