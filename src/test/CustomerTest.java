import com.lm.mapper.CustomerMapper;
import com.lm.po.CustomerWithAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


/**
 * Created by 龙鸣 on 2017/8/26.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext.xml"})
public class CustomerTest {

    @Autowired
    private CustomerMapper customerMapper;

    //测试根据firstName查询用户
    @Test
    public void queryCustomer(){
        int count=customerMapper.queryCustomerCountByFirstName("mary");
        System.out.println(count);
    }

    @Test
    public void queryAllCustomer(){
        List<CustomerWithAddress> list=customerMapper.queryAllCustomer();
        System.out.println(list.size());
    }

    //查询用户
    @Test
    public void queryCustomerById(){
        Short id=1;
        CustomerWithAddress customerWithAddress=customerMapper.queryCustomerById(id);
        System.out.println(customerWithAddress);
    }
    //新增用户
    @Test
    public void insertCustomer(){
        CustomerWithAddress customerWithAddress=new CustomerWithAddress();
        customerWithAddress.setFirstName("222");
        customerWithAddress.setLastName("222");
        customerWithAddress.setEmail("222");
        byte storeId=2;
        customerWithAddress.setStoreId(storeId);
        customerWithAddress.setAddress("47 MySakila Drive");
        customerWithAddress.setCreateDate(new Date());
        customerMapper.addCustomer(customerWithAddress);
    }

    //更新用户
    @Test
    public void updateCustomer(){

        CustomerWithAddress customerWithAddress=new CustomerWithAddress();
        short id=604;
        customerWithAddress.setCustomerId(id);
        customerWithAddress.setFirstName("龙鸣");
        customerWithAddress.setLastName("12");
        customerWithAddress.setAddress("47 MySakila Drive");
        customerWithAddress.setLastUpdate(new Date());
        customerMapper.updateCustomer(customerWithAddress);
    }

    //删除用户
    @Test
    public void deleteCustomer(){
        Short id=1;
        try {
            customerMapper.deleteCustomerById(id);
        } catch (Exception e) {
            System.out.println("出异常了");
        }
    }
}
