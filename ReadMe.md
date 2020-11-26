**Springboot + MongoTemplate**  
1 - application.yml: 
        Mongdo DB 配置信息
2 - MongoDBConfig.java:
        1) 实例化 MongoClient Bean: 通过MongoClientFactoryBean 生成 MongoClient(可以理解为 关系数据库 DataSource对象)
        2) 实例化 MongoTemplate: 将MongoClient 注入 MongoTemplate
           通过MongoTemplate 直接操作 Mongo DB
           
**Springboot + Spring Data Mongo JPA (文档关系映射)**  
1 - application.yml: 
        Mongdo DB 配置信息
2 - MongoDBConfig:
        1) 实例化 MongoClient Bean: 通过MongoClientFactoryBean 生成 MongoClient(可以理解为 关系数据库 DataSource对象)
        2) 实例化 MongoTemplate: 将MongoClient 注入 MongoTemplate
           通过MongoTemplate 直接操作 Mongo DB
        3) 构建文档对象 => @Document, @Id, @Field (类似JPA Entity)
        4) 构建Repository接口 => 实现 MongoRepository (Spring 自动生成实现)
           通过 Repository接口编程(Service) 去操作Mongo DB

**注意: 2种方式实现**  
    公共的部分为: application.yml, MongoDBConfig.java
    不同的实现: 分别为com.yehl.springdata(Jpa 实现具体使用) 和 com.yehl.template (MongoTemplate 实现具体使用)

**Tips**  
1 - 搭建SpringBoot框架时碰到的问题。
    ** WARNING ** : Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package.

    （注意：我在编写Main方法的时候并没有加@ComponentScan注解，因而，他会扫描Application所在的包里的对象）
    如果当前启动类没有包，则在启动时会报错：Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package错误。

    （注意：写在java文件夹下的Application类，是不从属于任何一个包的，因而启动类没有包）
    解决办法
    方法一、将Application建在其他的包下面
    方法二、在Application类上面加@ComponentScan注解，指定要扫描的包
    
2 - MongoTemplate.save() 重复则update, 非冲突异常抛出
