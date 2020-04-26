package com.javase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        // 以a开头的元素有多少个
        System.out.println(stringList.size());
        System.out.println(stringList.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("a");
            }
        }).count());

        System.out.println(stringList.stream().filter((s) -> {
            return s.startsWith("a");
        }).collect(Collectors.toList()));
        System.out.println(stringList.stream().count());
        // 类名.方法名 Arrays、Stream
        // 对象.方法名 集合对象/数组对象

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("zhangsan", 20, "男"));
        personList.add(new Person("lisi", 10, "男"));
        personList.add(new Person("wangwu", 30, "男"));
        personList.add(new Person("zhaoliu", 40, "女"));

        /*Map<Boolean, List<Person>> map = personList.stream().collect(Collectors.partitioningBy((p) -> {
            return "男".equals(p.getSex()) ? true : false;
        }));
        map.forEach((flag, pList) -> {
            System.out.println(flag + "->" + pList);
        });*/

        /*System.out.println(personList.stream().map(new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        }).collect(Collectors.toList()));
        
        System.out.println(personList.stream().map((person) -> {
            return person.getName();
        }).collect(Collectors.toList()));
        
        System.out.println(personList.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList()));*/
        System.out.println("---------------");
        if (personList != null && personList.size() > 0) {
            personList.stream().collect(Collectors.partitioningBy((p) -> {
                return "男".equals(p.getSex());
            })).forEach((flag, pList) -> {
                System.out.println(flag + "->old" + pList);
                List<Person> newPersonList = pList.stream().sorted((p1, p2) -> {
                    return p1.getAge().compareTo(p2.getAge());
                }).collect(Collectors.toList());
                System.out.println(flag + "->new" + newPersonList);
            });
        }
    }
}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
    private String sex;
}
@ToString
class Student {
    private String name;
    private Integer age;
    private String sex;
    public Student setName(String name) {
        this.name = name;
        return this;
    }
    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }
    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("abc").setAge(18).setSex("男");
        System.out.println(student);
    }
}