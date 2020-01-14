package co.za.absa.assesement.benjaminkalombo.service;

import co.za.absa.assesement.benjaminkalombo.model.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
   void addBill(Bill bill);
   void deleteBill(Bill bill);
   List<Bill> getAllBills();
   Bill findBill(Long id);
}
