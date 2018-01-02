BaseAndroid项目文档
---------------
- [项目配置](#项目配置)
- [组件]
    - [注册／登陆 --login]
- [注意]
    - [模块独立运行]
    - [多个application合并]
    - [AMS区分组件独立运行和非独立运行]
    - [Router]


### 项目配置
 * JDK版本：1.7
 * SDK适配版本：19 - 27
 * AS版本：3.0
 * gradle版本：4.1


### 模块
#### 注册／登陆 --login


### 注意
提供一张简易结构图
![](png/component.png)

#### 组件独立运行
在每个组件内的build.gradle里面添加
```
if (isModule.toBoolean()){
    apply plugin: 'com.android.application'
}else {
    apply plugin: 'com.android.library'
}
```
用gradle.properties 下面的isModule = false／true 控制是否开启组件是否独立运行


#### 多个application合并
在每个组件的包下建立一个debug包，在debug里面建立组件独立运行时所需要的application