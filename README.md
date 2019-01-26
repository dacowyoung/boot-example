# boot-example
### 一. 前言 
        从2016年底springboot的技术预研,到2017年初正式使用springboot相关技术搭建并运行项目,一晃已经到2019年了.
    两年过去了,在后续的springboot项目开发中,陆续集成并使用了不同类型的技术方案.
        数据库mysql,mongodb,redis,文件上传fastdfs,自动部署jenkins等等.但在此我不会对这些相关集成的技术进行详细
    的说明,而只针对于最基本的项目搭建和CRUD业务进行example过程记录.
        一方面是两年过去了,相关的集成技术及应用文档在很多大牛的博客中都能找到完整的解决和应用方案,并且很多大牛还在
    博客中开放了评论和提问的功能,实现了"性感大牛,在线指导",在此我就不一一赘述了.另一方面,example这个项目主要是为了能
    够快速而有效的进行web开发而整理出来的一个脚手架,结合springboot两年的使用经验,尽量做到简洁明了,拿来即用. 

* 大牛的博客: [纯洁的微笑](http://www.ityouknow.com/) , [方志朋的博客](https://www.fangzhipeng.com/)
    
### 二. springboot知识整理
> 前置知识:  
1.maven构建项目  
2.spring注解  
3.restful api  

#### 1.springboot的特点
* 化繁为简,简化配置       
* 当前应用最多框架
* 微服务入门级微框架(springboot-->springcloud-->微服务)

#### 2.hello,springboot!
* idea编辑器使用 [idea官网下载](https://www.jetbrains.com/idea/) , [idea快捷键及使用技巧](https://www.cnblogs.com/jajian/category/1280011.html)
* 项目构建,建议使用spring官网提供的入口 https://start.spring.io/ 进行构建,构建完成后项目会自动下载zip包 
* idea导入项目,左上角File-->Open,然后选中zip包解压后的项目
* dependency中添加spring-boot-starter-web
* 新建类HelloCtrl,并写一个say方法
```
@RestController
public class HelloCtrl {
    @GetMapping(value = {"/hello", "/hi"})
    public String say() {
        return "hello,springBoot!";
    }
}
```  
* 启动项目后就可以访问127.0.0.0/hello 就可以看到"hello,springBoot!"

#### 3.自定义属性配置  
* application.yml使用,由properties改为yml,配置更加简洁
* 获取配置中的值@Value
```
 @Value("${name}")
 private String name;
```
* 配置之中使用配置
```
content: "i'm ${name},age is ${age}"
```
* 配置映射实体类@Component,@ConfigurationProperties 
```
yml配置: 
people:
  name: xiaoming
  age: 19
```  
```
实体类:
@Component
@ConfigurationProperties(prefix = "people")
public class PeopleProperties {
    private String name;
    private Integer age;
    getter,setter...
}  
```
* dev,prod不同环境配置切换,增加application-dev.yml和application-prod.yml.  
idea中根据application.yml中spring.profiles.active属性值变化进行切换.  
服务器上使用java -jar example.jar启动时增加--spring.profiles.active=prod环境参数,进行不同环境配置动态切换
```
spring:
  profiles:
    active: dev
```

#### 4.数据库操作相关配置依赖  
* mysql
```
spring:
  datasource:
    url: jdbc:mysql://192.168.4.99:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT
    username: develop
    password: develop
    driver-class-name: com.mysql.cj.jdbc.Driver
    # 使用druid数据源
    type: com.alibaba.druid.pool.DruidDataSource
```
```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.0</version>
</dependency>
```
* mybatis
```
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    #支持驼峰命名自动映射
    mapUnderscoreToCamelCase: true
  mapperLocations:
    - classpath*:mybatis/**/*.xml
```
```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.2</version>
</dependency>
```
* mybatis自动生成插件
```
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.2</version>
    <configuration>
        <configurationFile>generatorConfig.xml</configurationFile>
        <verbose>true</verbose>
        <overwrite>true</overwrite>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.46</version>
        </dependency>
    </dependencies>
</plugin>
```
generatorConfig.xml自动生成配置文件
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
  <context id="context1">
    <jdbcConnection connectionURL="jdbc:mysql://192.168.4.99:3306/dev_bus" driverClass="com.mysql.jdbc.Driver" password="develop" userId="develop" />
    <javaModelGenerator targetPackage="com.young.bootexample.model" targetProject="src/main/java" />
    <sqlMapGenerator targetPackage="mybatis.auto" targetProject="src/main/resources" />
    <javaClientGenerator targetPackage="com.young.bootexample.dao" targetProject="src/main/java" type="XMLMAPPER" />
    <table tableName="test_user"></table>
    <table tableName="***"></table>
    ...
  </context>
</generatorConfiguration>
```
在数据库设计完成后,对应的表名配置完成后,使用idea中右侧maven-->Plugins-->mybatis-generator,自动生成对应model,mapper,xml文件,简化开发

#### 5.restful API
* 创建UserCtrl
```
@RestController
public class UserCtrl {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void add(@RequestBody TestUser user) {
        userService.add(user);
    }

    @PutMapping("/user")
    public void edit(@RequestBody TestUser user) {
        userService.edit(user);
    }

    @GetMapping("/user")
    public TestUser findOne(@RequestParam("id") String id) {
        return userService.findOne(id);
    }

    @GetMapping("/user/list")
    public List<TestUser> list(TestUser user) {
        return userService.list(user);
    }

    @DeleteMapping("/user")
    public void del(@RequestParam("id") String id) {
        userService.del(id);
    }
}
```
请求调用遵循restful风格,post,delete,put,get,一一对应增删改查,
* 创建UserService接口及实现类UserServiceImpl
```
public interface UserService {

    List<TestUser> list(TestUser user);

    void add(TestUser user);

    void edit(TestUser user);

    TestUser findOne(String id);

    void del(String id);
}
```
```
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TestUserMapper mapper;

    @Override
    public List<TestUser> list(TestUser user) {
        TestUserExample e = new TestUserExample();
        TestUserExample.Criteria c = e.createCriteria();
        if (null != user) {
            if (null != user.getId()) {
                c.andIdEqualTo(user.getId());
            }
            if (null != user.getName()) {
                c.andNameEqualTo(user.getName());
            }
            if (null != user.getAge()) {
                c.andAgeEqualTo(user.getAge());
            }
        }
        return mapper.selectByExample(e);
    }

    @Override
    public void add(TestUser user) {
        mapper.insert(user);
    }

    @Override
    public void edit(TestUser user) {
        mapper.updateByPrimaryKey(user);
    }

    @Override
    public TestUser findOne(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void del(String id) {
        mapper.deleteByPrimaryKey(id);
    }

}
```
整个CRUD模块完成,两个类UserCtrl,UserServiceImpl,一个接口UserService.对应的model,mapper,xml都由mybatis-generator自动生成,代码简洁明了

#### 6.事务管理
*  使用@Transactional进行事务管理,保证方法中要么同时成功,要么同时失败,事务回滚
```
@Override
@Transactional
public void addTwo() {
    TestUser user = new TestUser();
    user.setName("军军");
    user.setAge(20);
    mapper.insert(user);
    
    TestUser user1 = new TestUser();
    user1.setName("壮司机");
    mapper.insert(user1);
}
```
 

### 7.AOP统一处理请求日志
* AOP是一种编程范式,与语言无关,是一个程序设计思想.  
面向切面(AOP) : Aspect Oriented Programming  
面向对象(OOP) : Object Oriented Programming  
面向过程(POP) : Procedure Oriented Programming  
* 面向过程(C)-->到面向对面(java)-->面向切面
* 将通用逻辑从业务逻辑中分离出来
* 添加spring-boot-starter-aop依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
* 编写HttpAspect请求日志切面
```
@Aspect
@Component
public class HttpAspect {

    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.young.ctrl.UserCtrl.*(..))")
    public void log() {
    }

    @Before("log()")
    public void Before(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        log.info("url={}", request.getRequestURL());
        //method_type
        log.info("method_type={}", request.getMethod());
        //ip
        log.info("ip={}", request.getRemoteAddr());
        //类方法
        log.info("class_method={}", point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        //参数
        log.info("args={}", point.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.info("----------After----------");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        log.info("response={}", object);
    }
}
```
* 查看日志截图  
![日志截图](pic/日志图片.png)

