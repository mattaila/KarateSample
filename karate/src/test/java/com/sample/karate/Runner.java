package com.sample.karate;

import com.intuit.karate.junit5.Karate;

public class Runner {

    @Karate.Test
    Karate test() {
        return Karate.run("api").relativeTo(getClass());
    }    
}
