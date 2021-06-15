package com.togo;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;
import org.omg.CORBA.Current;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author taiyanan
 */
public class test {

    public test(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        System.out.println(foo.get(e -> 2));
        System.out.println(foo.get(e -> 2));
        System.out.println(foo.get(e -> 2));
    }

    public static class Foo{
        private List<Integer> elements = Lists.newArrayList(1, 2, 3);
        public Integer get(Function<Integer, Integer> by) {
            return elements.stream().map(by).reduce(Integer::sum).get();
        }
    }

    private long id;
    private String name;
    private String desc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
