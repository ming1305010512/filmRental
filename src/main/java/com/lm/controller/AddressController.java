package com.lm.controller;

import com.lm.po.Address;
import com.lm.po.JsonMessage;
import com.lm.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/28.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    //获取地址信息
    @RequestMapping(value = "/getAddress")
    @ResponseBody
    public JsonMessage getAddress(){

        List<Address> addressList=addressService.queryAllAddress();

        return JsonMessage.success().add("addressList",addressList);
    }
}
