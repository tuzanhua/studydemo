**为什么使用增强for遍历删除元素会抛出concurrentModifyException**
  for(String str:Strs){
     strs.remove(str);
  }
    //因为混合使用了 增强for 和普通for 所以会抛出 异常 
    
    iterator 内部有一个 exceptModicount  list 内部有一个 modcount 这两个值不一样的时候就会抛出异常
  
  
 Iterator<String> iterator = strings.iterator();
 while (iterator.hasNext()){
     String element = iterator.next();
     if("e".equals(element)){
         iterator.remove();
     }
 }

  


**锁相关**
[美团技术文章总体说明](https://tech.meituan.com/2018/11/15/java-lock.html)