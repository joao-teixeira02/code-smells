package pt.up.fe.ldts.example3;

public class FixedDiscount extends Discount{
    private int discount;

    FixedDiscount(int discount){
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    @Override
    public double applyDiscount(double price) {
        return price - discount;
    }
}
