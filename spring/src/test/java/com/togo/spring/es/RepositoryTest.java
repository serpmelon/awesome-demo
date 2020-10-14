package com.togo.spring.es;

import com.togo.spring.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RepositoryTest {

    @Autowired
    private Repository repository;

    @Test
    public void test() {

        repository.findAll();
    }
}