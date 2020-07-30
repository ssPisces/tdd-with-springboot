package com.essContext.domain.service;

import com.essContext.BaseTest;
import com.essContext.Exception.ServiceException;
import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ctrl + alt + insert 快速创建类
 * alt + insert 快速创建方法
 *
 */
public class LegalPersonServiceTest extends BaseTest {

    @Autowired
    LegalPersonService legalPersonService;

    @Test
    @Tag("法人注册")
    public void should_return_success_when_register_given_legalPerson_info() {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("1111");
        legalPersonRequest.setType("1");
        legalPersonRequest.setIdType("01");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertTrue(legalPerson.getId().length() > 0);
    }

    @Test
    void should_return_failed_when_register_given_wrong_legalType(){
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("1111");
        legalPersonRequest.setType("4");
        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertNull(legalPerson);
    }

    @Test
    void should_return_failed_when_register_given_wrong_certType() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("1111");
        legalPersonRequest.setType("3");
        legalPersonRequest.setIdType("00");
        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertNull(legalPerson);
    }

    @Test
    void should_return_failed_when_register_repeat_given_companyCode() {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdCode("1111");
        legalPersonRequest.setType("3");
        legalPersonRequest.setIdType("01");
        legalPersonRequest.setCompanyCode("0001");
        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);
        assertNull(legalPerson);
        ServiceException exception = assertThrows(
                ServiceException.class, () -> legalPersonService.register(legalPersonRequest));
        assertTrue("100001".contains(exception.getCode()));
    }



}
