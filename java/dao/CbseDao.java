package dao;

import common.entity.CbseDatabase;
import dao.dao.BaseDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CbseDao extends BaseDaoImpl<CbseDatabase,String> {

    public void saveDataAndRoll(CbseDatabase cbseDatabase) throws Exception{

            save(cbseDatabase);

    }

    public List retrieveCbseList(int rollno) {

    String hql = "select CBSErollno from CbseDatabase where schoolRollno=:rollno";
    Query query = getCurrentSession().createQuery(hql);
    query.setParameter("rollno", rollno);

    return query.list();


    }


    public  boolean checkRollno(String rollno) throws Exception {
        try {
            String hql = "from CbseDatabase where schoolRollno=:rollno ";
            Query query = getCurrentSession().createQuery(hql);
            query.setParameter("rollno", new Integer(rollno));

            return query.uniqueResult() != null;

        } catch (HibernateException e) {
            throw new Exception();
        }
    }

}
