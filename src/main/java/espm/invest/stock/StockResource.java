package espm.invest.stock;

import espm.invest.stock.common.controller.StockController;
import espm.invest.stock.common.datatype.Stock;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class StockResource implements StockController {

    @Override
    public List<Stock> stock() {
        List<Stock> stocks = new ArrayList<>();
        Date data = new Date();
        Stock s1 = new Stock(UUID.randomUUID(),  "TESTE", data, 200);
        stocks.add(s1);
        return stocks;
    }

    @Override
    public Stock stock(String id) {
        return null;
    }

    @Override
    public Stock deleteById(String id) {
        return null;
    }

    @Override
    public Stock save(Stock stock) {
        return null;
    }
}
