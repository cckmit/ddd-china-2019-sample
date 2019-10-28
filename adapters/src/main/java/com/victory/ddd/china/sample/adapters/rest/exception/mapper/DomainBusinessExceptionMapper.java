package com.victory.ddd.china.sample.adapters.rest.exception.mapper;

import com.victory.ddd.china.sample.application.build.block.ApplicationException;
import com.victory.ddd.china.sample.domain.build.block.DomainBusinessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DomainBusinessExceptionMapper implements ExceptionMapper<DomainBusinessException> {
    @Override
    public Response toResponse(DomainBusinessException exception) {
        return ErrorResponseEntity.buildResponse(exception);
    }

}


