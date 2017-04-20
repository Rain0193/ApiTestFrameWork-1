# BeeCloudApiTest

## 项目管理
Maven


## 框架说明
容器：Spring

数据库：支持mysql、mongo、redis

请求模块：RestAssured

Assert模块：HarmCrest

Json解析：JsonPath

数据还原：基于AssertJDb的二次开发，具体实现见DbMonitor

## 用例编写&报告输出
TestNg

## 用例执行
mvn test

## Mappers/Dao/entity自动生成
需保留src/main/resources目录,may be 是mybatis-generator的一个bug

mvn mybatis-generator:generate

## 新增功能
20170420 ：新增自动生成接口用例集合报告功能
