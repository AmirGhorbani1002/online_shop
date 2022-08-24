package repository.product.electronic_appliances;

import config.DBConfig;
import entity.product.Radio;
import repository.product.base_interfaces.Loading;
import repository.product.electronic_appliances.interfaces.RadioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RadioRepositoryImpl implements Loading<Radio>, RadioRepository {

    @Override
    public void save(boolean cdPlayer, boolean cassettePlayer, boolean flashPlayer, int id) {
        String query = """
                    insert into radio(is_cd_player, is_cassette_player, is_flash_player, product_id)
                    values (?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setBoolean(1, cdPlayer);
            preparedStatement.setBoolean(2, cassettePlayer);
            preparedStatement.setBoolean(3, flashPlayer);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Radio load(int productId){
        String query = """
                    select * from radio
                    inner join product p on p.id = radio.product_id
                    where product_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;
            return getRadio(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Radio> loadAllForSeller(int sellerId) {
        List<Radio> radios = new ArrayList<>();
        String query = """
                     select * from radio
                     inner join product p on p.id = radio.product_id
                     where seller_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, sellerId);
            return getRadios(radios, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Radio> loadAllForCustomer() {
        List<Radio> radios = new ArrayList<>();
        String query = """
                     select * from radio
                     inner join product p on p.id = radio.product_id
                     where seller_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            return getRadios(radios, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Radio getRadio(ResultSet resultSet) throws SQLException {
        Radio radio = new Radio(resultSet.getInt("seller_id"),
                resultSet.getString("description"), resultSet.getInt("quantity"),
                resultSet.getFloat("price"), resultSet.getBoolean("is_cd_player"),
                resultSet.getBoolean("is_cassette_player"),
                resultSet.getBoolean("is_flash_player"));
        radio.setId(resultSet.getInt("product_id"));
        return radio;
    }
    private List<Radio> getRadios(List<Radio> radios, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            radios.add(getRadio(resultSet));
        }
        return radios;
    }

}
