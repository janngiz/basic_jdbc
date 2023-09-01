package com.anurag.jdbc;

import com.anurag.jdbc.test.Alien;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AlienTest {

    private static final String NAME = "John Smith";

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("scopes.xml");

        Alien personSingletonA = (Alien) applicationContext.getBean("alienSingleton");
        Alien personSingletonB = (Alien) applicationContext.getBean("alienSingleton");

        personSingletonA.setName(NAME);
        assertEquals(NAME, personSingletonB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }
}
