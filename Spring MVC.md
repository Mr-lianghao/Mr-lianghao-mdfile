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
2. where
3. foreach
4. sql片段