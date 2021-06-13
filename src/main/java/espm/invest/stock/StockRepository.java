package espm.invest.stock;

import espm.invest.stock.common.datatype.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends CrudRepository<StockModel, String>{
    @Override
    Iterable<StockModel> findAll();

    @Override
    Optional<StockModel> findById(String s);

    @Query("SELECT c from StockModel c WHERE c.idStock = :idStock AND c.date <= :date ORDER BY c.date DESC")
    List<StockModel> listByStockDate(
            @Param("idStock") String idStock,
            @Param("date") Date date);

    @Query("SELECT c FROM StockModel c " +
            "WHERE " +
            "(c.idStock is null or c.idStock = :idStock) AND " +
            "(c.date is null or c.date >= :dtInicio) AND " +
            "(c.date is null or c.date <= :dtFim)"
    )
    List<StockModel> listBy(
            @Param("idStock") String idStock,
            @Param("dtInicio") Date dtInicio,
            @Param("dtFim") Date dtFim
    );

    @Query("SELECT m from StockModel m WHERE UPPER(m.name) = UPPER(:name)")
    Optional<StockModel> findByName(@Param("name") String name);
}
