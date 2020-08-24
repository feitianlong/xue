package typeinfo14;

import java.lang.reflect.*;
import java.util.regex.*;

public class ShowMethods {
  private static String usage =
    "usage:\n" +
    "ShowMethods qualified.class.name\n" +
    "To show all methods in class or:\n" +
    "ShowMethods qualified.class.name word\n" +
    "To search for methods involving 'word'";
  // 使用regex去掉命名修饰符
  private static Pattern p = Pattern.compile("\\w+\\.");
  public static void main(String[] args) {
    if(args.length < 1) {
      System.out.println(usage);
      System.exit(0);
    }
    int lines = 0;
    try {
    	// 这里需要注意的是，Class.forName()加载的类参数需要写完整路径(包含所在的包名)
      Class<?> c = Class.forName(args[0]);
      // getMethods()和getConstructors()方法分别返回Method对象的数组和Constructor对象的数组
      Method[] methods = c.getMethods();
      Constructor[] ctors = c.getConstructors();
      if(args.length == 1) {
        for(Method method : methods)
          System.out.println(
            p.matcher(
              method.toString()).replaceAll(""));
        for(Constructor ctor : ctors)
          System.out.println(
            p.matcher(ctor.toString()).replaceAll(""));
        lines = methods.length + ctors.length;
      } else {
        for(Method method : methods)
          if(method.toString().contains(args[1])) {
            System.out.println(p.matcher(
              method.toString()).replaceAll(""));
            lines++;
          }
        for(Constructor ctor : ctors)
          if(ctor.toString().contains(args[1])) {
            System.out.println(p.matcher(
              ctor.toString()).replaceAll(""));
            lines++;
          }
      }
    } catch(ClassNotFoundException e) {
      System.out.println("No such class: " + e);
    }
  }
}
