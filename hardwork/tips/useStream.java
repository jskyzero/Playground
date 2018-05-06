import java.util.Arrays; // for Arrays
import java.util.Random;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * useStream
 * 
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算
 * 和表达的高阶抽象。
 * 
 */

// +--------------------+       +------+   +------+   +---+   +-------+
// | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
// +--------------------+       +------+   +------+   +---+   +-------+

// 生成流 
// 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
// 
// stream() − 为集合创建串行流。
// stream() − 为集合创建串行流。


// 聚合操作
// 
// forEach 迭代流中的每个数据
// map 映射每个元素到对应的结果
// filter 通过设置的条件过滤出元素
// limit 获取指定数量的流
// sorted 对流进行排序

// Collectors
// 
// Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。


public class useStream {
  public static void main(String [] args) {
    (new Random()).ints()
                  .limit(100)
                  .filter(x -> x > 0 && x % 2 == 0)
                  .map(x -> x % 10)
                  .mapToObj(Integer::new).collect(Collectors.toList())
                  .parallelStream()
                  .sorted()
                  .forEach(x -> System.out.println((int)x));
  }
}