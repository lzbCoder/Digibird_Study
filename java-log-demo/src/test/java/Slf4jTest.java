
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lzb
 * @version 1.0
 * @date 2021-04-11 16:59
 */
public class Slf4jTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

    @Test
    public void test(){
        //日志输出
        //默认输出info级别
        LOGGER.error("error");
        LOGGER.warn("warning");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        //使用占位符输出日志信息
        String name = "lzb";
        Integer age = 22;
        LOGGER.info("用户: {},{}",name,age);

        //将系统的异常信息输出
        try {
            int i = 1/0;
        }catch (Exception e){
//            e.printStackTrace();
            LOGGER.error("出现异常:",e);
        }

    }

}
