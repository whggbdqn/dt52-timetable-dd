package cn.bdqn.pojo;

public class Room {
    private Integer roomId;

    private String roomName;

    private Integer roomSize;

    private Integer dr;

    
    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", roomName=" + roomName + ", roomSize=" + roomSize + ", dr=" + dr + "]";
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }
}