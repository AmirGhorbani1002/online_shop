package repository.product.shoes;

import config.DBConfig;
import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;
import entity.product.Shoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoesRepositoryImpl {

    public void save(int[] sizes, Color color, ShoesType type, int id) {
        String query = """
                    insert into shoes(size, main_color, product_id, type)
                    values (?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setObject(1, sizes, Types.ARRAY);
            preparedStatement.setObject(2, color, Types.OTHER);
            preparedStatement.setInt(3, id);
            preparedStatement.setObject(4, type, Types.OTHER);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shoes> loadAllForSeller(int sellerId) {
        List<Shoes> shoesList = new ArrayList<>();
        String query = """
                    select * from shoes
                    inner join product p on p.id = shoes.product_id
                    where seller_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, sellerId);
            return getShoes(shoesList, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shoes> loadAllForCustomer() {
        List<Shoes> shoesList = new ArrayList<>();
        String query = """
                    select * from shoes
                    inner join product p on p.id = shoes.product_id
                    where seller_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            return getShoes(shoesList, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Shoes> getShoes(List<Shoes> shoesList, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Array ints = resultSet.getArray("size");
            List<Integer> sizes = new ArrayList<>(Arrays.asList((Integer[]) ints.getArray()));
            Shoes shoes = new Shoes(resultSet.getInt("seller_id"),
                    resultSet.getString("description"), resultSet.getInt("quantity"),
                    resultSet.getFloat("price"),
                    ShoesType.valueOf(resultSet.getString("type")),
                    Color.valueOf(resultSet.getString("main_color")));
            shoes.getSizes().addAll(0,sizes);
            shoes.setId(resultSet.getInt("product_id"));
            shoesList.add(shoes);
        }
        return shoesList;
    }

}
