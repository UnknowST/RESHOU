package cn.daomain;

import cn.dao.Bill;
import cn.dao.Infor;
import cn.dao.User;

import java.util.List;
import java.util.Map;

public interface AdOpdao {

    List<User> ReaderUser();
    int DeleteUser(String snum);
    int InsertUser(User user);
    User ReaderNum(String num);
    int Adupuser(User user);
    Map<String,Object> lookmes();
    int DeletrInfor(String num);
    List<Bill> ReaderBill( );
    Bill ReaderBillnum(String num);
    int UpdateBill(Bill bill);
    int DeleteBill(String snum);
}
