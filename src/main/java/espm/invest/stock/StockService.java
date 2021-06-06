package espm.invest.stock;

import espm.invest.stock.common.datatype.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> listAll() {
        return StreamSupport
                .stream(stockRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(StockModel::to)
                .collect(Collectors.toList());
    }

    public Stock findBy(UUID id) {
        return stockRepository.findById(id.toString()).map(stockModel -> stockModel.to()).orElse(null);

    }

    public Stock create(Stock stock) {
        stock.setId(UUID.randomUUID());
        return stockRepository.save(new StockModel(stock)).to();
    }

//    public List<Stock> listByName(String name){
//        return stockRepository.listByName(name)
//                .stream().map(StockModel::to)
//                .collect(Collectors.toList());
//    }
//    public List<Stock> listByDate(Date date){
//        return stockRepository.listByDate(date.toString())
//                .stream().map(StockModel::to)
//                .collect(Collectors.toList());
//    }
//    public List<StockBean> listByPrice(Double price){
//        return stockRepository.listByPrice(price)
//                .stream().map(StockModel::to)
//                .collect(Collectors.toList());
//    }

    public void delete(UUID id) {
        stockRepository.deleteById(id.toString());
    }

}
