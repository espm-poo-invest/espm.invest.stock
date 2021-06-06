package espm.invest.stock;

import espm.invest.stock.common.datatype.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="stock")
public class StockModel {

    @Id
    @Column(name="id_stock")
    private String idStock;
    @Column(name="txt_name")
    private String name;
    @Column(name="s_date")
    private Date date;
    private double price;

    public StockModel(){

    }
    public StockModel(Stock b){
        this.idStock = b.getId().toString();
        this.name = b.getName();
        this.date = b.getDate();
        this.price = b.getPrice();
    }
    public Stock to(){
        Stock b = new Stock();
        b.setId(UUID.fromString(idStock));
        b.setName(name);
        b.setDate(date);//converte aqui
        b.setPrice(price);
        return b;
    }

}
