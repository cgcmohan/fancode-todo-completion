package com.fancode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
public class User {
	private int id;
	private String name;
	private Address address;
	@Getter
	public static class Address {
		private Geo geo;
		@Getter
		public static class Geo {
			private String lat;
			private String lng;

			// Getters and Setters
		}
	}
}
