package com.moon.moon_openfeign.config;


import com.alibaba.fastjson.JSONObject;
import feign.Contract;
import feign.Logger;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class FeignConfig {

    @Bean
    public Contract contract() {
        return new feign.Contract.Default();
    }

    /**
     * Logger.Level的具体级别如下：
     * NONE：不记录任何信息
     * BASIC：仅记录请求方法、URL以及响应状态码和执行时间
     * HEADERS：除了BASIC级别的信息以外，还会记录请求和响应头信息
     * FULL：记录所有的请求与响应的明细，包括头信息，请求体，元数据
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.NONE;
    }


    /**
     * 重新构造Feign的参数，如下：
     * {
     * "CompanyId":"test11111",
     * "Source":"1",
     * "IPCType":"baseInfoCompanyStat",
     * "baseInfoCompanyStat":[{
     * "VehicleNum":"1000",
     * "DriverNum":"1000",
     * "Flag":"1",
     * "UpdateTime":"20190701112723",
     * "CompanyId":"3401HXYC308F"
     * }]
     * }
     *
     * @return
     */
    @Bean
    public Encoder feignEncoder() {
        return new ParameterEncoder();
    }


    /**
     * 重构请求参数为json,符合监管平台数据
     */
    private class ParameterEncoder implements Encoder {


        @Override
        public void encode(Object o, Type type, RequestTemplate rt) throws EncodeException {

            String className = firstLowerCase(o.getClass().getSimpleName());
            System.err.println(className);
            Map<String, Object> map = new HashMap();
//            map.put(appConfig.getCompanyIdKey(), appConfig.getCompanyIdValue());
//            map.put(appConfig.getSourceKey(), appConfig.getSourceValue());
//            map.put(appConfig.getIPCTypeKey(), className);
            map.put(className, o);
            String param = JSONObject.toJSONString(map);
            rt.body(param);
        }

        /**
         * 将类名首字母转成小写
         *
         * @param className 类名
         * @return 小写类名
         */
        private String firstLowerCase(String className) {
            String big = className.substring(0, 1);// 获取首字母（类名首字母大写）
            String small = big.toLowerCase();// 将首字母变为小写
            String smallName = small + className.substring(1);// 获得已小写字母开头的类名
            return smallName;
        }

    }


}
