package com.opentsdb.client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class MetricDto {

    public String metric;
    public Map<String, String> tags;
    public List<String> aggregateTags;
    public Map<String, String> dps;

}
