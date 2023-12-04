// RoomDAOImpl.java
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Room;

public class RoomDAOImpl implements RoomDAO {
    private static final String SELECT_ROOM_BY_ID = "SELECT * FROM room WHERE id=?";
    private static final String SELECT_ALL_ROOMS = "SELECT * FROM room";
    private static final String INSERT_ROOM = "INSERT INTO room (room_type) VALUES (?)";
    private static final String UPDATE_ROOM = "UPDATE room SET room_type=? WHERE id=?";
    private static final String DELETE_ROOM = "DELETE FROM room WHERE id=?";

    @Override
    public Room getRoom(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Room(resultSet.getInt("id"), resultSet.getString("room_type"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                rooms.add(new Room(resultSet.getInt("id"), resultSet.getString("room_type")));
            }
        } catch (SQLException e) {
        }

        return rooms;
    }

    @Override
    public void addRoom(Room room) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM)) {
            preparedStatement.setString(1, room.getRoomType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void updateRoom(Room room) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM)) {
            preparedStatement.setString(1, room.getRoomType());
            preparedStatement.setInt(2, room.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void deleteRoom(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROOM)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
