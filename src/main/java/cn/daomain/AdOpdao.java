package cn.daomain;

import cn.dao.Bill;
import cn.dao.Infor;
import cn.dao.User;
import cn.dao.Worker;

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
    String SelectWorkerId( );
    List<Worker> ReaderWork();
    int InsertWorker(Worker worker);
    int DeleteWorker(String snum);
    Worker ReaderSNum(String snum);
}
