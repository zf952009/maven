package cn.itcast.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * codening:utf-8
 *
 * @author :UserRedis
 * @time :2019.09.05,10:33
 * @file :cn.itcast.redis.UserRedis.jave
 */
@Repository
public class UserRedis {
    private RedisTemplate<String,String> redisTemplate;
}
