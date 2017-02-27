package com.opentsdb.client;

import com.opentsdb.client.dto.MetricDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers("Accept: application/json")
public interface OpenTsdb {

    @RequestLine("GET /api/query/?start={start_time}&m={aggregator}")
    List<MetricDto> getMetrics(
            @Param("start_time") String startTime,
            @Param("aggregator") String aggregator);

    @RequestLine("GET /s/{file_name}")
    String getStaticFile(@Param("file_name") String fileName);
}
