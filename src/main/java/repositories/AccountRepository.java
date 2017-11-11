package repositories;

import models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account,Integer> {
    @Query("SELECT acc FROM account k WHERE email= :data")
    public Account findByUsername (@Param("data")String data);
}
