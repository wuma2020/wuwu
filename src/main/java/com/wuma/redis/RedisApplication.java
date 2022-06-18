package com.wuma.redis;

import com.wuwu.base.client.Handler.ArrayHandler;
import com.wuwu.base.client.WuwuApplication;
import com.wuwu.base.client.WuwuConfig;
import com.wuwu.base.client.WuwuFutureClient;
import com.wuwu.base.client.WuwuPipeline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedisApplication {

    private static final Logger LOGGER = LogManager.getLogger();

    //空的构造器
    private RedisApplication(){

    }

    private static WuwuApplication wuwuApplication = null;

    /**
     * 获取redis app
     * @return
     */
    public static WuwuApplication getWuwu(){
        if(wuwuApplication == null){
            wuwuApplication = new WuwuApplication();
        }

        return wuwuApplication;
    }

    /**
     * 初始化wuwu redis cli 配置
     */
    public static void initRedisContext(){
        try {
            WuwuApplication wuwu = getWuwu();
            WuwuConfig wuwuConfig = new WuwuConfig();
            wuwuConfig.setSocketNum(2);
            wuwuConfig.setHost("localhost");
            wuwuConfig.setPort(6379);
            wuwuConfig.setPassword("123456");
            WuwuPipeline wuwuPipeline = new WuwuPipeline();
            wuwuPipeline.addHandler(new ArrayHandler());
            wuwuConfig.setPipeline(wuwuPipeline);
            wuwu.startApplication(wuwuConfig);
            WuwuFutureClient client = wuwu.getClient();
            Object keys = client.keys();
            LOGGER.info(keys);
            client.recycleSocket();
            LOGGER.info("初始化redis完成");
        }catch (Exception e){
            // 初始化redis连接失败
            LOGGER.error("初始化redis连接失败",e);
            throw new RuntimeException(e);
        }

    }


}
