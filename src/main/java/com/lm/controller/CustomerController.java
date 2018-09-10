package com.lm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.po.Address;
import com.lm.po.Customer;
import com.lm.po.CustomerWithAddress;
import com.lm.po.JsonMessage;
import com.lm.service.AddressService;
import com.lm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/26.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    //动态跳转页面
    @RequestMapping(value = "/{forName}")
    public String skipPage(@PathVariable String forName ,Model model){

        if("customerShow".equals(forName)){
            //如果是新增页面，传入一个标志，用于用户列表显示最后一列
            model.addAttribute("addPageTab","addPageTab");
        }
        return "content/"+forName;
    }

    @RequestMapping(value = "/login")
    public String login(String firstName, Model model, HttpSession session) {

        boolean flag=customerService.isCustomerExist(firstName);
        if(flag) {
            session.setAttribute("first_name",firstName);
            return "content/customerShow";
        }else {
            model.addAttribute("message","用户名不存在");
            return "forward:/index.jsp";
        }
    }

    //退出登录
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){

        session.invalidate();
        return "redirect:/index.jsp";
    }

    //用户当前页信息
    @ResponseBody
    @RequestMapping(value = "/getCustomer")
    public JsonMessage getUser(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        //在查询之前调用它，查询就会变为分页查询
        //参数一：页数
        //参数二：一页的记录数
        PageHelper.startPage(pn,8);
        List<CustomerWithAddress> list=customerService.getAllCustomer();
        //封装了详细的分页信息
        //参数一：记录  参数二：连续显示的页数
        PageInfo pageInfo=new PageInfo(list,5);

        model.addAttribute("pageInfo",pageInfo);
        return JsonMessage.success().add("pageInfo",pageInfo);
//        return pageInfo;
//        return "forward:index.jsp";
    }

    //新增用户
    @RequestMapping(value = "/addCustomer")
    public String addCustomer(Model model){

        List<Address> addressList=addressService.queryAllAddress();
        model.addAttribute("addressList",addressList);
        return "content/addCustomer";
    }

    //校验用户是否存在
    @RequestMapping(value = "/isCustomerExist")
    @ResponseBody
    public JsonMessage isCustomerExist(String firstName){

        boolean flag=customerService.isCustomerExist(firstName);
        //如果不存在，用户可用
        if (!flag) {
            return JsonMessage.success();
        }else {
            return JsonMessage.fail();
        }
    }

    //新增用户提交
    @RequestMapping(value = "/addCustomerSubmit")
    @ResponseBody
    public JsonMessage addCustomerSubmit(@Validated CustomerWithAddress customerWithAddress ,BindingResult result){

        //获取校验错误信息
        if(result.hasErrors()){

            List<FieldError> fieldErrors=result.getFieldErrors();

            return JsonMessage.fail().add("fieldErrors",fieldErrors);
        }
        //设置创建时间
        customerWithAddress.setCreateDate(new Date());
        System.out.println("storeId:"+customerWithAddress.getStoreId());
        customerService.addCustomer(customerWithAddress);

        return JsonMessage.success();
    }

    //更新用户(获取用户信息)
    @RequestMapping(value = "/editCustomer")
    @ResponseBody
    public JsonMessage editCustomer(@RequestParam(value = "customerId")Short customerId){

        CustomerWithAddress customerWithAddress=customerService.getCustomerById(customerId);

        return JsonMessage.fail().success().add("customer",customerWithAddress);
    }

    //更新用户信息（提交更新）
    @ResponseBody
    @RequestMapping(value = "/editCustomerSubmit")
    public JsonMessage editCustomerSubmit(@Validated CustomerWithAddress customerWithAddress ,BindingResult result){

        //获取校验错误信息
        if(result.hasErrors()){

            List<FieldError> fieldErrors=result.getFieldErrors();

            return JsonMessage.fail().add("fieldErrors",fieldErrors);
        }

        customerService.updateCustomer(customerWithAddress);
        return JsonMessage.success();
    }

    //删除用户信息
    @RequestMapping(value = "/deleteCustomer")
    @ResponseBody
    public JsonMessage deleteCustomer(@RequestParam("customerId") Short customerId){

        boolean flag=customerService.deleteCustomer(customerId);
        if (flag) {
            return JsonMessage.success();//删除成功
        }else {
            return JsonMessage.fail();//删除失败
        }
    }
}
