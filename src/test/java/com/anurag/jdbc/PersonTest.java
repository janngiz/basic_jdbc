package com.anurag.jdbc;

import com.anurag.jdbc.test.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonTest {

    private static final String NAME = "John Smith";

    @Autowired
    private Person personSingletonA;

    @Autowired
    private Person personSingletonB;

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        personSingletonA.setName(NAME);
        Assert.assertEquals(NAME, personSingletonA.getName());
        Assert.assertEquals(NAME, personSingletonB.getName());
    }
}
