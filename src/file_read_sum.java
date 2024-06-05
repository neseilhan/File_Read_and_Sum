import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class file_read_sum {
    public static void main(String[] args) throws IOException{
        File sum = new File("numbers.txt");

        if(sum.exists()){
            System.out.println("Dosya mevcut.");
        }
        else{
            sum.createNewFile();
            System.out.println("Dosya olusturuldu.");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("numbers.txt"))) {
            bw.write("5 \n10 \n20 \n30 \n40 "); //satir satir okudugu icin her satirda 1 sayi olmali.
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            List<Integer> numbers = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                try{
                    int sayi = Integer.parseInt(line.trim()); //parseInt ile veri dönüstürülmesi
                    numbers.add(sayi);
                }
                catch(NumberFormatException e){
                    System.out.println("Veri tipi hatasi.");
                    e.printStackTrace();
                }
            }
            int toplam = 0; //listedeki verilerin toplanmasi.
            for (int sayi : numbers) {
                toplam += sayi;
            }
            System.out.println("Toplam : "+toplam);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
