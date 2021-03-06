package cn.whl.commonutils.cache.pool.map.memory;

import cn.whl.commonutils.cache.pool.map.MapCachePool;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用主存保存数据的Map型缓存池，泛型，实现MapCachePool
 * @author wuhailong
 * @param <T> 存入的List的数据类型
 */
/*
* 0.0.1版：初始版本
*/
public class MemoryMapCachePool <T> implements MapCachePool<T>{
    
    /**
     * 主存Map
     */
    private final Map<String, T> map = new HashMap<>();
    
    /**
     * 读写锁
     */
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    /**
     * 放入元素（列表型）
     * @param key  Map的Key
     * @param t mapValue
     */
    @Override
    public void put(String key, T value){
        lock.writeLock().lock();
        try {
            map.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    
    /**
     * 清空
     */
    @Override
    public void clear(){
        lock.writeLock().lock();
        try {
            map.clear();
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    /**
     * 判断是否存在Key
     * @param key  Map的Key
     * @return  是否存在
     */
    @Override
    public Boolean containsKey(String key){
        lock.readLock().lock();
        try {
            return map.containsKey(key);
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * 清除Key对应的记录
     * @param key Map的Key
     */
    @Override
    public void clearByKey(String key) {
        lock.readLock().lock();
        try {
            map.remove(key);
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * 获取所有的Key
     * @return  Key的Set集合
     */
    @Override
    public Set<String> getAllKey() {
        lock.readLock().lock();
        try {
            Set<String> keySet = map.keySet();   //不能把keySet直接返回，因为数组是引用类型，在外部迭代时不能进行删除操作，否则报concurrentmodificationexception
            Set<String> set = new HashSet();
            for(String key : keySet){
                set.add(key);
            }
            return set;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public T getValue(String key) {
        lock.writeLock().lock();
        try {
            return map.get(key);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
