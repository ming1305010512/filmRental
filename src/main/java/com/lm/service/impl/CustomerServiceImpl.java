package com.lm.service.impl;

import com.lm.mapper.CustomerMapper;
import com.lm.po.Customer;
import com.lm.po.CustomerWithAddress;
import com.lm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/26.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public boolean isCustomerExist(String firstName) {

        boolean flag=false;
        int count =customerMapper.queryCustomerCountByFirstName(firstName);
        if(count>0){
            flag=true;
        }

        return flag;
    }

    public List<CustomerWithAddress> getAllCustomer() {
        List<CustomerWithAddress> list=customerMapper.queryAllCustomer();
        return list;
    }

    public void addCustomer(CustomerWithAddress customerWithAddress) {

        customerMapper.addCustomer(customerWithAddress);
    }

    @Override
    public CustomerWithAddress getCustomerById(Short customerId) {

        CustomerWithAddress customerWithAddress=customerMapper.queryCustomerById(customerId);
        return customerWithAddress;
    }

    //更新用户信息
    @Override
    public boolean updateCustomer(CustomerWithAddress customerWithAddress) {

        boolean flag=false;
        //设置最后更新时间
        customerWithAddress.setLastUpdate(new Date());
        try {
            customerMapper.updateCustomer(customerWithAddress);
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteCustomer(Short customerId) {

        boolean flag=false;
        try {
            //先删除从表
            customerMapper.deleteRentalByCustomerId(customerId);
            customerMapper.deletePaymentByCustomerId(customerId);
            customerMapper.deleteCustomerById(customerId);
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

}
