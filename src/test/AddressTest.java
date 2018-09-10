import com.lm.mapper.AddressMapper;
import com.lm.po.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/27.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext.xml"})
public class AddressTest {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void queryAddress(){
        List<Address> list=addressMapper.queryAddress();
        System.out.println(list.size());
    }
}
