package org.wso2.carbon.consent.mgt.endpoint;

import org.wso2.carbon.consent.mgt.endpoint.dto.*;
import org.wso2.carbon.consent.mgt.endpoint.ConsentsApiService;
import org.wso2.carbon.consent.mgt.endpoint.factories.ConsentsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import org.wso2.carbon.consent.mgt.endpoint.dto.ErrorDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.ConsentResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PiiCategoriesDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PiiCategoryListResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PIIcategoryRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.ConsentRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.ConsentAddResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurpseCategoriesDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeCategoryListResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeCategoryRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposesDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeGetResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.ConsentReceiptDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/consents")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/consents", description = "the consents API")
public class ConsentsApi  {

   private final ConsentsApiService delegate = ConsentsApiServiceFactory.getConsentsApi();

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List Consents\n", notes = "This API is used to list consent elements based on the filtered attributes.\n", response = ConsentResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsGet(@ApiParam(value = "Number of search results") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "Start index of the search") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "Subject identifier") @QueryParam("piiPrincipalId")  String piiPrincipalId,
    @ApiParam(value = "Service provider tenant domain") @QueryParam("spTenantDomain")  String spTenantDomain,
    @ApiParam(value = "Service name") @QueryParam("service")  String service,
    @ApiParam(value = "State (ACTIVE/REVOKED)") @QueryParam("state")  String state)
    {
    return delegate.consentsGet(limit,offset,piiPrincipalId,spTenantDomain,service,state);
    }
    @GET
    @Path("/pii-categories")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve all PII categories\n", notes = "This API is used to retrieve all PII categories.\n", response = PiiCategoriesDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPiiCategoriesGet(@ApiParam(value = "Number of search results") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "Start index of the search") @QueryParam("offset")  Integer offset)
    {
    return delegate.consentsPiiCategoriesGet(limit,offset);
    }
    @DELETE
    @Path("/pii-categories/{piiCategoryId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete PII category\n", notes = "This API is used to delete a PII category.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPiiCategoriesPiiCategoryIdDelete(@ApiParam(value = "Unique ID of the PII category",required=true ) @PathParam("piiCategoryId")  String piiCategoryId)
    {
    return delegate.consentsPiiCategoriesPiiCategoryIdDelete(piiCategoryId);
    }
    @GET
    @Path("/pii-categories/{piiCategoryId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve a PII category\n", notes = "This API is used to retrieve a specific PII category using the PII category ID.\n", response = PiiCategoryListResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPiiCategoriesPiiCategoryIdGet(@ApiParam(value = "Unique ID of the PII category",required=true ) @PathParam("piiCategoryId")  String piiCategoryId)
    {
    return delegate.consentsPiiCategoriesPiiCategoryIdGet(piiCategoryId);
    }
    @POST
    @Path("/pii-categories")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add PII category\n", notes = "This API is used to add a new PII category for consent management.\n", response = PiiCategoryListResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPiiCategoriesPost(@ApiParam(value = "This represents the PII catogory name." ,required=true ) PIIcategoryRequestDTO piiCategory)
    {
    return delegate.consentsPiiCategoriesPost(piiCategory);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add consent\n", notes = "This API is used to store consent information given by the user.\n", response = ConsentAddResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPost(@ApiParam(value = "This represents the consent element that needs to be stored." ,required=true ) ConsentRequestDTO consent)
    {
    return delegate.consentsPost(consent);
    }
    @GET
    @Path("/purpose-categories")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve all purpose categories\n", notes = "This API is used to retrieve  all purpose categories.\n", response = PurpseCategoriesDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposeCategoriesGet(@ApiParam(value = "Number of search results") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "Start index of the search") @QueryParam("offset")  Integer offset)
    {
    return delegate.consentsPurposeCategoriesGet(limit,offset);
    }
    @POST
    @Path("/purpose-categories")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add purpose category\n", notes = "This API is used to add a new purpose category for consent management.\n", response = PurposeCategoryListResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposeCategoriesPost(@ApiParam(value = "This represents the purpose category name." ,required=true ) PurposeCategoryRequestDTO purposeCategory)
    {
    return delegate.consentsPurposeCategoriesPost(purposeCategory);
    }
    @DELETE
    @Path("/purpose-categories/{purposeCategoryId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete purpose category\n", notes = "This API is used to delete a purpose category.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposeCategoriesPurposeCategoryIdDelete(@ApiParam(value = "Unique ID of the purpose category",required=true ) @PathParam("purposeCategoryId")  String purposeCategoryId)
    {
    return delegate.consentsPurposeCategoriesPurposeCategoryIdDelete(purposeCategoryId);
    }
    @GET
    @Path("/purpose-categories/{purposeCategoryId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve a purpose category\n", notes = "This API is used to retrieve a purpose category using the purpose category ID.\n", response = PurposeCategoryListResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposeCategoriesPurposeCategoryIdGet(@ApiParam(value = "Unique ID of the purpose category",required=true ) @PathParam("purposeCategoryId")  String purposeCategoryId)
    {
    return delegate.consentsPurposeCategoriesPurposeCategoryIdGet(purposeCategoryId);
    }
    @GET
    @Path("/purposes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve all purposes\n", notes = "This API is used to retrieve all purposes.\n", response = PurposesDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposesGet(@ApiParam(value = "Purpose group") @QueryParam("group")  String group,
    @ApiParam(value = "Type of the purpose group") @QueryParam("groupType")  String groupType,
    @ApiParam(value = "Number of search results") @QueryParam("limit")  Integer limit,
    @ApiParam(value = "Start index of the search") @QueryParam("offset")  Integer offset)
    {
    return delegate.consentsPurposesGet(group,groupType,limit,offset);
    }
    @POST
    @Path("/purposes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add purpose\n", notes = "This API is used to add a new purpose for consent management.\n", response = PurposeGetResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Conflict"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposesPost(@ApiParam(value = "This represents the purpose element that needs to be stored." ,required=true ) PurposeRequestDTO purpose)
    {
    return delegate.consentsPurposesPost(purpose);
    }
    @DELETE
    @Path("/purposes/{purposeId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a purpose\n", notes = "This API is used to delete a purpose.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposesPurposeIdDelete(@ApiParam(value = "Unique ID of the purpose",required=true ) @PathParam("purposeId")  String purposeId)
    {
    return delegate.consentsPurposesPurposeIdDelete(purposeId);
    }
    @GET
    @Path("/purposes/{purposeId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve a purpose\n", notes = "This API is used to retrieve a specific purpose using the purpose ID.\n", response = PurposeGetResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposesPurposeIdGet(@ApiParam(value = "Id of the purpose",required=true ) @PathParam("purposeId")  String purposeId)
    {
    return delegate.consentsPurposesPurposeIdGet(purposeId);
    }
    @PUT
    @Path("/purposes/{purposeId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a purpose\n", notes = "This API is used to update a purpose.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsPurposesPurposeIdPut(@ApiParam(value = "Unique ID of the purpose",required=true ) @PathParam("purposeId")  String purposeId,
    @ApiParam(value = "This represents the purpose element that needs to be updated." ,required=true ) PurposeRequestDTO purpose)
    {
    return delegate.consentsPurposesPurposeIdPut(purposeId,purpose);
    }
    @DELETE
    @Path("/receipts/{receiptId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Revoke consent\n", notes = "This API is used to revoke consent.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsReceiptsReceiptIdDelete(@ApiParam(value = "This represents the Revoke Receipt ID.",required=true ) @PathParam("receiptId")  String receiptId)
    {
    return delegate.consentsReceiptsReceiptIdDelete(receiptId);
    }
    @GET
    @Path("/receipts/{receiptId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve a consent receipt\n", notes = "This API is used to retrieve consent using the conset receipt ID.\n", response = ConsentReceiptDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Server Error") })

    public Response consentsReceiptsReceiptIdGet(@ApiParam(value = "The unique identifier of a receipt",required=true ) @PathParam("receiptId")  String receiptId)
    {
    return delegate.consentsReceiptsReceiptIdGet(receiptId);
    }
}

