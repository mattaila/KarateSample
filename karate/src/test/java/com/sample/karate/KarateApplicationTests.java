package com.sample.karate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
  properties = {
    "server.port=8080"
  })
class KarateApplicationTests {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:com/sample/karate").parallel(1);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
