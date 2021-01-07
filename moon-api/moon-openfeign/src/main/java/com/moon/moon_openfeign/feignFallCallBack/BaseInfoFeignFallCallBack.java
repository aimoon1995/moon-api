package com.moon.moon_openfeign.feignFallCallBack;

import com.moon.moon_openfeign.feign.BaseInfoFeign;

/**
 * @ClassName BaseInfoFeignFallCallBack
 * @Description: TODO
 * @Author zyl
 * @Date 2021/1/5
 * @Version V1.0
 **/
public class BaseInfoFeignFallCallBack implements BaseInfoFeign {
    @Override
    public String baseInfoCompany() {
        return new String("404  error");
    }

    @Override
    public String baseInfoCompanyStat(Object baseInfoCompanyStat) {
        return new String("404  error");
    }

    @Override
    public String baseInfoCompanyPay(Object baseInfoCompanyPay) {
        return new String("404  error");
    }

    @Override
    public String baseInfoCompanyService(Object baseInfoCompanyService) {
        return new String("404  error");
    }

    @Override
    public String baseInfoCompanyPermit(Object baseInfoCompanyPermit) {
        return new String("404  error");
    }

    @Override
    public String baseInfoCompanyFare(Object baseInfoCompanyFare) {
        return new String("404  error");
    }

    @Override
    public String baseInfoVehicle(Object baseInfoVehicle) {
        return new String("404  error");
    }

    @Override
    public String baseInfoVehicleInsurance(Object baseInfoVehicleInsurance) {
        return new String("404  error");
    }

    @Override
    public String baseInfoVehicleTotalMile(Object baseInfoVehicleTotalMile) {
        return new String("404  error");
    }

    @Override
    public String baseInfoDriver(Object baseInfoDriver) {
        return new String("404  error");
    }

    @Override
    public String baseInfoDriverEducate(Object baseInfoDriverEducate) {
        return new String("404  error");
    }

    @Override
    public String baseInfoDriverApp(Object baseInfoDriverApp) {
        return new String("404  error");
    }

    @Override
    public String baseInfoDriverStat(Object baseInfoDriverStat) {
        return new String("404  error");
    }

    @Override
    public String baseInfoPassenger(Object baseInfoPassenger) {
        return new String("404  error");
    }
}
