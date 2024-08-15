package me.tdd.book.Week03.ch06.stub;

import me.tdd.book.Week03.ch06.AutoDebitInfo;
import me.tdd.book.Week03.ch06.AutoDebitInfoRepository;

import java.util.HashMap;
import java.util.Map;

public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
    private Map<String, AutoDebitInfo> infos = new HashMap<>();


    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUserId(), info);
    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }

    public void clear() {
        infos.clear();
    }
}
