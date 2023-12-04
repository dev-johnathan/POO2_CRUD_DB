/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author johna
 */

import java.util.List;
import model.Room;

public interface RoomDAO {
    Room getRoom(int id);
    List<Room> getAllRooms();
    void addRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(int id);
}
