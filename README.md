# SMS_micro_service-YTX.SDK

    基于容联云通讯的短信微服务，需要免费的朋友可以试试。

    httpclient的依赖需要手动打入仓库。
    打入步骤：
            1.容联云官网-注册-登录-控制台-开发文档-下载-短信Demo下载-Demo示例标题下一行蓝色链接Demo下载-下载Java REST Server Demo
            
            2.CCP_REST_SDK_JAVA_v2.7r1\demo\lib找到httpclient.jar包，执行maven导入命令即可。
            
            
            
            
 附：
 
    maven导入命令（进入jar所在目录）：
    Mvn install:install-file -Dfile=httpclient.jar -DgroupId=org.apache.commons -DartifactId=httpclient -Dversion=1.0 -Dpackaging=jar
