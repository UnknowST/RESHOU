import com.service.Userservice;
import com.service.impl.UserserviceImpl;
import org.junit.Test;

import java.io.IOException;

public class MapperTest {
    @Test
    public void test1(){
        Userservice userservice=new UserserviceImpl();

            System.out.println(userservice.findall());

    }
}
