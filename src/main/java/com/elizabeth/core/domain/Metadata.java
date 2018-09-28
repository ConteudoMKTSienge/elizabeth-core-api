package com.elizabeth.core.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Metadata implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String key;
	private String value;

}
