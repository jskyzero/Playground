# Java-Study
> Java是由Sun Microsystems公司于1995年5月推出的Java面向对象程序设计语言和Java平台的总称。

## 配置环境
首先先了解一些基础的安装软件。
> JDK（Java Development Kit）：针对Java开发人员的软件开发包（SDK，Software delelopment kit），包括（javac、java、jar、javadoc）。
> JRE（Java Runtime Environment）：普通用户安装的版本，记得我们要装的是JDK。
> Apache Ant：A Java library and command-line tool use to build Java application

在学习的一开始暂时不考虑使用IDE，因而上述基础环境是需要自己配置的，即便是Windows也只需要添加好Path就可以愉快开坑。

## HelloWold
新建一个文件`HelloWorld.java`，键入如下代码：
```Java
public class HelloWorld 
{
    /* HelloWorld.java */
    public static void main(String []args)
    {
        System.out.println("HelloWorld");
    }
}
```
Java是一门编译型语言，这意味者我们需要先编译，然后才能运行，导航到上述代码的根目录使用命令`javac HelloWorld`编译，然后键入`java HelloWorld`运行。

JDK中有很多其他指令，如`java javac jar native2ascii`等等，具体的学习可以等到用的上的时候在开始查参考。

## 面向对象基本概念
1. 对象，对象是一个状态和行为的`software bundle`。
2. 类，类是创建对象的蓝图或者原型。
3. 继承，集成提供了一种强大而自然的方式来组织和结构化你的软件。
4. 接口，接口是类和外界间的`contract`。
5. 包，包是用逻辑方式组织类和接口的一个命名空间。

## hardwork

### 语言基础
1. 变量分类，实例/类变量（非静态/静态），本地变量，参数
2. 变量命名，避免以`_`和`$`开头，不要使用缩写，多个单词第一个小写其余大写开头，常量全大写用下划线连接。E.G.`static final int NUM_GEARS = 6`
3. 主要数据类型，默认值，赋值方法，请参考[这个](http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
4. 数组，初始化，拷贝`System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`，`java.util.Array`中有更多对数组的操作。
5. 操作符。
6. 控制流`if else`, `switch`, `while`, `for`, `break`, `continue`, `return`

### 类和对象
1. 类，声明属性/方法
2. 对象，使用类创造对象
3. 嵌套类，匿名类（声明即使用）
4. Lambda表达式
5. 枚举类型

### 注解
1. 格式，`@SuppressWarnings(value = "unchecked")`
2. 何时应该使用，在声明类，域，方法和其他程序元素的时候
3. 其余部分请参考[源介绍](http://docs.oracle.com/javase/tutorial/java/annotations/declaring.html)

