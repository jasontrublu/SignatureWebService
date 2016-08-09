package de.trublu.signature.Rest;

import de.trublu.signature.Rest.response.SignatureResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class SignatureResource {

    @GET
    @Path("signature")
    public SignatureResponse getSignature() {
        return new SignatureResponse("-- \na .signature");
    }
}
