package com.orchid0809;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by orchid0809 on 2018/2/28.
 */
public class Student {

    int no;
    String name;
    String sex;
    float height;

    public Student(int no, String name, String sex, float height) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }

    public static void main(String[] args){
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        Stream<Student> stream = list.stream();
        stream.filter((Student stu) -> stu.sex.equals("M")).forEach(
                (Student stu) -> System.out.println(stu.name)
        );

        /*Iterator<Student> itea = list.iterator();
        while(itea.hasNext()){
            Student stu = itea.next();
            if(stu.sex.equals("G")){
                System.out.println(stu.name);
            }
        }*/
    }
}
