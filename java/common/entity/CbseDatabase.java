package common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cbsedatabase")
public class CbseDatabase implements Serializable {

    private int schoolRollno;
    private String name;
    private String schoolId;
    @Id
    private int CBSErollno;

    public int getSchoolRollno() {
        return schoolRollno;
    }

    public void setSchoolRollno(int schoolRollno) {
        this.schoolRollno = schoolRollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String  schoolId) {
        this.schoolId = schoolId;
    }

    public int getCBSErollno() {
        return CBSErollno;
    }

    public void setCBSErollno(int CBSErollno) {
        this.CBSErollno = CBSErollno;
    }

}
