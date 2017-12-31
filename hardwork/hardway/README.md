## 面向对象基本概念
1. 对象，对象是一个状态和行为的`software bundle`。
2. 类，类是创建对象的蓝图或者原型。
3. 继承，集成提供了一种强大而自然的方式来组织和结构化你的软件。
4. 接口，接口是类和外界间的`contract`。
5. 包，包是用逻辑方式组织类和接口的一个命名空间。


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