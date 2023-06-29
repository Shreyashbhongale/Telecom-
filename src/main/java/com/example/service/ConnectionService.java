package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Connection;
import com.example.repository.ConnectionRepository;

@Service
public class ConnectionService {

	@Autowired
	ConnectionRepository connectionRepository;

	public Connection saveConnection(Connection con) {
		con.setCon_id(UUID.randomUUID().toString());
		Connection Createdconnection_id = connectionRepository.save(con);

		return connectionRepository.save(con);
	}

	public List<Connection> getAllConnection() {

		return connectionRepository.findAll();

	}

	public Connection getByID(String Connection_id) {

		Optional<Connection> con = connectionRepository.findById(Connection_id);

		if (con.isPresent()) {
			return con.get();
		} else
			return null;
	}

	public void deleteConnection(String Connection_id) {

		connectionRepository.deleteById(Connection_id);

	}

	public Connection updateConnection(String con_id, Connection newEntity) {
		Connection availableEntity = connectionRepository.findById(con_id).get();

		if (availableEntity != null) {
			if (newEntity.getCon_id() != null) {
				availableEntity.setCon_id(newEntity.getCon_id());
			}
			if (newEntity.getCon_name() != null) {
				availableEntity.setCon_name(newEntity.getCon_name());
			}
			if (newEntity.getCon_status() != null) {
				availableEntity.setCon_status(newEntity.getCon_status());
			}
			if (newEntity.getCon_plan() != null) {
				availableEntity.setCon_plan(newEntity.getCon_plan());
			}
			if (newEntity.getCon_ref_no() > 0) {
				availableEntity.setCon_ref_no(newEntity.getCon_ref_no());
			}
			return connectionRepository.save(availableEntity);
		}else {
			return null;
		}	
	}
		
}
