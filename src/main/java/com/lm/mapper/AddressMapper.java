package com.lm.mapper;

import com.lm.po.Address;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/27.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public interface AddressMapper {

    //查询所有地址信息
    public List<Address> queryAddress();
}
