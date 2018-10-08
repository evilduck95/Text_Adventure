package com.textAdventure.Text_Adventure.Repositories;

import com.textAdventure.Text_Adventure.TestItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestItemRepo extends MongoRepository<TestItem, String> {

    public TestItem findByNum(int num);

    public TestItem findByStr(String str);

}
