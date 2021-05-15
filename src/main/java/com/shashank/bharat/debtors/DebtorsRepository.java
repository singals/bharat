package com.shashank.bharat.debtors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorsRepository extends CrudRepository<Debtor, Long> {
}
