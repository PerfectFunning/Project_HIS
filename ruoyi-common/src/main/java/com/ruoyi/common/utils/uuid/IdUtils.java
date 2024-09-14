package com.ruoyi.common.utils.uuid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ID生成器工具类
 * 
 * @author ruoyi
 */
public class IdUtils
{
    /**
     * 获取随机UUID
     * 
     * @return 随机UUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     * 
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     * 
     * @return 随机UUID
     */
    public static String fastUUID()
    {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     * 
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID()
    {
        return UUID.fastUUID().toString(true);
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();

    public static String orderNum() {
        String dateStr = sdf.format(new Date());
        int randomNum = random.nextInt(10000); // 生成一个0到9999之间的随机数
        return dateStr + String.format("%04d", randomNum); // 格式化随机数为四位数，不足四位前面补零
    }
}
