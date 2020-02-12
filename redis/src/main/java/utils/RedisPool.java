package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    //声明成static的原因：保证jedis连接池在tomcat启动时就加载出来
    //jedis连接池
    private static JedisPool pool;
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.pool.maxTotal", "20"));
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.pool.maxIdle", "10"));
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.pool.minIdle", "2"));
    private static Integer maxWaitMillis = Integer.parseInt(PropertiesUtil.getProperty("redis.pool.maxWaitMillis", "2"));
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.pool.testOnBorrow", "true"));
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.pool.testOnReturn", "true"));
    private static Integer timeBetweenEvictionRunsMillis = Integer.parseInt(PropertiesUtil.getProperty("redis.pool.timeBetweenEvictionRunsMillis", "2"));
    private static Boolean testWhileIdle =Boolean.parseBoolean(PropertiesUtil.getProperty("redis.pool.testWhileIdle", "true"));
    private static Integer numTestsPerEvictionRun = Integer.parseInt(PropertiesUtil.getProperty("redis.pool.numTestsPerEvictionRun", "2"));
    private static String redisIp = PropertiesUtil.getProperty("redis.ip");
    private static Integer redisPort = Integer.parseInt(PropertiesUtil.getProperty("redis.port"));
    //初始化连接池，只会调用一次
    private static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        config.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        config.setTestWhileIdle(testWhileIdle);
        config.setNumTestsPerEvictionRun(numTestsPerEvictionRun);

        //连接池耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时，会抛出超时异常，默认为true
        config.setBlockWhenExhausted(true);

        //这里超时时间是2s
        pool = new JedisPool(config, redisIp, redisPort, 1000*2);

    }

    static {
        initPool();
    }

    //从连接池中拿取一个实例
    public static Jedis getJedis() {
        return pool.getResource();
    }

    //将正常实例放回jedis连接池
    public static void returnResource(Jedis jedis) {
        pool.close();
    }

    //将破损实例放回jedis连接池
    public static void returnBrokenResource(Jedis jedis) {
        pool.close();
    }

}