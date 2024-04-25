package org.example.jdbc.tests;

import org.example.jdbc.db.AirplaneQuery;
import org.example.jdbc.dto.AirplaneDto;
import org.testng.annotations.Test;

public class JDBCTest {

    @Test
    public void checkGetTestDataInDB() {
        AirplaneDto airplaneById = new AirplaneQuery().getAirplaneById(1L);
        System.out.println(airplaneById);
    }
}
