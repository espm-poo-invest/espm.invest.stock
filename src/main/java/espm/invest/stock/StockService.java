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
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> listAll() {
        return StreamSupport
                .stream(stockRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(StockModel::to)
                .collect(Collectors.toList());
    }

    public Stock findById(UUID id) {
        return stockRepository.findById(id.toString()).map(stockModel -> stockModel.to()).orElse(null);

    }

    public Stock findByName(String name) {
        List<Stock> stocks =  StreamSupport
                .stream(stockRepository.findByName(name).spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(StockModel::to)
                .collect(Collectors.toList());

        return stocks.size() == 0 ? null : stocks.get(0);
    }

    public Stock create(Stock stock) {
        stock.setId(UUID.randomUUID().toString());
        return stockRepository.save(new StockModel(stock)).to();
    }


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

    public Stock findBy(String idStock, Date date) {
        return stockRepository
                .listByStockDate(idStock, date).stream()
                .map(StockModel::to)
                .findFirst()
                .orElse(null);
    }

    public List<Stock> listBy(String idStock, Date dtInicio, Date dtFim) {
        return stockRepository
                .listBy(idStock, dtInicio, dtFim).stream()
                .map(StockModel::to)
                .collect(Collectors.toList());
    }



    public void delete(UUID id) {
        stockRepository.deleteById(id.toString());
    }



}
