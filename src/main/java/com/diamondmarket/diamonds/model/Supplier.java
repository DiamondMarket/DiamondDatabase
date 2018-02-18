package com.diamondmarket.diamonds.model;

import java.util.ArrayList;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "Supplier")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Supplier {
	
	private String _id;
	private ArrayList<Diamond> diamonds;

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public ArrayList<Diamond> getDiamonds() {
		return diamonds;
	}
	public void setDiamonds(ArrayList<Diamond> diamonds) {
		this.diamonds = diamonds;
	}
	@Override
	public String toString() {
		return "Supplier [_id=" + _id + ", diamonds=" + diamonds + "]";
	}
	
	
	
}
