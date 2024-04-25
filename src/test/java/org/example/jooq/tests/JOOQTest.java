package org.example.jooq.tests;

import org.example.jooq.db.AirplaneQuery;
import org.example.jooq.db.DefaultQuery;
import org.example.jooq.dto.AirplaneDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JOOQTest {

    @Test
    public void checkGetTestDataInDB() {
        AirplaneDto airplane = new AirplaneQuery().getAirplaneById(1L);
        Assert.assertNotNull(airplane);
    }
}
