CTDog
=========

CTDog的全称为：Concurrent Tester Dog

CTDog 可以根据用户设定执行并发测试。在系统资源允许的情况下，可以在同一秒内向目标接口发任意大

的并发请求，且持续时间任意久。

主要特点：

 - 小巧，自身的资源消耗几乎可以忽略不记
 - 在系统资源足够大的情况下准确率100%
 - 使用java开发，用java语言编写测试脚本，实现Action 接口即可
 - 运行参数及分析报告自定义拓展
 
Using
------

```sh

-a : Action
-c : 每秒并发数
-t ：接口响应超时
-i : 运行指数（默认为：5，由测试环境决定）
-d : 持续时间
-p : 测试参数设置。 格式：[key1,value1,key2,value2,...]

```

Examples
--------

https://github.com/aiyanbo/ctdog/tree/master/src/test/java/jmotor/ctdog

Version
-------

0.0.1

Dependencies
------------
log4j 1.2.17

Build
------

```sh

git clone https://github.com/aiyanbo/ctdog.git

cd ctdog

mvn clean install

```

Maven
------

```xml
<dependency>
    <groupId>org.ctdog</groupId>
    <artifactId>ctdog</artifactId>
    <version>0.0.1</version>
</dependency>
```

Gradle
------

```groovy
dependencies{
    compile 'org.ctdog:ctdog:0.0.1'
}
```