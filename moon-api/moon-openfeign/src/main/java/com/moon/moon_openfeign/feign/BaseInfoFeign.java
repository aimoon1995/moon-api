package com.moon.moon_openfeign.feign;

import com.moon.moon_openfeign.config.FeignConfig;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "baseInfoFeign", url = "${url.hxyc.api}", configuration = FeignConfig.class)
public interface BaseInfoFeign {

    /** 用于网约车平台公司向部级平台发起请求，更新网约车平台公司信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/company")
    String baseInfoCompany( );


    /**用于网约车平台公司向部级平台发起请求，更新网约车平台公司营运规模信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/companystat")
    String baseInfoCompanyStat(Object baseInfoCompanyStat);


    /**用于网约车平台公司向部级平台发起请求，更新网约车平台公司支付信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/companypay")
    String baseInfoCompanyPay(Object baseInfoCompanyPay);

    /**用于网约车平台公司向部级平台发起请求，更新网约车平台公司服务机构信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/companyservice")
    String baseInfoCompanyService(Object baseInfoCompanyService);

    /**用于网约车平台公司向部级平台发起请求，更新网约车平台公司经营许可信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/companypermit")
    String baseInfoCompanyPermit(Object baseInfoCompanyPermit);


    /**用于网约车平台公司向部级平台发起请求，更新网约车平台公司运价信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/companyfare")
    String baseInfoCompanyFare(Object baseInfoCompanyFare);


    /**用于网约车平台公司向部级平台发起请求，更新车辆基本信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/vehicle")
    String baseInfoVehicle(Object baseInfoVehicle);


    /** 用于网约车平台公司向部级平台发起请求，更新车辆保险信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/vehicleinsurance")
    String baseInfoVehicleInsurance(Object baseInfoVehicleInsurance);

    /**用于网约车平台公司向部级平台发起请求，更新网约车车辆里程信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/vehicletotalmile")
    String baseInfoVehicleTotalMile(Object baseInfoVehicleTotalMile);


    /**用于网约车平台公司向部级平台发起请求，更新驾驶员基本信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/driver")
    String baseInfoDriver(Object baseInfoDriver);


    /**用于网约车平台公司向部级平台发起请求，更新网约车驾驶员培训信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/drivereducate")
    String baseInfoDriverEducate(Object baseInfoDriverEducate);


    /**用于网约车平台公司向部级平台发起请求，更新驾驶员移动终端信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/driverapp")
    String baseInfoDriverApp(Object baseInfoDriverApp);


    /**用于网约车平台公司向部级平台发起请求，更新驾驶员统计信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/driverstat")
    String baseInfoDriverStat(Object baseInfoDriverStat);


    /**用于网约车平台公司向部级平台发起请求，更新乘客基本信息。
     * @return
     */
    @Headers({"Content-Type: application/json","Accept-Encoding: gzip","Connection: keep-alive","Accept-Charset: utf-8"})
    @RequestLine("POST /baseinfo/passenger")
    String baseInfoPassenger(Object baseInfoPassenger);
}
