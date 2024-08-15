package me.tdd.book.Week03.stub;

import me.tdd.book.Week03.AutoDebitInfo;
import me.tdd.book.Week03.AutoDebitInfoRepository;

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
}
