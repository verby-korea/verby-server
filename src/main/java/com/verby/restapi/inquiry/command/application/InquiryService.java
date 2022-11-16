package com.verby.restapi.inquiry.command.application;

import com.verby.restapi.inquiry.command.domain.Inquiry;
import com.verby.restapi.inquiry.command.domain.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public CreatedInquiryInfo create(InquiryRequest request) {
        Inquiry inquiry = new Inquiry(request.getUserId(), request.getTitle(), request.getContent());
        inquiryRepository.save(inquiry);
        return CreatedInquiryInfo.from(inquiry);
    }
}
