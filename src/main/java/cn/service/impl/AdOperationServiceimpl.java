package cn.service.impl;

import cn.dao.Bill;
import cn.dao.User;
import cn.dao.Worker;
import cn.daomain.AdOpdao;
import cn.daomain.impl.AdOpdaoimpl;
import cn.service.AdOperationService;

import java.util.List;
import java.util.Map;

public class AdOperationServiceimpl implements AdOperationService {
    AdOpdao addao=new AdOpdaoimpl();
    @Override
    public List<User> ReaderUser() {
        return addao.ReaderUser();
    }

    @Override
    public int DeleteUser(String snum) {
        return addao.DeleteUser(snum);
    }

    @Override
    public int InsertUser(User user) {
        return addao.InsertUser(user);
    }

    @Override
    public User ReaderNum(String num) {
        return addao.ReaderNum(num);
    }

    @Override
    public int Adupuser(User user) {
        return addao.Adupuser(user);
    }

    @Override
    public Map<String, Object> lookmes() {
        return addao.lookmes();
    }

    @Override
    public int DeletrInfor(String num) {
        return addao.DeletrInfor(num);
    }

    @Override
    public List<Bill> ReaderBill() {
        return addao.ReaderBill();
    }

    @Override
    public Bill ReaderBillnum(String num) {
        return addao.ReaderBillnum(num);
    }

    @Override
    public int UpdateBill(Bill bill) {
        return addao.UpdateBill(bill);
    }

    @Override
    public int DeleteBill(String snum) {
        return addao.DeleteBill(snum);
    }

    @Override
    public String SelectWorkerId() {
        return addao.SelectWorkerId();
    }

    @Override
    public List<Worker> ReaderWork() {
        return addao.ReaderWork();
    }

    @Override
    public int InsertWorker(Worker worker) {
        return addao.InsertWorker(worker);
    }
}
