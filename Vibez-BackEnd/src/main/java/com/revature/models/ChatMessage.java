package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
//This model contains everything needed for the User Chat functionality.
@Entity
@Table(name="ChatMessage")
@Data
public class ChatMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String message;

	public ChatMessage(String username, String message) {
		super();
		this.username = username;
		this.message = message;
	}
}