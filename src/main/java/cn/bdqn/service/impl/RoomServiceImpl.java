package cn.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mapper.RoomMapper;
import cn.bdqn.pojo.Room;
import cn.bdqn.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomMapper room;

	@Override
	public List<Room> getAllRoom() {
		List<Room> allRoom = room.getAllRoom();
		return allRoom;
	}

}
