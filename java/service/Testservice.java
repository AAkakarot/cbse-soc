package service;

import common.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.service.TestEntityService;

@Service
public class Testservice {

    @Autowired
    TestEntityService testEntityService;

    public void testLoadData(int id,String name) throws Exception{

        TestEntity testEntity = new TestEntity();

        testEntity.setId(id);
        testEntity.setName(name);

        testEntityService.saveData(testEntity);


    }
}
