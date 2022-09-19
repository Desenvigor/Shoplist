import br.com.desenvigor.model.Client;
import br.com.desenvigor.model.ProductItem;

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
        List<ProductItem> products = new ArrayList<ProductItem>();

        while (operation != 4){
            showMenu();
            System.out.print("\nInsert operation number: ");
            operation = sc.nextInt();
            sc.nextLine();

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
                    products.add(product);

                    System.out.println(product);
                    break;
                }
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
                    System.out.println(client);
                    break;
                }
                case 3:{
                    int i = 0;
                    for (ProductItem item: products) {
                        System.out.println(++i +" - "+ item);
                    }
                    boolean cond = true;
                    int opt = 0;
                    do {
                        System.out.println("Insert the number to add in the list: ");
                        System.out.println("Insert '0' to quit");
                        opt = sc.nextInt();
                        if (opt == 0){
                            cond = false;
                            break;
                        }


                    } while (cond);
                }

            }
        }

    }

    public static void showMenu(){
        System.out.println("Select the operation:");
        System.out.println("1 - Register new product");
        System.out.println("2 - Register new Client");
        System.out.println("3 - Create new shoplist");
        System.out.println("4 - exit system");
    }
}

