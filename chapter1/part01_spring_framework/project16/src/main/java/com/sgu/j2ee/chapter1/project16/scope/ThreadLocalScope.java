package com.sgu.j2ee.chapter1.project16.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalScope implements Scope {

    private final ThreadLocal<Map<String, Object>> threadLocal =
            ThreadLocal.withInitial(ConcurrentHashMap::new);

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        Map<String, Object> scopedObjects = threadLocal.get();

        // Kiểm tra map hiện tại đã tồn tại đối tượng với tên 'name' chưa, nếu chưa thì tạo mới bằng objectFactory
        return scopedObjects.computeIfAbsent(name,
                k -> objectFactory.getObject());
    }

    @Override
    public Object remove(String name) {
        return threadLocal.get().remove(name);
    }

    // Đăng ký cơ chế hủy đối tượng khi scope kết thúc, nhưng trong trường hợp này chúng ta không cần thực hiện gì cả
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Optional destruction logic
    }
}