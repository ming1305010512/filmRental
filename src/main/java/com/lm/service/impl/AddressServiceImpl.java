package com.lm.service.impl;

import com.lm.mapper.AddressMapper;
import com.lm.po.Address;
import com.lm.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/27.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    //获取所有地址信息
    public List<Address> queryAllAddress() {

        List<Address> addressList=addressMapper.queryAddress();
        return addressList;
    }
}
