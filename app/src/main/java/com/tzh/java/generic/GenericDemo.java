package com.tzh.java.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * create by tuzanhua on 2020/4/14
 * <p>
 * 学习参考: 最好两个视频都2.0倍速看下
 * 请参考B 站:
 * https://b23.tv/BV1YE411e75r
 * https://b23.tv/BV1xJ411n77R/p13
 * <p>
 * 泛型实在java1.5 之后出现的新特性,它的思想来源于 数组,出现的原因 比如 ArrayList list = new ArrayList();
 * list.add("1");
 * list.add(2);
 * 当从集合里面取值的时候 Object obj = list.get(0);
 * 我们只能以object 接收如果强制转 那么非常有可能会造成类型转换异常
 * <p>
 * 这样泛型使用会告诉 编辑器 所对应的类型 等于将运行期异常提到了编译期
 * <p>
 * 泛型的知识点: 用法 泛型类,泛型接口,泛型方法 ☆☆☆☆☆
 * 泛型 通配符的使用 ? , ? extends  , ? super
 * 泛型擦除了解吗? 如何验证 ? 泛型擦除带来的问题 ? 如何解决泛型擦除带来的问题 ?
 */
public class GenericDemo {

    public static void main(String[] args) {
        // Test 泛型类
        GenericDemo1<String> stringGenericDemo1 = new GenericDemo1<>();
        stringGenericDemo1.setT("hello world");
        System.out.println(stringGenericDemo1.getT());

        GenericWipeDemo genericWipeDemo = new GenericWipeDemo();
        genericWipeDemo.test();

        Object name = getName();
    }

    public static <M> M getName(){
        return (M) new Object();
    }


    /**
     * 泛型类的demo
     *
     * @param <T>
     */
    static class GenericDemo1<T> {
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    /**
     * 泛型接口
     *
     * @param <T>
     */
    interface IGeneric<T> {
        void show(T t);
    }

    /**
     * 如果泛型接口没有定义 泛型的值 那么交给 实现类去定义
     *
     * @param <T>
     */
    class GenericImpl<T> implements IGeneric<T> {
        @Override
        public void show(T t) {

        }
    }

    /**
     * 如果泛型接口定义了泛型值那么不用实现类去定义了
     */
    class GenericImpl2 implements IGeneric<String> {
        @Override
        public void show(String s) {

        }
    }

    /**
     * 泛型方法的展示
     */
    class GenericFunc {
        public <T> void show(T t) {
            System.out.println(t);
        }
    }

    // ☆☆☆☆☆  以下重点 通配符

    /**
     * 首先这里明确 泛型通配符的使用场景 是作为 参数的传递使用的   是作为 参数的传递使用的 是作为 参数的传递使用的
     * <p>
     * 那么为什么是这样的呢?
     * 因为集合的不可协变性   协变 不可协变是针对 List<Integer> 和 list<Number>  这样有继承关系的 集合整体来说的
     * 数组是可协变的    Integer[]  和 Number[] 是可以转换的
     */


    class GenericWildcardDemo {

        public void Test() {
            //===============>>> start
            Number[] numberArrs = new Number[100];
            Integer[] integerArrs = new Integer[100];

            arrDemo(numberArrs);
            arrDemo(integerArrs);
            // 看见了吗 ? 可以传递我们理解的子类型
            //=============<<< end

            ArrayList<Object> objects = new ArrayList<>();
            ArrayList<Number> numbers = new ArrayList<>();
            ArrayList<Integer> integers = new ArrayList<>();

            product(numbers);
            //================================>>> start
            // product(integers); // 编译器在这里就会报出错误 List<Integer> can not apply List<Number>
            //  看见了吗这里就 证明了不可协变 JVM 认为 List<Integer> 和 List<Number> 是不同的两种类型 把它们各自看成一个整体来理解

            //=======================<<< end

            //=========>>> start
            //那么如何解决这里问题呢?  通过泛型的通配符来解决
            //========>>>
            product1(numbers);
            product1(integers);
            // 这里虽然解决了编译的问题 但是却没有什么实质性的意义 因为 list<?> 这个类型是无法添加任何数据的, 因为JVM 它根本不知道你到底会添加一个怎么样的子类型
            //====<<<< end

            //========== >>> start
            //那么 当 ? 通配符 没有什么实质性的意义之后 来看 <? extends Number>
            product2(numbers);
            product2(integers);
            //product2(objects); // 这里会编译局会提示错误 因为我们使用的是 extends 上限通配符限定了 传递的类型
            // 这里一定要看下 product2() 方法内部的说明
            //===========<<<end

            //============>>> start
            consumer(objects);
            consumer(numbers);
//            consumer(integers);

            //============<<< end
        }

        public void arrDemo(Number[] numbers) {

        }


        public void product(List<Number> datas) {
            for (Number number : datas) {
                System.out.println(number);
            }
        }

        public void product1(List<?> datas) {
            for (Object obj : datas) {
                System.out.println(obj.toString());
            }
        }

        public void product2(List<? extends Number> datas) {
            // 在这如果想要往 实参内add 任何数据都是不可以的 因为 jvm 并不知道 你传递过来的 到底是那种类型  List<Number> List<Integer>
            // 这里其实很好理解 如果参数是 List<Zi> 那么再往里边add(new Fu()); 肯定是不行的
            //但是可以取出值 并且认为都是 Number 对象
            // 这里涉及 PECS 法则 即 从参数内 取出数据用 extends  存储数据用 super
//             datas.add(1);
//             datas.add(new Number() {
//                 @Override
//                 public int intValue() {
//                     return 0;
//                 }
//
//                 @Override
//                 public long longValue() {
//                     return 0;
//                 }
//
//                 @Override
//                 public float floatValue() {
//                     return 0;
//                 }
//
//                 @Override
//                 public double doubleValue() {
//                     return 0;
//                 }
//             });

            for (Number number : datas) {
                System.out.println(number + "");
            }
        }


        /**
         * 下限通配符
         *
         * @param datas
         */
        public void consumer(List<? super Number> datas) {
            // 因为 参数是下限通配符限定限定,那么想下 如果往参数里面存值  的限定是什么 看下面传递值理解下
            datas.add(1);
            Number number = new Number() {

                @Override
                public int intValue() {
                    return 1;
                }

                @Override
                public long longValue() {
                    return 1l;
                }

                @Override
                public float floatValue() {
                    return 1.f;
                }

                @Override
                public double doubleValue() {
                    return 1.0d;
                }
            };
            datas.add(number);
//            datas.add(new Object()); // 不可以 添加  要结合传递进来参数进行理解 想下虽然是下限 我们可以传递进来 List<Object>
//            但是 jvm 并不知道外面传递来的到底是什么值, 但是它可以通过限定 你可以传递已经声明的子类型的值可以添加

            // 这里只能取出object
            for (Object object : datas) {
                Object object1 = datas.get(0);
            }
        }

    }

    // ☆☆☆☆☆  以下重点  泛型擦除

    static class GenericWipeDemo {

        public void test() {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("nihaoma");
            ArrayList<Integer> integers = new ArrayList<>();

            //=======>>> start 证明泛型擦除
            // 如果字节码类相同那么说明是同一个类型  如果是同一个类型那么证明了泛型擦除
            System.out.println(strings.getClass() == integers.getClass()); // 输出结果为 true
            //===========<<< end

            //=========>>> start 泛型擦除带来的问题   通过反射我们可以将 不是同一种类型的数据添加到集合里面

            Class<? extends ArrayList> aClass1 = strings.getClass();
            Method add = null;
            try {
                add = aClass1.getMethod("add", Object.class);
                add.invoke(strings, 123);
                System.out.println(strings);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


            //=========<<< end

            // =========>>start 解决泛型擦除方法
            Person<Number> person = new Person<>();
            Class<? extends Person> aClass = person.getClass();

            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println(method.getName() + " " + method.getReturnType().getSimpleName()); //get Number
            }

        }

        //=============<<< end


        /**
         * 解决泛型擦除问题的方法 T extends Number
         *
         * @param <T>
         */
        static class Person<T extends Number> {

            public T get(T t) {
                return t;
            }
        }
    }

}
