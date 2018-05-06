# Java-Study
`jskzyero` `2017/12/31`

## Overview
+ Java是由Sun Microsystems公司于1995年5月推出的Java面向对象程序设计语言和Java平台的总称。
    + JDK（Java Development Kit）：针对Java开发人员的软件开发包（SDK，Software delelopment kit），包括（javac、java、jar、javadoc）。
    + JRE（Java Runtime Environment）：普通用户安装的版本，记得我们要装的是JDK。
    + Apache Ant：A Java library and command-line tool use to build Java application
    + 在学习的一开始推荐暂时不考虑使用IDE，因而上述基础环境是需要自己配置的，即便是Windows也只需要添加好Path就可以愉快开坑。
+ ...

## Structure
```
.
├── docs                // documents
├── hardwork
│   ├── ant             // use ant to build code
│   ├── hardway         // practice code
│   ├── helloworld      // fisrt code to java
│   ├── junit           // junit unit test
│   ├── swing           // swing gui
│   └── tips            // some useful tips
├── projects
│   ├── gridworld       // A grid world let you play with
│   └── todolist        // A simple todolist
└── README.md
```

## Naming Style

+ Common rules : only ASCII letters and digits, can matched by the regular expression `\w+ `. special prefixes or suffixes, like those seen in the examples `name_`, `mName`, `s_name` and `kName`, are **not** used.


+ Package names : `com.example.deepspace`, not `com.example.deepSpace` or `com.example.deep_space`.
+ Class names : UpperCamelCase. `Character` or `ImmutableList`.
+ Constant names :  `CONSTANT_CASE`
+ Method names, Non-constant field names, Parameter names, Local variable names : lowerCamelCase.
+ Type variable names : A single capital letter, optionally followed by a single numeral (such as `E`, `T`, `X`, `T2`, examples: `RequestT`, `FooBarT`)

## Reference

+ [Java Tutorials Learning Paths](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)

+ [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html#s5-naming)
