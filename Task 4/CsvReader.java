import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvReader{

    public static void main(String args[]) throws IOException{

        BufferedReader Reader = new BufferedReader(new FileReader("D:\\JavaInternship@BroSkiesHub\\Task 4\\Products.csv"));
        BufferedWriter Writer = new BufferedWriter(new FileWriter("D:\\JavaInternship@BroSkiesHub\\Task 4\\NewProducts.csv"));
        
        String read;
        while((read = Reader.readLine()) != null){
  
            String[] ProductList = read.split(",");

            String name = ProductList[0];
            String price = ProductList[1];

            Double convertedPrice = Double.parseDouble(price);

            if(convertedPrice > 1000){

                Writer.write(name + ", " + convertedPrice + "\n");
            }   
        }


        Writer.close();
        Reader.close();
        System.out.println("Read and Write completed successfully!");
    }
}