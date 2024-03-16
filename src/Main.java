import bankSystem.scanner.ScannerSingleton;

public class Main {
    public static void main(String[] args) {
        boolean t = true;
        while (t) {
            System.out.println("__ورود به سیستم__");
            System.out.println("شماره حساب را وارد کنید.");
            Long numberAccount = ScannerSingleton.getScanner().nextLong();
            System.out.println("رمز عبور:");
            Integer pass = ScannerSingleton.getScanner().nextInt();
            int user = ScannerSingleton.getScanner().nextInt();
            if (numberAccount == null || pass == null) {
                System.err.println("مقادیر را وارد کنید.");
                Long numberAccount1 = ScannerSingleton.getScanner().nextLong();
                int user1 = ScannerSingleton.getScanner().nextInt();
            } else {
                System.out.println("menu");
            }
            switch (user) {
                case 1:

                    break;
            }
        }



    }
}