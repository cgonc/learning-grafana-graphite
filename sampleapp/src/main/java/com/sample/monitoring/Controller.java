package com.sample.monitoring;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private MeterRegistry meterRegistry;

    @RequestMapping(value = "/greetings", method = {RequestMethod.GET})
    @Timed
    public String placeBid() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
        return "Hello";
    }

    @RequestMapping(value = "/custommetrics", method = {RequestMethod.GET})
    public String sendCustomMetrics() {
        Counter counter = meterRegistry.counter("custom.counter");
        counter.increment();
        return "OK";
    }

}
