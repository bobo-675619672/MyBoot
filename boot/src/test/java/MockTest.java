import com.dw.boot.mock.feign.MockFeign;
import com.dw.boot.mock.service.MockService;
import com.dw.boot.mock.service.impl.MockServiceImpl;
import mock.MockTarget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockTest.class)
@Import({ FeignAutoConfiguration.class, HttpMessageConvertersAutoConfiguration.class })
@EnableFeignClients(clients = MockFeign.class)
public class MockTest {

    @Autowired
    private MockFeign mockFeign;

    @InjectMocks
    private MockServiceImpl mockService;

    @Before
    public void setUp() {
        when(mockFeign.mock1(anyString())).thenReturn("假的1!");
        ReflectionTestUtils.setField(mockService, "mockFeign", mockFeign);
//        when(mockFeign.mock1(anyString())).thenReturn("假的1!");
//        when(mockFeign.mock2(anyString())).thenAnswer(Answers.CALLS_REAL_METHODS);
//        when(mockService.mock2(anyString())).thenCallRealMethod();
    }

    @Test
    public void test() {
        System.out.println("mockFeign:" + mockFeign.mock1("1"));
        System.out.println("mockFeign:" + mockFeign.mock2("2"));

        System.out.println("mockService:" + mockService.mock1("1"));
        System.out.println("mockService:" + mockService.mock2("2"));
    }

}
