package repository;

import config.DBConfig;
import entity.enums.product.tv.DisplayType;
import entity.product.Tv;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class TvRepositoryImpl {

    public void save(int inch, DisplayType displayType, int id){
        String query = """
                    insert into tv(display_type, inch, product_id)
                    values (?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setObject(1,displayType, Types.OTHER);
            preparedStatement.setInt(2,inch);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
