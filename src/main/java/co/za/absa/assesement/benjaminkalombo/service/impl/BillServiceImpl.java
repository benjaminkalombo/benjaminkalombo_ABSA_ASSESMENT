package co.za.absa.assesement.benjaminkalombo.service.impl;

import co.za.absa.assesement.benjaminkalombo.model.Bill;
import co.za.absa.assesement.benjaminkalombo.repository.BillRepository;
import co.za.absa.assesement.benjaminkalombo.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public void addBill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void deleteBill(Bill bill) {
        billRepository.delete(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill findBill(Long id) {
        return billRepository.getOne(id);
    }
}
