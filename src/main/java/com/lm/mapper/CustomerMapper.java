package com.lm.mapper;

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
public interface CustomerMapper {

    //根据firstName查询用户数
    public int queryCustomerCountByFirstName(String firstName);

    //查询用户所有信息
    public List<CustomerWithAddress> queryAllCustomer();

    //新增用户信息
    public void addCustomer(CustomerWithAddress customerWithAddress);

    //查询用户信息
    public CustomerWithAddress queryCustomerById(Short customerId);

    //更新用户
    public void updateCustomer(CustomerWithAddress customerWithAddress);

    //删除用户
    public void deleteCustomerById(Short customerId);

    //删除与用户关联的rental
    public void deleteRentalByCustomerId(Short customerId);

    //删除与用户关联的payment
    public void deletePaymentByCustomerId(Short customerId);
}
