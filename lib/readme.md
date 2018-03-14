# 安装jar包到本地仓库

从钉钉官网，找如下到jar包到当前目录；在命令行窗口，执行如下脚本，安装jar到本地仓库。

* lippi-oapi-encrpt.jar
* client-sdk.api-1.0.2.jar
* client-sdk.common-1.0.0-SNAPSHOT.jar
* client-sdk.core-1.0.0-SNAPSHOT.jar
* client-sdk.spring-1.0.0-SNAPSHOT.jar
* taobao-sdk-java-auto_1479188381469-20170724.jar

    mvn install:install-file -DgroupId=com.laiwang.lippi -DartifactId=lippi.oapi.encryt -Dversion=1.0.3-SNAPSHOT -Dpackaging=jar -Dfile=lippi-oapi-encrpt.jar
    mvn install:install-file -DgroupId=com.dingtalk.open -DartifactId=client-sdk.api -Dversion=1.0.2 -Dpackaging=jar -Dfile=client-sdk.api-1.0.2.jar
    mvn install:install-file -DgroupId=com.dingtalk.open -DartifactId=client-sdk.common -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar -Dfile=client-sdk.common-1.0.0-SNAPSHOT.jar
    mvn install:install-file -DgroupId=com.dingtalk.open -DartifactId=client-sdk.core -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar -Dfile=client-sdk.core-1.0.0-SNAPSHOT.jar
    mvn install:install-file -DgroupId=com.dingtalk.open -DartifactId=client-sdk.spring -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar -Dfile=client-sdk.spring-1.0.0-SNAPSHOT.jar
    mvn install:install-file -DgroupId=com.dingtalk.open -DartifactId=taobao-sdk-java -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar -Dfile=taobao-sdk-java-auto_1479188381469-20170724.jar