package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.application.query.ProfilePublicRepresentationQueryModel;
import com.victory.ddd.china.sample.application.usecase.profile.QueryPublicRepresentationUseCase;
import lombok.val;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.Optional;

@RequestScoped
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
    @Context
    SecurityContext securityContext;


    private final QueryPublicRepresentationUseCase queryPublicRepresentationUseCase;

    @Autowired
    public ProfileResource(final QueryPublicRepresentationUseCase queryPublicRepresentationUseCase) {
        this.queryPublicRepresentationUseCase = queryPublicRepresentationUseCase;
    }

    @GET
    @Path("/{username}")
    @Produces("application/json")
    public ProfilePublicRepresentationQueryModel get(@PathParam("username") String userName){
        final Optional<String> currentUser = securityContext.getUserPrincipal() != null ?
                Optional.of(securityContext.getUserPrincipal().getName()) :
                Optional.empty();
        return this.queryPublicRepresentationUseCase.get(userName, currentUser);
    }
}
