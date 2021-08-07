import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    final static Random random = new Random();

    private static final int QUANTITY = 10;
    private static final int MAX_PRICE = 1_000_000;
    private static final int MAX_SIZE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BiFunction<Float, Float, Boolean> honesty = (a, b) -> a <= b;

        System.out.println("Введите контрольную цену за квадратный метр");
        float control = scanner.nextFloat();
        List<Deal> deals = generate(QUANTITY, MAX_PRICE, MAX_SIZE);
        System.out.println("Сделки за день:");
        deals.forEach(d -> System.out.println(d + " честность: " + honesty.apply(control, d.getPriceForMeter())));

    }



    private static List<Deal> generate(int quantity, int maxPrice, int maxSize) {
        return random.ints(quantity, maxPrice).limit(quantity)
                .mapToObj(p -> new Deal(random.nextInt(maxSize), random.nextInt(maxSize), p))
                .collect(Collectors.toList());
    }
}
