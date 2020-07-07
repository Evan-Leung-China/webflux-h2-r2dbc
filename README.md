# 目的
    本工程（webflux-h2-r2dbc）为demo工程，旨在学习webflux和r2dbc。
# 技术栈
    Springboot：2.3.1.RELEASE（当前的最新版本），可以由它找到对应的jar的版本
    由工程名也能知道，使用的是 webflux(2.3.1.RELEASE) + r2dbc(1.1.1.RELEASE)
    数据库采用内存数据库 H2database(1.4.200)
# 遇到的问题
## Webflux
   1. 内存数据库H2的console不支持，无法访问其默认的H2的控制台： /h2-console，原因采用的是Servlet提供的，见：
        org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration.h2Console
   2. Swagger2的整合，由于Swagger目前对于Webflux的支持还只有SNAPSHOT版本，所以需要留意maven仓库地址，否则可能会出现下载不了问题
## r2dbc
    在构建此工程时，r2dbc距离其第一个发布的公开版本（1.0.0.RELEASE），也才过去半年多。
    // TODO: 查明以下问题的原因
   1. 事务问题。目前发现，如果像在jdbc那样显示声明@Transactional的各个属性，将会出现空指针异常
   2. Repository接口问题。如果直接实现org.springframework.data.repository.reactive.ReactiveSortingRepository，
      在调用findAll(Sort)方法时，将出现异常。