package repository.product.electronic_appliances.interfaces;

public interface RadioRepository {

    void save(boolean cdPlayer, boolean cassettePlayer, boolean flashPlayer, int id);

}
