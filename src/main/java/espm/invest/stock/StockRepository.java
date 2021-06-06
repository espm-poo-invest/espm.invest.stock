package espm.invest.stock;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StockRepository extends CrudRepository<StockModel, String>{
    @Override
    Iterable<StockModel> findAll();

    @Override
    Optional<StockModel> findById(String s);
}
