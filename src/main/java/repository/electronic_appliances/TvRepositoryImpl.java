package repository.electronic_appliances;

import config.DBConfig;
import entity.enums.product.tv.DisplayType;
import entity.product.Product;
import entity.product.Tv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class TvRepositoryImpl {

    public void save(int inch, DisplayType displayType, int id) {
        String query = """
                    insert into tv(display_type, inch, product_id)
                    values (?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setObject(1, displayType, Types.OTHER);
            preparedStatement.setInt(2, inch);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Tv> load(int sellerId) {
        List<Tv> tvs = new ArrayList<>();
        String query = """
                    select * from tv
                    inner join product p on p.id = tv.product_id
                    where seller_id = ?
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, sellerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tv tv = new Tv(resultSet.getInt("seller_id"), resultSet.getString("description"),
                        resultSet.getInt("quantity"), resultSet.getFloat("price"),
                        resultSet.getInt("inch"),
                        DisplayType.valueOf(resultSet.getString("display_type")));
                tv.setId(resultSet.getInt("product_id"));
                tvs.add(tv);
            }
            return tvs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
