package in.codepredators.delta.Classes;

import java.util.concurrent.atomic.AtomicBoolean;

public class ContactSelect {
    public String selectContactsName;
    public String selectContactsPhoneNo;
    public String selectContactsStatus;
    public ContactSelect() {
    }
    public ContactSelect(String selectContactsName, String selectContactsPhoneNo, String selectContactsStatus) {
        this.selectContactsName = selectContactsName;
        this.selectContactsPhoneNo = selectContactsPhoneNo;
        this.selectContactsStatus= selectContactsStatus;

    }
    public String getSelectContactsName()
    {
        return selectContactsName;
    }

    public void setSelectContactsName(String selectContactsName) {
        this.selectContactsName = selectContactsName;
    }



    public String getSelectContactsPhoneNo() {
        return selectContactsPhoneNo;
    }

    public void setSelectContactsPhoneNo(String selectContactsPhoneNo) {
        this.selectContactsPhoneNo = selectContactsPhoneNo;
    }


    public String getSelectContactsStatus() {
        return selectContactsStatus;
    }

    public void setSelectContactsStatus(String selectContactsStatus) {
        this.selectContactsStatus = selectContactsStatus;
    }
}