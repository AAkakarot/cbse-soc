package service;

import Util.StringHelper;
import common.entity.CbseDatabase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.service.CbseEntityService;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CbseService {

    @Autowired
    CbseEntityService cbseEntityService;


    public void saveDataWithRollno(String rollno, String name,String schoolId) throws Exception{



            if(!cbseEntityService.checkRollno(rollno)) {
                CbseDatabase cbseDatabase = new CbseDatabase();

                String random = StringHelper.getRandomInt(5);
                cbseDatabase.setSchoolRollno(Integer.parseInt(rollno));
                cbseDatabase.setName(name);
                cbseDatabase.setSchoolId(schoolId);
                cbseDatabase.setCBSErollno(Integer.parseInt(random));
                cbseEntityService.saveDataAndRollno(cbseDatabase);

            }

    }


    public String stringRollno(String rollno) throws Exception{

        int roll=Integer.parseInt(rollno);
        List list = cbseEntityService.retrieveCbseList(roll);
        StringBuilder str= new StringBuilder();
        for(Object s:list){
            str.append(s.toString());
        }
        return str.toString();
    }


    public String stringfile(String rollno) throws Exception{

        int roll=Integer.parseInt(rollno);
        return cbseEntityService.retrieveCbseList(roll).toString();

    }

/*
    public File RollnoFile() throws Exception{

        List<CbseDatabase> list = cbseEntityService.retrieveCbseList();

        String csvFile = "/Users/sudhanshusindhu/Documents/csvcbse.csv";

        FileWriter writer = new FileWriter(csvFile);

        csvFile =StringUtils.join(list, ",");

        return new File(csvFile);
    }*/




}
