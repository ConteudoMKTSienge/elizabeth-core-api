package com.elizabeth.core.api.controllers.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionDTO {
	
	private String fingerprintId;
	private String email;
	private String name;
	private String company;
	private String job;
	private String phone;
	private List<MetadataDTO> metadata;

}
