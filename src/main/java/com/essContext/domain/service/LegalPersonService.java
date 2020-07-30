package com.essContext.domain.service;

import com.essContext.Exception.ServiceException;
import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class LegalPersonService {
    @Autowired
    LegalPersonRepository legalPersonRepository;

    public LegalPerson register(LegalPersonRequest request) throws ServiceException {
        System.out.println("校验重复");
        isNotEntiRepeat(request);
        System.out.println("判断法人类型");
        if (!isNotExistLegalType(request)) return null;
        System.out.println("判断证件类型");
        if (!isNotExistIdType(request)) return null;
        System.out.println("赋值");
        LegalPerson legalPerson = copyBean(request);
        return legalPersonRepository.save(legalPerson);
    }

    private boolean isNotExistIdType(LegalPersonRequest request) {
        if ( "01".equals(request.getIdType())
            || "02".equals(request.getIdType())) {
            return true;
        }
        return false;
    }

    private Boolean isNotExistLegalType(LegalPersonRequest request) {
        if ( "1".equals(request.getType())
                || "2".equals(request.getType())
                || "3".equals(request.getType()) ){
            return true;
        }
        return false;
    }
    private void isNotEntiRepeat(LegalPersonRequest request) {
        if ("0001".equals(request.getCompanyCode())) {
            throw new ServiceException("100001", "已注册");
        }
    }

    private LegalPerson copyBean(LegalPersonRequest request) {
        return LegalPerson.builder()
                    .type(request.getType())
                    .companyName(request.getCompanyName())
                    .companyCode(request.getCompanyCode())
                    .name(request.getName())
                    .idType(request.getIdType())
                    .idCode(request.getIdCode())
                    .build();
    }
}
