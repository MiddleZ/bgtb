package com.bgtb01.bgtb.controller;

import com.bgtb01.bgtb.common.vo.Result;
import com.bgtb01.bgtb.entity.Provinces;
import com.bgtb01.bgtb.entity.Universities;
import com.bgtb01.bgtb.service.IProvincesService;
import com.bgtb01.bgtb.service.IUniversitiesService;
import com.bgtb01.bgtb.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class SelecterController {

    @Autowired
    private IProvincesService provincesService;
    @Autowired
    private IUniversitiesService universitiesService;

    @GetMapping("/selecter/provinces")
    public Result<List<Provinces>> getProvinces() {
        List<Provinces> data = provincesService.getProvinces();
        return Result.success(data);
    }

    @GetMapping("/selecter/provinces/{provinceId}/university")
    public Result<List<Universities>> getUniversities(@PathVariable String provinceId){
        List<Universities> data = universitiesService.getSchoolByProvince(provinceId);
        return Result.success(data);
    }
}
