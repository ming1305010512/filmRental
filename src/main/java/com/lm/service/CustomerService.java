package com.lm.service;

import com.lm.po.Customer;
import com.lm.po.CustomerWithAddress;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/26.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public interface CustomerService {

    //判断用户名是否存在
    public boolean isCustomerExist(String firstName);

    //获得所有的用户信息
    public List<CustomerWithAddress> getAllCustomer();

    //新增用户信息
    public void addCustomer(CustomerWithAddress customerWithAddress);

    //根据customerId获取用户信息
    public CustomerWithAddress getCustomerById(Short customerId);

    //更新用户信息
    public boolean updateCustomer(CustomerWithAddress customerWithAddress);

    //删除用户信息
    public boolean deleteCustomer(Short customerId);
}
