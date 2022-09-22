import br.com.desenvigor.dao.ClientDAO;
import br.com.desenvigor.dao.ProductItemDAO;
import br.com.desenvigor.model.Client;
import br.com.desenvigor.model.ProductItem;
import br.com.desenvigor.model.ShopList;
import br.com.desenvigor.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int operation = 0;

        while (operation != 4){
            showMenu();
            System.out.print("\nInsert operation number: ");
            operation = sc.nextInt();
            sc.nextLine();
            EntityManager em = new JPAUtil().createEntityManager();


            switch (operation){
                case 1:{
                    System.out.println("Insert product data:");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Price: ");
                    BigDecimal price = sc.nextBigDecimal();
                    ProductItem product = new ProductItem(name, desc, price);
                    ProductItemDAO productDAO = new ProductItemDAO(em);
                    em.getTransaction().begin();
                    productDAO.insertProduct(product);
                    em.getTransaction().commit();
                    em.close();

                    break;
                } //Product register
                case 2:{
                    System.out.println("Insert client data:");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Social Security Number (SSN): ");
                    String ssn = sc.nextLine();
                    System.out.print("Birthdate[dd/mm/aa]: ");
                    String birthdate = sc.nextLine();

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                    Date date = formatter.parse(birthdate);

                    Client client = new Client(name, ssn, date);
                    ClientDAO clientDAO = new ClientDAO(em);
                    em.getTransaction().begin();
                    clientDAO.insertClient(client);
                    em.getTransaction().commit();
                    em.close();

                    break;
                } //Client Register
                case 3:{
                    ProductItemDAO productDAO = new ProductItemDAO(em);
                    em.getTransaction().begin();
                    List<ProductItem> list2 = productDAO.findAll();
                    ShopList list = new ShopList();
                    int i = 0;
                    for (ProductItem item: list2) {
                        System.out.println(item);
                    }

                    boolean cond = true;
                    int opt;
                    do {
                        System.out.println("Insert the number to add in the list: ");
                        System.out.println("Insert '0' to quit");
                        opt = sc.nextInt();
                        if (opt == 0){
                            cond = false;
                        }
                        list.addProduct(productDAO.findByID(opt));
                    } while (cond);

                    System.out.println("Select the client: ");
                    ClientDAO clientDAO = new ClientDAO(em);
                    for (Client client : clientDAO.findALL()){
                        System.out.println(client);
                    }
                    int selectClient = sc.nextInt();
                    list.setClient(clientDAO.find(selectClient));
                    list.printList();

                    em.close();

                    break;
                } //Create new shoplist
            }
        }

    }

    public static void showMenu(){
        System.out.println("Select the operation:");
        System.out.println("1 - Register new product");
        System.out.println("2 - Register new Client");
        System.out.println("3 - Create new shop list");
        System.out.println("4 - exit system");
    }
}