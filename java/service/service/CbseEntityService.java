package service.service;

import common.entity.CbseDatabase;
import dao.CbseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CbseEntityService {

    @Autowired
    CbseDao cbseDao;

    @Transactional
    public void saveDataAndRollno(CbseDatabase cbseDatabase) throws Exception{

         cbseDao.saveDataAndRoll(cbseDatabase);
    }

    @Transactional
    public boolean checkRollno(String roll1) throws Exception {
        return cbseDao.checkRollno(roll1);
    }


    @Transactional
    public List retrieveCbseList(int rolln){

        return cbseDao.retrieveCbseList(rolln);
    }

    @Transactional
    public List retrieveCbseRollno(int rolln){

        return cbseDao.retrieveCbseList(rolln);
    }
}
