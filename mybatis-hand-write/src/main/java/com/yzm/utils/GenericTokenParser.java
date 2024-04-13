package com.yzm.utils;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  17:37
 */
public class GenericTokenParser {

    private ParameterMappingTokenHandler parameterMappingTokenHandler;

    public GenericTokenParser(String str1, String str2, ParameterMappingTokenHandler parameterMappingTokenHandler){
        this.parameterMappingTokenHandler = parameterMappingTokenHandler;
    }


    public String parse(String sql){
        return null;
    }
}
