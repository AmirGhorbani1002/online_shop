package repository;

import config.DBConfig;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RadioRepositoryImpl {

    public void save(boolean cdPlayer, boolean cassettePlayer, boolean flashPlayer, int id){
        String query = """
                    insert into radio(is_cd_player, is_cassette_player, is_flash_player, product_id)
                    values (?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
            preparedStatement.setBoolean(1,cdPlayer);
            preparedStatement.setBoolean(2,cassettePlayer);
            preparedStatement.setBoolean(3,flashPlayer);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
