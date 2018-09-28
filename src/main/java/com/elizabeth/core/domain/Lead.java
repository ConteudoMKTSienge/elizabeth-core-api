package com.elizabeth.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Lead implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String fingerprintId;
	private String email;
	private String name;
	private String company;
	private String job;
	private String phone;
	private List<Metadata> metadata;
	private List<Tracking> trackings;
	private List<Conversion> conversions;
	
	public Lead() {
		metadata = new ArrayList<>();
		trackings = new ArrayList<>();
		conversions = new ArrayList<>();
	}
	
	public void addConversion(Conversion conversion) {
		conversions.add(conversion);
	}

	public void addTracking(Tracking tracking) {
		trackings.add(tracking);
	}

}
