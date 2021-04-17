//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Log4jTest
 *
 * @author lzb
 * @date 2021/3/27
 * @time 14:46
 * @Description：
 */
//public class Log4jTest {
//
//    // 获取日志记录器并读取配置文件 -- 基于类的名称获取日志对象
//    private Logger logger = Logger.getLogger(Log4jTest.class);
//
//    //在主方法中使用logger打印
////    public static void main(String[] args) {
////        // 插入记录信息（格式化日志信息）
////        // 记录debug级别的信息
////        logger.debug("调试信息.");
////        // 记录info级别的信息
////        logger.info("输出信息.");
////        // 记录error级别的信息
////        logger.error("错误信息.");
////        // 记录warn级别的信息
////        logger.warn("警告信息.");
////        logger.trace("跟踪信息");
////        logger.fatal("致命信息");
////    }
//
//    //在单元测试中使用logger打印
//    @Test
//    public void logTest(){
//        /**
//         * log4j中6大日志级别
//         * 输出时，没有输出追踪信息，因为log4j默认输出日志级别为debug
//         */
//        //1 严重错误，一般会造成系统崩溃并终止运行
//        logger.fatal("致命信息");
//        //2 记录error级别的信息。错误信息，不会影响系统运行
//        logger.error("错误信息.");
//        //3 记录warn级别的信息。警告信息，可能会发生问题
//        logger.warn("警告信息.");
//        //4 记录info级别的信息。运行信息，如数据连接、网络连接、IO操作等等
//        logger.info("输出信息.");
//        //5 记录debug级别的信息。调式信息，一般在开发中使用，记录程序变量参数传递信息等
//        logger.debug("调试信息.");
//        //6 追踪信息，记录程序所有的流程信息。
//        logger.trace("跟踪信息");
//
//    }
//
//
//}
