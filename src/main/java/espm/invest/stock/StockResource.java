package espm.invest.stock;

import espm.invest.stock.common.controller.StockController;
import espm.invest.stock.common.datatype.Stock;
import espm.invest.stock.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class StockResource implements StockController {

    @Autowired
    private StockService stockService;

    @Override
    public List<Stock> stock() {
        return stockService.listAll();
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
