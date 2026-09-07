package repository.impl;

import model.Bill;
import model.BillStatus;
import repository.BillRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BillRepositoryImpl implements BillRepository {
    private final Map<Integer, Bill> billMap;

    public BillRepositoryImpl() {
        billMap = new LinkedHashMap<>();
        billMap.put(101, new Bill(101, 101, 100, LocalDate.of(2026, 9, 1), LocalDate.now(), BillStatus.PENDING));
    }

    @Override
    public List<Bill> getAllBillsByUser(int userId) {
        return billMap.values()
                .stream()
                .filter(k -> k.getUId() == userId)
                .toList();
    }
}
