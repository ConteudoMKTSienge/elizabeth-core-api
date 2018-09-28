package com.elizabeth.core.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tracking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fingerprintId;
	private Map<String, String> metadata;
	private List<BreadCrumb> breadCrumbs;

}
