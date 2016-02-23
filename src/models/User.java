package models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import shiro.ShiroPasswordManager;

public class User {

	private HashMap<String, String> info;

	public User() {
		this.info = new HashMap<String, String>();
	}

	public void setInfo(String key, String value) {
		this.info.put(key, value);
	}

	public String getInfo(String key) {
		return this.info.get(key);
	}

	public String getId() {
		return this.info.get("id");
	}

	public String getRole() {
		return this.info.get("role");
	}

	public String getIdNum() {
		return this.info.get("id_num");
	}

	public String getName() {
		return this.info.get("name");
	}

	public String getDateTimeJoined() {
		return this.info.get("datetime_joined");
	}

}
