/*
 *
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.consent.mgt.endpoint.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.consent.mgt.core.exception.ConsentManagementClientException;
import org.wso2.carbon.consent.mgt.core.exception.ConsentManagementException;
import org.wso2.carbon.consent.mgt.core.model.PIICategory;
import org.wso2.carbon.consent.mgt.core.model.Purpose;
import org.wso2.carbon.consent.mgt.core.model.PurposeCategory;
import org.wso2.carbon.consent.mgt.core.model.ReceiptInput;
import org.wso2.carbon.consent.mgt.endpoint.ApiResponseMessage;
import org.wso2.carbon.consent.mgt.endpoint.ConsentsApiService;
import org.wso2.carbon.consent.mgt.endpoint.dto.ConsentRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PIIcategoryRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PiiCategoryListResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeCategoryListResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeCategoryRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeListResponseDTO;
import org.wso2.carbon.consent.mgt.endpoint.dto.PurposeRequestDTO;
import org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.core.Response;

import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.ErrorMessages.ERROR_CODE_PII_CATEGORY_ALREADY_EXIST;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.ErrorMessages.ERROR_CODE_PII_CATEGORY_ID_INVALID;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.ErrorMessages.ERROR_CODE_PURPOSE_ALREADY_EXIST;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.ErrorMessages.ERROR_CODE_PURPOSE_CATEGORY_ALREADY_EXIST;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.ErrorMessages.ERROR_CODE_PURPOSE_CATEGORY_ID_INVALID;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.ErrorMessages.ERROR_CODE_PURPOSE_ID_INVALID;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.ErrorMessages.ERROR_CODE_UNEXPECTED;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.PII_CATEGORY_RESOURCE_PATH;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.PURPOSE_CATEGORY_RESOURCE_PATH;
import static org.wso2.carbon.consent.mgt.core.constant.ConsentConstants.PURPOSE_RESOURCE_PATH;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getConsentManager;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPIICategoryRequest;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPiiCategoryListResponse;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPiiCategoryResponseDTOList;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPurposeCategoryListResponse;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPurposeCategoryRequest;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPurposeCategoryResponseDTOList;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPurposeListResponse;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPurposeRequest;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getPurposeResponseDTOList;
import static org.wso2.carbon.consent.mgt.endpoint.util.ConsentEndpointUtils.getReceiptInput;

public class ConsentsApiServiceImpl extends ConsentsApiService {

    private static final Log LOG = LogFactory.getLog(ConsentsApiServiceImpl.class);

    @Override
    public Response consentsGet(Integer limit, Integer offset, String piiPrincipalId, String spTenantDomain,
                                String service, String state, String collectionMethod, String piiCategoryId) {
        return null;
    }

    @Override
    public Response consentsPiiCategoriesGet(Integer limit, Integer offset) {
        try {
            List<PiiCategoryListResponseDTO> purposeCategoryListResponseDTO = getPiiCategoryListResponseDTO(
                    limit, offset);
            return Response.ok().entity(purposeCategoryListResponseDTO).build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPiiCategoriesPiiCategoryIdDelete(String piiCategoryId) {
        try {
            getConsentManager().deletePIICategory(Integer.parseInt(piiCategoryId));
            return Response.ok().build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPiiCategoriesPiiCategoryIdGet(String piiCategoryId) {
        try {
            PIICategory piiCategory = getConsentManager().getPIICategory(Integer.parseInt(piiCategoryId));
            PiiCategoryListResponseDTO purposeCategoryList = getPiiCategoryListResponse(piiCategory);
            return Response.ok().entity(purposeCategoryList).build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPiiCategoriesPost(PIIcategoryRequestDTO piiCategory) {
        try {
            PiiCategoryListResponseDTO response = addPIICategory(piiCategory);
            return Response.ok()
                    .entity(response)
                    .location(getPiiCategoryLocationURI(response))
                    .build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPost(ConsentRequestDTO consent) {
        ReceiptInput receiptInput = getReceiptInput(consent);
        try {
            getConsentManager().addConsent(receiptInput);
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response consentsPurposeCategoriesGet(Integer limit, Integer offset) {
        try {
            List<PurposeCategoryListResponseDTO> purposeCategoryListResponseDTOS = getPurposeCategoryListResponseDTO(
                    limit, offset);
            return Response.ok().entity(purposeCategoryListResponseDTOS).build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPurposeCategoriesPost(PurposeCategoryRequestDTO purposeCategory) {
        try {
            PurposeCategoryListResponseDTO response = addPurposeCategory(purposeCategory);
            return Response.ok()
                    .entity(response)
                    .location(getPurposeCategoryLocationURI(response))
                    .build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPurposeCategoriesPurposeCategoryIdDelete(String purposeCategoryId) {
        try {
            getConsentManager().deletePurposeCategory(Integer.parseInt(purposeCategoryId));
            return Response.ok().build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPurposeCategoriesPurposeCategoryIdGet(String purposeCategoryId) {
        try {
            PurposeCategory purposeCategory = getConsentManager().getPurposeCategory(Integer.parseInt(purposeCategoryId));
            PurposeCategoryListResponseDTO purposeCategoryList = getPurposeCategoryListResponse(purposeCategory);
            return Response.ok().entity(purposeCategoryList).build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPurposesGet(Integer limit, Integer offset) {
        try {
            List<PurposeListResponseDTO> purposeListResponseDTOS = getPurposeListResponseDTO(limit, offset);
            return Response.ok().entity(purposeListResponseDTOS).build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPurposesPost(PurposeRequestDTO purpose) {
        try {
            PurposeListResponseDTO response = addPurpose(purpose);
            return Response.ok()
                    .entity(response)
                    .location(getPurposeLocationURI(response))
                    .build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPurposesPurposeIdDelete(String purposeId) {
        try {
            getConsentManager().deletePurpose(Integer.parseInt(purposeId));
            return Response.ok().build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsPurposesPurposeIdGet(String purposeId) {
        try {
            Purpose purpose = getConsentManager().getPurpose(Integer.parseInt(purposeId));
            PurposeListResponseDTO purposeListResponse = getPurposeListResponse(purpose);
            return Response.ok().entity(purposeListResponse).build();
        } catch (ConsentManagementClientException e) {
            return handleBadRequestResponse(e);
        } catch (ConsentManagementException e) {
            return handleServerErrorResponse(e);
        } catch (Throwable throwable) {
            return handleUnexpectedServerError(throwable);
        }
    }

    @Override
    public Response consentsReceiptsReceiptIdDelete(String receiptId) {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response consentsReceiptsReceiptIdGet(String receiptId) {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    private Response handleBadRequestResponse(ConsentManagementClientException e) {

        if (isConflictError(e)) {
            throw ConsentEndpointUtils.buildConflictRequestException(e.getMessage(), e.getErrorCode(), LOG, e);
        }

        if (isNotFoundError(e)) {
            throw ConsentEndpointUtils.buildNotFoundRequestException(e.getMessage(), e.getErrorCode(), LOG, e);
        }
        throw ConsentEndpointUtils.buildBadRequestException(e.getMessage(), e.getErrorCode(), LOG, e);
    }

    private boolean isNotFoundError(ConsentManagementClientException e) {
        return ERROR_CODE_PURPOSE_ID_INVALID.getCode().equals(e.getErrorCode())
                || ERROR_CODE_PURPOSE_CATEGORY_ID_INVALID.getCode().equals(e.getErrorCode())
                || ERROR_CODE_PII_CATEGORY_ID_INVALID.getCode().equals(e.getErrorCode());
    }

    private boolean isConflictError(ConsentManagementClientException e) {
        return ERROR_CODE_PURPOSE_ALREADY_EXIST.getCode().equals(e.getErrorCode()) ||
                ERROR_CODE_PURPOSE_CATEGORY_ALREADY_EXIST.getCode().equals(e.getErrorCode()) ||
                ERROR_CODE_PII_CATEGORY_ALREADY_EXIST.getCode().equals(e.getErrorCode());
    }

    private List<PurposeListResponseDTO> getPurposeListResponseDTO(Integer limit, Integer offset)
            throws ConsentManagementException {

        if (limit == null) {
            limit = 0;
        }

        if (offset == null) {
            offset = 0;
        }
        List<Purpose> purposes = getConsentManager().listPurposes(limit, offset);
        return getPurposeResponseDTOList(purposes);
    }

    private List<PurposeCategoryListResponseDTO> getPurposeCategoryListResponseDTO(Integer limit, Integer offset)
            throws ConsentManagementException {

        if (limit == null) {
            limit = 0;
        }

        if (offset == null) {
            offset = 0;
        }

        List<PurposeCategory> purposeCategories = getConsentManager().listPurposeCategories(limit, offset);
        return getPurposeCategoryResponseDTOList(purposeCategories);
    }

    private List<PiiCategoryListResponseDTO> getPiiCategoryListResponseDTO(Integer limit, Integer offset)
            throws ConsentManagementException {

        if (limit == null) {
            limit = 0;
        }

        if (offset == null) {
            offset = 0;
        }

        List<PIICategory> purposeCategories = getConsentManager().listPIICategories(limit, offset);
        return getPiiCategoryResponseDTOList(purposeCategories);
    }


    private Response handleServerErrorResponse(ConsentManagementException e) {
        throw ConsentEndpointUtils.buildInternalServerErrorException(e.getErrorCode(), LOG, e);
    }

    private Response handleUnexpectedServerError(Throwable e) {
        throw ConsentEndpointUtils.buildInternalServerErrorException(ERROR_CODE_UNEXPECTED.getCode(), LOG, e);
    }


    private PurposeListResponseDTO addPurpose(PurposeRequestDTO purpose) throws ConsentManagementException {
        Purpose purposeRequest = getPurposeRequest(purpose);
        Purpose purposeResponse = getConsentManager().addPurpose(purposeRequest);
        return getPurposeListResponse(purposeResponse);
    }

    private PurposeCategoryListResponseDTO addPurposeCategory(PurposeCategoryRequestDTO purposeCategoryRequestDTO)
            throws ConsentManagementException {
        PurposeCategory purposeRequest = getPurposeCategoryRequest(purposeCategoryRequestDTO);
        PurposeCategory purposeResponse = getConsentManager().addPurposeCategory(purposeRequest);
        return getPurposeCategoryListResponse(purposeResponse);
    }

    private PiiCategoryListResponseDTO addPIICategory(PIIcategoryRequestDTO purposeCategoryRequestDTO)
            throws ConsentManagementException {
        PIICategory piiCategory = getPIICategoryRequest(purposeCategoryRequestDTO);
        PIICategory purposeResponse = getConsentManager().addPIICategory(piiCategory);
        return getPiiCategoryListResponse(purposeResponse);
    }

    private URI getPurposeLocationURI(PurposeListResponseDTO response) throws URISyntaxException {
        return new URI(PURPOSE_RESOURCE_PATH + "/" + response.getPurposeId());
    }

    private URI getPurposeCategoryLocationURI(PurposeCategoryListResponseDTO response) throws URISyntaxException {
        return new URI(PURPOSE_CATEGORY_RESOURCE_PATH + "/" + response.getPurposeCategoryId());
    }

    private URI getPiiCategoryLocationURI(PiiCategoryListResponseDTO response) throws URISyntaxException {
        return new URI(PII_CATEGORY_RESOURCE_PATH + "/" + response.getPiiCategoryId());
    }
}
