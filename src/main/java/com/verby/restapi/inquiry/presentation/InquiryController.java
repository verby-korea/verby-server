package com.verby.restapi.inquiry.presentation;


import com.verby.restapi.config.security.SecurityUser;
import com.verby.restapi.inquiry.command.application.CreatedInquiryInfo;
import com.verby.restapi.inquiry.command.application.InquiryRequest;
import com.verby.restapi.inquiry.command.application.InquiryService;
import com.verby.restapi.inquiry.query.dao.InquiryDataDao;
import com.verby.restapi.inquiry.query.dto.InquiryData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inquiries")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;
    private final InquiryDataDao inquiryDataDao;

    @PostMapping
    private ResponseEntity<CreatedInquiryInfo> create(@AuthenticationPrincipal SecurityUser user, @RequestBody @Valid InquiryRequest request) {
        request.setUserId(user.getUserId());
        CreatedInquiryInfo inquiry = inquiryService.create(request);
        return new ResponseEntity<>(inquiry, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<InquiryData>> findAll(@AuthenticationPrincipal SecurityUser user) {
        List<InquiryData> inquiries = inquiryDataDao.findByInquirerId(user.getUserId());
        return new ResponseEntity<>(inquiries, HttpStatus.OK);
    }

}
