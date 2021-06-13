package espm.invest.stock;

import espm.invest.stock.common.controller.StockController;
import espm.invest.stock.common.datatype.Stock;
import espm.invest.stock.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EnableFeignClients(basePackages = {"espm.invest.stock.common.controller", "espm.invest.portfolio.common.controller"})
@RestController
public class StockResource implements StockController {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private StockService stockService;

    @Override
    public List<Stock> stock() {
        return stockService.listAll();
    }

    @Override
    public Stock stock(String name) {
        return stockService.findByName(name);
    }

    @Override
    public Stock stockById(String id) {
        return stockService.findById(UUID.fromString(id));
    }

    @Override
    public Stock stock(String name, String date) {
        return null;
    }

    @Override
    public List<Stock> cotacoes(String name, String ini, String fim) {
        return null;
    }


}
