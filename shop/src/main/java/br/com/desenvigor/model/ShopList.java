package br.com.desenvigor.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopList {

    private List<ProductItem> items = new ArrayList<>();
    private Client client;

    public ShopList() {
    }

    public ShopList(Client client) {
        this.client = client;
    }

    public void addProduct(ProductItem product){
        items.add(product);
    }

    public void removeProduct(ProductItem product){
        items.remove(product);
    }

    public List<ProductItem> returnList(){
        return this.items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void printList(){
        List<String> text = new ArrayList<>();
        for (ProductItem item : items){
            text.add(item.toString());
        }
        PrintList.printFile(text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        BigDecimal total = new BigDecimal("0.0");
        for (ProductItem item : items ){
            sb.append(++i +" "+ item);
            total = total.add(item.getPrice());
        }
        sb.append("\nTotal value of the list\n");
        sb.append("R$ " + total);
        return sb.toString();
    }
}
