手写mybatis框架

一、实现思路

    1、加载配置文件
        - 创建Resources类，负责加载文件，加载成字节输入流InputStream，存储到内存中
    2、创建两类bean
        - 配置类：Configuration类，存储mybatis-config.xml解析出的内容
        - Mapper类：MappedStatement类，存储mapper.xml解析出的内容
    3、解析配置文件
        - 解析加载的字节流，填充两类bean
        - 具体是创建SqlSessionFactoryBuilder类，编写build(InputStream)方法进行解析，封装Configuration类
        - build方法
            - 解析采用dom4j+xpath
            - 创建SqlSessionFactory并返回
    4、创建SqlSessionFactory接口及DefaultSqlSessionFactory实现类
        - 方法openSession创建SqlSession
    5、创建SqlSession接口和DefaultSqlSession实现类
        - 添加增删改查方法
        - 这里的方法不直接调用Jdbc，而是委派给Executor去执行
    6、创建Executor接口和实现类SimpleExecutor
        - 封装底层Jdbc代码

    视频链接：https://www.bilibili.com/video/BV1R14y1W7yS