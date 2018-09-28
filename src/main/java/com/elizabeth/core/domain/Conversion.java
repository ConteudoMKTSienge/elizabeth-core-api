package com.elizabeth.core.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Conversion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fingerprintId;
	private String email;
	private String name;
	private String company;
	private String job;
	private String phone;
	private List<Metadata> metadata;

}
