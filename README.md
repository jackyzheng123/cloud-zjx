Spring Cloud
===

所使用相关技术：
---

Eureka：服务注册与发现

Config：配置中心，支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库

Ribbon：负载均衡客户端 rest + ribbon

Feign：Feign是一个声明式的伪Http客户端，Feign 采用的是基于接口的注解，Feign 整合了ribbon，具有负载均衡的能力，整合了Hystrix，具有熔断的能力

Hystrix：断路器，解决“雪崩”效应

Zuul：路由转发和过滤器，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能；过滤器继承ZuulFilter
Gateway:

Bus：消息总线，将分布式的节点用轻量的消息代理连接起来。它可以用于广播配置文件的更改或者服务之间的通讯，也可以用于监控

Zipkin、Sleuth：服务追踪组件zipkin，Spring Cloud Sleuth集成了zipkin组件

Hystrix Dashboard：断路器模型,提供了数据监控和友好的图形化界面。利用Hystrix Dashboard去监控断路器的Hystrix command

Hystrix Turbine：聚合所有Hystrix Dashboard服务


---

参考：https://blog.csdn.net/forezp/article/details/70148833


