
# 手写 mybatis 框架

    视频链接：https://www.bilibili.com/video/BV1R14y1W7yS

### JDBC的弊端
    
    1、数据库配置信息硬编码
    2、频繁的创建数据库连接
    3、SQL语句也是硬编码
    4、结果集解析操作很繁琐
    
### 自定义 mybatis 实现思路

    1、加载配置文件
        - 创建Resources类，负责加载文件，加载成字节输入流InputStream，存储到内存中
        - Resources.getResourceAsStream()
    
    2、创建两个bean
        - **Configuration类**：全局配置类，存储mybatis-config.xml解析出的内容
        - **MappedStatement类**：映射配置类，存储mapper.xml解析出的内容
        
    3、解析配置文件
        - 解析加载的字节流，填充Configuration、MappedStatement对象
        - **SqlSessionFactoryBuilder类**
            - SqlSessionFactoryBuilder.build()
                - 采用dom4j+xpath解析，封装Configuration类
                - 创建SqlSessionFactory对象并作为返回值
    4、创建SqlSessionFactory接口及DefaultSqlSessionFactory实现类
        - SqlSessionFactory.openSession()
            - 创建SqlSession
    5、创建SqlSession接口和DefaultSqlSession实现类
        - 添加增删改查方法
            - selectOne()
            - selectList()
        - 这里的方法不直接调用Jdbc，而是委派给Executor去执行
    6、创建Executor接口和实现类SimpleExecutor
        - 封装底层Jdbc代码
        - Executor.query()

