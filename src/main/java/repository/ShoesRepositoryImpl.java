package repository;

import config.DBConfig;
import entity.enums.product.shoes.Color;
import entity.enums.product.shoes.ShoesType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

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

}
