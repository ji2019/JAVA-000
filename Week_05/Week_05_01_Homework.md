```

01 
（选做）使java里动态代理。实现一个简单的AOP
(必做)写代码实现 Spring Bean 的装配，方法越多越好（XML，Annotation 都可以），提交到GitHub.
（选做）实现一个SPring XML 自定义配置，配置一组 Bean，例如 Student Klass School



附加题
（挑战）讲网关的 frontend /backend/filter/router 线程池 都改成 spring 配置方式
（挑战）基于AOP 改造 Netty 网关，filter和router 使用 aop方式实现。
（挑战中级）基于前述改造，将网关请求前后端分离，中级使用JMS传递消息。
（挑战中级）尝试 使用 ByteBuddy 实现一个简单的基于类的AOP
（超级挑战）尝试使用 ByteBuddy 与 Instrument实现一个简单的JavaAgent实现无侵入下的AOP.


















02
1 （选做）总结一下，单例的各种写法，比较他们的优劣。
2 （选做）maven/spring 的profile 机制，都有什么用法？
3 （必做）给前面提到的Student/klass/Shool 实现自动配置和Starter
4 （选做）总结 Hibernate 与 MyBatis 的各方面异同点。
5 （选做）学习MyBatis-generator 的用法和原理。学会自定义 TypeHandler 处理复杂类型。
6 （必做）研究一下JDBC接口和数据库连接池。掌握他们的设计和用法。
    1. 使用JDBC 原生接口，实现数据库的增删改查操作。
    2. 使用事务，PrepareStatement方式，批处理方式，改进上述操作。
    3. 配置 Hikari 连接池，改进上述操作。提交代码到Github.
附加题 （可以后面上完数据库的课再考虑做）
  （挑战）基于AOP和自定义注解实现@MyCache(60)对于指定方法返回值缓存60秒。
  （挑战）自定义实现一个数据库连接池。并整合 Hibernate/Mybatis/Spring/SpringBoot 
  （挑战）基于MyBatis 实现一个简单的分库分表 + 读写分离 + 分布式ID 生成方案。

```

