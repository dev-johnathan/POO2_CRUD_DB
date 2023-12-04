// RoomController.java
package controller;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import java.util.List;
import model.Room;

public class RoomController {
    private final RoomDAO roomDAO;

    public RoomController() {
        this.roomDAO = new RoomDAOImpl();
    }

    public Room getRoom(int id) {
        return roomDAO.getRoom(id);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public void addRoom(Room room) {
        roomDAO.addRoom(room);
    }

    public void updateRoom(Room room) {
        roomDAO.updateRoom(room);
    }

    public void deleteRoom(int id) {
        roomDAO.deleteRoom(id);
    }
}
