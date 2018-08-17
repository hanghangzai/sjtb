package com.lh.sjtb.datasource;

/**
 * @author lihang
 * @Package com.gd.datasource
 * @date 2018/8/1411:32
 * 保存一个线程安全的DatabaseType容器
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

    public static void setDatabaseType(DatabaseType type){
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType(){
       return contextHolder.get();
    }

}
