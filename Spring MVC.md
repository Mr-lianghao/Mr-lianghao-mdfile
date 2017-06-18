## 1.流程
1. jar包
2. log4j--classpath
3. sqlMapConfig.xml--classpath
3. po--domain
4. 映射文件po--sqlmap文件夹
5. 加载映射文件
6. 测试

## 2.原生dao
1. jar
2. log4j
3. sqlMapConfig.xml
4. po
5. 映射文件
6. 加载映射文件
7. dao和DaoImpl（注入sessionFactory和进行sqlsession处理）
8. 测试（进行创建sessionFactory和调用UserDao）

## 3.使用反射代理的原则
1. Mapper.xml文件中的namespace与mapper接口的类路径相同。
2. Mapper接口方法名和Mapper.xml中定义的每个statement的id相同 
3. Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同
4. Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
## 4.反射生成
1. jar
2. log4j
3. sqlMapConfig.xml
4. po
5. 把上面的映射文件改成Mapper.xml
6. 生成



----------

----------
## 5.输入类型和输出类型
- 简单类型
- pojo对象
- 传递pojo包装对象——vo用于查询
- 输出类型
	- 简单类型
	- pojo类型
	- pojo列表
	- resultMap*

### <sql>标签的使用
- 类似于常量？-没有判断时，只有输入的属性名，当有判断时，可以包含值
- `<sql id="user_Where">   
		<!-- where标签作用:       
				会自动向sql语句中添加where关键字   
				会去掉第一个条件的and关键字   
			 -->  
		<where>
			<if test="username != null and username != ''">
				and username like '%${username}%'
			</if>
			<if test="sex != null and sex != ''">
				and sex=#{sex}
			</if>
		</where>
	</sql>`

## 6.动态sql
1. if
	1. `<sql id="query_user_vo">
		<if test="id!=null">
			and id= #{id}
		</if>
		<if test="username!=null and username!=''">
			and username like '%${username}%'
		</if>		
	</sql>`
2. where
	1. `select * from user
		<where>
			<include refid="query_user_vo"/>
		</where>`
3. foreach
	1. `<if test="ids!=null and ids.size>0">
				<foreach collection="ids" open="and id in(" close=")" item="id" separator=","></foreach>
			</if>`
4. sql片段——如上


# 整合spring和Mybatis
## 1.传统dao开发
1. 导入jar包
2. 编写po类
3. 编写sqlmapConfig.xml
4. 编写applicationContext.xml
	1. 数据源
	2. 事务
	3. 导入sqlmapConfig
	4. 注入sqlsessionFactory
	5. 创建userDao的bean

1. 编写dao：集成sqlSessionDao，通过getSession获取，进行操作
2. 编写user.xml映射文件
3. 编写测试类

## 2.mapper代理
1. 导入jar
2. 编写po
3. 编写sqlmapConfig.xml
4. 编写applicationContext.xml——如上，但是不用配置userDao。而是配置代理工厂`<!-- 配置mapper代理对象 -->
	<bean class="org.mybatis.spring.mapper.MapperFactoryBean">
		<property name="mapperInterface" value="com.itcast.mapper.UserMapper"/>
		<property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
	</bean>`
5. 编写UserMapper.xml和UserMapper.java（也就是之前的UserDao接口）
5. 编写测试类

## 3.mapper代理注解方式
也就是减少了sqlmapConfig.xml中多次加载mapper的时候
- applicationContext.xml中配置Mybatis的注解扫描
- 去除sqlmapConfig中的引入

## 4.逆向工程
1. 导入jar包：mybatis核心、log4j、驱动包、逆向工程包
2. classpath下创建generator.xml——需要修改一些东西
3. 创建java文件，贴入示例代码

	