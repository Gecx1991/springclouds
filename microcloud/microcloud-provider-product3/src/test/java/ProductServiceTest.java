import com.gecx.Product3App;
import com.gecx.service.ProduceService;
import com.gecx.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/3/15 1:15
 */
@SpringBootTest(classes = Product3App.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProduceService produceService;

    @Test
    public void test() {
        List<Product> list = produceService.list();
        list.stream().forEach(item -> System.out.println(item.toString()));
    }
}
