package com.uzi.ioSample.mk;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 单例 ObjectMapper
 */
public class GetObjectMapper extends ObjectMapper {

    private GetObjectMapper(){}

    private static GetObjectMapper singleton= new GetObjectMapper();

    public static GetObjectMapper getObjectMapper() {
        return singleton;
    }
}