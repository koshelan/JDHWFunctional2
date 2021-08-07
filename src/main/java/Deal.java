public class Deal {
    final int width;
    final int length;
    final int price;

    public Deal(int width, int length, int price) {
        this.width = width;
        this.length = length;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getArea() {
        return width * length;
    }

    public float getPriceForMeter() {
        return (float) price / getArea();
    }

    @Override
    public String toString() {
        return String.format("Deal{ width= %d, length= %d, price= %d } = %.2f"
                , width, length, price, getPriceForMeter());
    }
}
