package espm.invest.stock;

import espm.invest.stock.common.controller.StockController;
import espm.invest.stock.common.datatype.Stock;
import espm.invest.stock.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
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
    public Stock stock(@PathVariable String name) {
        return stockService.findByName(name);
    }



    @Override
    public Stock stockById(@PathVariable String id) {
        return stockService.findById(UUID.fromString(id));
    }

    @Override
    public Stock stock(String name, String date) {
        try {
            Stock stock = stockService.findByName(name);
            if (stock == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " not found");
            }
            System.out.println(date);
            System.out.println(sdf.parse(date));
            return stockService.findBy(stock.getId(), sdf.parse(date));
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Stock> cotacoes(@RequestParam String name, @RequestParam String ini, @RequestParam String fim) {

            try {
                Stock stock = stockService.findByName(name);
                if (stock == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " not found");
                }
                Date dtInicio = ini == null ? null : sdf.parse(ini);
                Date dtTermino = fim == null ? null : sdf.parse(fim);
                return stockService.listBy(stock.getId(), dtInicio, dtTermino);
            } catch (ParseException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
    }


}
