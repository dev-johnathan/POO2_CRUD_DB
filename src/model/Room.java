package model;

public class Room {
    private int id;
    private String roomType;

    public Room(int id, String roomType) {
        this.id = id;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Quarto #" + id + ": " + roomType;
    }
}
