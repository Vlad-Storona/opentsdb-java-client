package com.opentsdb.client;

import com.opentsdb.client.dto.MetricDto;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Slf4j
public class OpenTsdbTest {

    private static final String URI_OPENTSDB = "http://localhost:8080";

    private static OpenTsdb openTsdb;

    @BeforeClass
    public static void setup() {
        openTsdb = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(OpenTsdb.class, URI_OPENTSDB);
    }

    @Test
    public void testGetMetric() {
        List<MetricDto> metrics
                = openTsdb.getMetrics("5y-ago", "sum:warp.speed");
        assertEquals(1, metrics.size());
        metrics.forEach(System.out::println);
    }

    @Test
    public void testGetStaticFile() {
        String content = openTsdb.getStaticFile("queryui.nocache.js");
        log.debug(content);
    }


}
