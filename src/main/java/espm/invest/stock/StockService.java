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
        return stockRepository
                .findByName(name)
                .map(StockModel::to)
                .orElse(null);
    }

    public Stock create(Stock stock) {
        stock.setId(UUID.randomUUID().toString());
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

    //    public Stock findBy(String idStock, Date date) {
///*
//        List<CotacaoModel> cotacoes = cotacaoRepository.listByMoedaData(idMoeda, data);
//        if (cotacoes.size() > 0) {
//            CotacaoModel cm = cotacoes.get(0);
//            return cm.to();
//        } else {
//            return null;
//        }
//*/
//        Stock stock = stockRepository
//                .listByStockDate(idStock, date).stream()
//                .map(StockModel::to)
//                .findFirst()
//                .orElse(null);
//        // Aqui esta sendo feito um relacionamento
//        return fill(cotacao);
//    }
//
    public void delete(UUID id) {
        stockRepository.deleteById(id.toString());
    }



}
