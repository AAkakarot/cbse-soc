package service.service;

import common.entity.TestEntity;
import dao.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestEntityService {

    @Autowired
    TestDao testDao;

    @Transactional
    public void saveData(TestEntity testEntity){
        try {
            testDao.saveTestData(testEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}