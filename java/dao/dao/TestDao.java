package dao.dao;

import common.entity.TestEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao extends BaseDaoImpl<TestEntity,String> {

    public void saveTestData(TestEntity testEntity) throws Exception{

        save(testEntity);
    }
}
