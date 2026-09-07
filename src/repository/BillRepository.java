package repository;

import model.Bill;
import java.util.List;

public interface BillRepository {
    public List<Bill> getAllBillsByUser(int userId);
}
