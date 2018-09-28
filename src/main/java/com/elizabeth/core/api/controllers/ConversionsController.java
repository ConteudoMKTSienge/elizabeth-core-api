package com.elizabeth.core.api.controllers;

import static java.util.stream.Collectors.toList;

import com.elizabeth.core.api.controllers.dto.ConversionDTO;
import com.elizabeth.core.api.controllers.dto.MetadataDTO;
import com.elizabeth.core.domain.Conversion;
import com.elizabeth.core.domain.Metadata;
import com.elizabeth.core.domain.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/conversions")
@RestController
public class ConversionsController {
	
	@Autowired
	private LeadService service;

	@PostMapping
	public void conversions(@RequestBody ConversionDTO dto) {
		service.register(toDomain(dto));
	}
	
	public Conversion toDomain(ConversionDTO dto) {
		return Conversion.builder()
			.fingerprintId(dto.getFingerprintId())
			.email(dto.getEmail())
			.name(dto.getName())
			.company(dto.getCompany())
			.job(dto.getJob())
			.phone(dto.getPhone())
			.metadata(dto.getMetadata().stream().map(m -> toMetadataDomain(m)).collect(toList()))
			.build();
	}
	
	public Metadata toMetadataDomain(MetadataDTO dto) {
		return Metadata.builder()
				.key(dto.getKey())
				.value(dto.getValue())
				.build();
	}

}
