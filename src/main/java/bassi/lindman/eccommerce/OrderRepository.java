package bassi.lindman.eccommerce;

public interface OrderRepository {
    void save(Order order);
    Order findById(int id);
}
