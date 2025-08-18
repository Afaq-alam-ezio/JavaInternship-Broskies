import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class InvalidProductDataException extends Exception{

    public InvalidProductDataException(String message){

        super(message);
    }
}


public class CsvReader{

    public static void main(String args[]) throws IOException{

        BufferedReader Reader = null;
        BufferedWriter Writer = null;
        try{

            Reader = new BufferedReader(new FileReader("D:\\JavaInternship@BroSkiesHub\\Task 5\\sample.csv"));
            Writer = new BufferedWriter(new FileWriter("D:\\JavaInternship@BroSkiesHub\\Task 5\\NewProducts.csv"));
            
            String read;
            while((read = Reader.readLine()) != null){

                String[] ProductList = read.split(",");

                String name = ProductList[0];
                String price = ProductList[1];

                if(ProductList.length < 2 || ProductList[0].isEmpty() || ProductList[1].isEmpty()){

                    throw new InvalidProductDataException("Invalid product row : " + read);
                }

                Double convertedPrice = Double.parseDouble(price);

                if(convertedPrice > 1000){

                    Writer.write(name + ", " + convertedPrice + "\n");
                }
            }

            System.out.println("Read and Write completed successfully!");
        }
        catch(Exception e){

            if(e instanceof FileNotFoundException){

                System.out.println("File not found.\n" + "Detailed error = " + e);
            }
            else if(e instanceof NumberFormatException){

                System.out.println("Number Format Exception.\n" + "Detailed error = " + e);
            }
            else if(e instanceof InvalidProductDataException){

                System.out.println(e.getMessage());
            }
            else{

                System.out.println("Error : " + e);
            }
        }
        finally{

            try{

                if(Writer != null) Writer.close();
                if(Reader != null) Reader.close();
            }
            catch(Exception e){

                System.out.println("Error while closing resources." + e);
            }
        }
    }
}