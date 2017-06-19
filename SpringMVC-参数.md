## 参数绑定
如何从请求中接收参数
## 需求驱动学习
- 根据SSM整合的修改进行学习
## 普通参数

1. - list
- itemEidt-根据id：进入编辑页面
如何接收参数？-request接收，Model放入返回页面的数据（对request域进行扩展），如果springMVC方法返回一个简单字符串，就是这个页面的名称。
- 修改itemEdit方法：req、resp、session是springMVC默认支持的参数类型，在controller中可以加可以不加

2. updateitem（提交更新）：
	- ModelAndView和String的返回值方式都可以，让自己的习惯选择，String的方式更简单
	-  同时建议使用model而不是request，因为model对request进行封装了
	-  RequestMapping("/updateitem")
	-  string update(Integer id,String name,Float price,String detail)假设能够直接传过来，然后执行更新，能够接收到数据，但是发生啦中文乱码。——在web.xml中进行配置解决post方式，get方式可以在tomcat中或代码中。
	-  。以上说明：springMVC能够直接接受基本数据类型，包括string(以前学习觉得string不是基本)，springMVC可以帮你自动进行类型转换
	-   。controller方法接收的参数的变量名必须等于页面上的name属性值
- updateitem（更新改进）：感觉方法的参数太多了，能不能对参数封装成对象引用呢？
	- 。String updateitem(Item item)
	- 。能够接收pojo并进行更新
	- 。分析：springMVC能够接收pojo类型，要求input名称必须等于pojo属性名
- search(高级查询)：定义QueryVo和页面
	- @RequestMapping("/search")
	- String search(vo)
	- 前台jsp中传递的参数是二级以上导航，那么使用的是items.name类似的
	-  。分析：接收Vo类型，需要jsp中加入导航的
- 接收日期改进update编辑页面：
	- 前台转过来的是String类型，无法转换为Item中的Date类型。——引出日期转换器
	- 新建包和类converter：CustomGlobalStringToDate  implements Converter<String（源）,Date（目标）
	-  Date convert(String source)
	-  springmvc.xml中配置自定义转换器
	-  把转换器放到注解驱动中，由处理器适配器来指定它转换。因为前台传递过来的string是有格式的。

## Struts2和Spring的区别：

## 高级参数绑定：数组和List——通过批量删除
 

1. delAll（批量删除）：
	1.  RequestMapping(“/delAll”)
	2.   一组同名框的值如何传递到controller？——放到vo中，vo中定义一个Integer的数组，注意名字要一样
                                            


1. updateAll（批量修改）：根据id进行修改
	1. 如何接收List<Item>，放到vo中，input的属性值：vo接收的集合属性名称+[list的下标]+.+list泛型的属性名称
	2. 注解：对于简单类型的接收：起别名：@RequestParam（页面属性id） Request iddddd


---------------------------------------------------
## @RequestMapping（） ：


1. url对请求方法的映射，这是放在方法上
2. 如果放在类上，那么就相当于加了一层目录：为了起名的重复——窄化请求映射
3. 限定请求方式：@RequestMapping（value="/items",method=RequestMethod.GET）
## Controller的返回值（指定返回到哪个页面，指定返回哪些数据)


1. ModelAndView：    addObject()——指定返回的页面数据                                            

1. setViewName()——指定返回页面


1. String：返回普通字符串，就是页面去掉扩展名的名称，数据由Model来完成


1. void：可以使用request.setAttr()来返回页面数据，使用despatcher等返回页面


1. 请求转发
	1. 浏览器的url不发生改变，request域中的数据可以带到转发后的方法中，以forward开头
	2. return "forward:itemEdit.action"——相对路径：相对于当前路径
	3. return "forward:/items/itemEdit.action"——绝对路径：相对于项目名后面开始算


1. 重定向：
	1. url发生改变，request域中数据不带刀重定向后的方法中  ,以redirect:开头      
	2.  return "redirect:itemEdit.action"——model对request的封装:域中的数据不能带过去             

##  上传图片：



1. 把图片放到图片服务器中：双击tomcat——model——addExternal——设置Path： /pic 和路径



1. 上传图片：商品图片的显示



1. 修改form表单enctype：表单平时是以字符串的形式上传，图片等都是以二进制的方式上传



1. struts使用fileupload：进行解析上传的内容



1. SpringMVC对外提供解析接口，但是没有实现，所以需要导入fileupload包



1. springMvc.xml中配置上传解析器：update方法中



1. update方法中加入MultipartFile pic



1. 但是图片是否存入数据库中呢？可是传输数据太慢了，路径可以存入数据库中，图片存入到服务器中
##  json数据交互：


1. json算是一种压缩格式。——一点击就发送json


1. 传到controller，需要解析，手工解析那就麻烦——希望springMVC从请求中接收过来，并帮我们解析，当我们需要传到页面时，帮我们拼接并发送过去


1. 导入jar包


1. 接收：使用对象pojo进行封装


1. 跳转：加入@ResponseBody，直接返回pojo对象
                            
## RESTful支持：
 

1. Url的明明风格，讲究的是资源操作（请求类型get等）和资源定位（）：要求url不能用？传参和.action，只能有名词不能由动词。——itemList.jsp


1. 注解：减轻代码量，使用方便，但是缺点是只有自己熟悉
web.xml中设置/*成/（.action：拦截action结尾的；/拦截所有不包括jsp；/*所有包括jsp）


1. 修改itemList.jsp中的问号为/item/${item.id}


1. 修改RequestMapping(/item/{id})，此处的id和传入的id一样，顺序也要一样，传多个/item/{id}/{name}


1. 修改方法的参数：itemEdit(@PathVariable("id")) Integer id......)，其中：PathVariable接收Url传入的参数，接收参数使用大括号{}加上变量名称PathVariable的变量名称和@RequestMapping中的名称一致

## 拦截器：拦截请求——更多的是在权限登录时


1. 创建interceptor文件夹， 编写Interceptor，实现HandlerInterceptor


1.  preHandle：时机：controller方法没有被执行时，modelAndView没有被返回，用于例如权限验证判断有没有session，如果有就放行，否则进行拦截，返回true-放行；返回false-拦截                


1. postHandle：时机：controller已经执行，ModelAndView没有返回，场景：可以此方法设置全局的数据业务，比如天气


1.  afterCompletion：controller已经执行，返回。用于记录操作日志。                        

1. 配置拦截器：springMvc.xml：<mvc:interceptors ><interceptor><mapping path="/**"（/**拦截所有）><bean class="全路径名">//指定拦截器的位置

1. 多个拦截器的执行顺序：web.xml中的配置顺序

##  登陆权限验证


1. 编写登陆的controller，编写跳转到登陆也面对额方法，编写登陆验证方法：


1. 编写登陆页面

1.               编写拦截器

1.                配置拦截器
   

1.  运行过程：
   

	-  发送一个请求，拦截器拦截请求，验证session中是否由登陆信息，如果已经登陆，放行，否则跳转到登陆页面

	-              在登陆页面中输入用户名，密码，点击登陆按钮，
               

	- 拦截器会拦截请求，如果是登陆页面路径，放行，
               

	- 在controller中判断用户名密码是否正确，如果正确放入session中
                            
