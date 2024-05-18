package com.pzhu.redis.key;

import java.util.concurrent.TimeUnit;

/**
 * redis key 通用规范设计
 */
public interface KeyPrefix {//redis中key的前缀

    /**
     * key前缀
     * @return
     */
    String getPrefix();

    /**
     * 超时时间， -1表示没有超时时间
     * @return
     */
    default Long getTimeout(){//默认方法
        return Long.valueOf(-1);
    }

    /**
     * 如果有超时时间，就必须有单位，如果没有可以不用设置单位
     * @return
     */
    default TimeUnit getUnit(){
        return null;
    }

    default String fullKey(String... suffix){
        StringBuilder sb = new StringBuilder(100);
        sb.append(getPrefix());
        for (String s : suffix) {
            sb.append(":").append(s);
        }
        return sb.toString();
    }
}
