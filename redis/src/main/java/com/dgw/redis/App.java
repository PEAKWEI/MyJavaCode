package com.dgw.redis;

import utils.RedisPoolUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
          RedisPoolUtil.set("username", "dgw");
          
    }
}
