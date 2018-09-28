package com.elizabeth.core.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository repository;
	
	@Autowired
	private EventProducer eventProducer;

	@Override
	public void register(Conversion conversion) {
		Lead lead = null;
		
		if (conversion.getEmail() != null && !conversion.getEmail().isEmpty()) {
			lead = repository.findByEmail(conversion.getEmail());
		} else {
			lead = repository.findByFingerprintId(conversion.getFingerprintId());
		}
		
		if (lead == null) {
			lead = convertToLead(conversion);
		} else {
			if (lead.getFingerprintId() != null && !lead.getFingerprintId().equals(conversion.getFingerprintId())) {
				Lead anonymousLead = repository.findByFingerprintId(conversion.getFingerprintId());
				lead = merge(lead, anonymousLead);
			}
			
			lead = updateLead(lead, conversion);
		}
		
		lead.addConversion(conversion);
		
		Lead savedLead = repository.save(lead);
		eventProducer.send(savedLead);
	}

	private Lead updateLead(Lead lead, Conversion conversion) {
		// TODO check fields and update
		return lead;
	}

	private Lead convertToLead(Conversion conversion) {
		return Lead.builder()
				.fingerprintId(conversion.getFingerprintId())
				.email(conversion.getEmail())
				.name(conversion.getName())
				.company(conversion.getCompany())
				.job(conversion.getJob())
				.phone(conversion.getPhone())
				.metadata(conversion.getMetadata())
				.trackings(new ArrayList<>())
				.conversions(new ArrayList<>())
				.build();
	}

	private Lead merge(Lead lead, Lead anonymousLead) {
		return lead;
	}
}
