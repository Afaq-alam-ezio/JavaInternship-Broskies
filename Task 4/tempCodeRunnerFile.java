import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CsvReader{

    public static void main(String args[]) throws IOException{

        BufferedReader Reader = new BufferedReader(new FileReader("D:\\JavaInternship@BroSkiesHub\\Task 4\\Products.csv"));
        
        System.out.println("Reading files below : ");
        String read;
        while((read = Reader.readLine()) != null){

            System.out.println(read);
        }

        System.out.println();

        
        while((read = Reader.readLine()) != null){

            String[] ProductList = read.split(",");

            String name = ProductList[0];
            String price = ProductList[1];

            Double convertedPrice = Double.parseDouble(price);

            BufferedWriter Writer = new BufferedWriter(new FileWriter("D:\\JavaInternship@BroSkiesHub\\Task 4\\NewProducts.csv"));

            if(convertedPrice > 1000){

                Writer.write(name + ", " + convertedPrice + "\n");
            }

            Writer.close();
        }

        Reader.close();
        
    }
}