import java.util.Scanner;

public class Main {
    public static int earnings = 0;
    public static int spendings = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int money = Integer.parseInt(scanner.nextLine());
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    int moneySpending = Integer.parseInt(scanner.nextLine());
                    spendings += moneySpending;
                    break;
                case 3:
                    int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings,spendings);
                    int taxEarnings = taxEarnings(earnings);
                    if(taxEarnings<taxEarningsMinusSpendings){
                        System.out.println("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: " +taxEarnings + " рублей\n" +
                                "Налог на другой системе: " +taxEarningsMinusSpendings + " рублей\n" +
                                "Экономия: " + (taxEarningsMinusSpendings-taxEarnings) + " рублей");
                    }else if(taxEarnings>taxEarningsMinusSpendings){
                        System.out.println("Мы советуем вам УСН доходы минус расходы\n" +
                                "Ваш налог составит: " +taxEarningsMinusSpendings + " рублей\n" +
                                "Налог на другой системе: " +taxEarnings + " рублей\n" +
                                "Экономия: " + (taxEarnings-taxEarningsMinusSpendings) + " рублей");
                    }else{
                        System.out.println("Можете выбрать любую систему налогообложения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");

    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }




}