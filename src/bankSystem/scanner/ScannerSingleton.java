package bankSystem.scanner;

import java.util.Scanner;

public class ScannerSingleton {

    private static Scanner scanner;

    private ScannerSingleton(){
    }

    public static Scanner getScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
            return scanner;
        }
        return scanner;
    }
}
