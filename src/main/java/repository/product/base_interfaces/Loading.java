package repository.product.base_interfaces;

import java.util.List;

public interface Loading<T> {

    T load(int productId);
    List<T> loadAllForSeller(int sellerId);
    List<T> loadAllForCustomer();

}
