/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.consent.mgt.core.constant;

/**
 * Constants related to consent management configurations.
 */
public class ConsentConstants {

    public static final String CONSENT_MANAGEMENT_CONFIG_XML = "consent-mgt-config.xml";
    public static final String CONSENT_MANAGEMENT_DEFAULT_NAMESPACE = "http://wso2.org/carbon/consent/management";
    public static final String APPLICATION_JSON = "application/json";
    public static final String DEFAULT_RESPONSE_CONTENT_TYPE = APPLICATION_JSON;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String STATUS_INTERNAL_SERVER_ERROR_MESSAGE_DEFAULT = "Internal server error";
    public static final String STATUS_INTERNAL_SERVER_ERROR_DESCRIPTION_DEFAULT = "The server encountered "
            + "an internal error. Please contact administrator.";
    public static final String STATUS_BAD_REQUEST_MESSAGE_DEFAULT = "Bad Request";
    public static final String PURPOSE_SEARCH_LIMIT_PATH = "SearchLimits.Purpose";
    public static final String CONSENT_RESOURCE_PATH = "consents";
    public static final String PURPOSE_RESOURCE_PATH = CONSENT_RESOURCE_PATH + "/" + "purposes";
    public static final String RECEIPT_RESOURCE_PATH = CONSENT_RESOURCE_PATH + "/" + "receipts";
    public static final String PURPOSE_CATEGORY_RESOURCE_PATH = CONSENT_RESOURCE_PATH + "/" + "purpose-categories";
    public static final String PII_CATEGORY_RESOURCE_PATH = CONSENT_RESOURCE_PATH + "/" + "pii-categories";
    public static final String API_VERSION = "KI-CR-v1.1.0";
    public static final String REVOKE_STATE = "REVOKED";
    public static final String ACTIVE_STATE = "ACTIVE";

    public static final String PURPOSE = "PURPOSE";
    public static final String PURPOSE_CATEGORY = "PURPOSE_CATEGORY";
    public static final String PII_CATEGORY = "PII_CATEGORY";
    public static final String RECEIPT_ID = "RECEIPT_ID";
    public static final String PURPOSE_ID = "PURPOSE_ID";
    public static final String PURPOSE_CATEGORY_ID = "PURPOSE_CATEGORY_ID";
    public static final String PII_CATEGORY_ID = "PII_CATEGORY_ID";
    public static final String PURPOSE_NAME = "PURPOSE_NAME";
    public static final String PURPOSE_CATEGORY_NAME = "PURPOSE_CATEGORY_NAME";
    public static final String PII_CATEGORY_NAME = "PII_CATEGORY_NAME";
    public static final String LIMIT = "LIMIT";
    public static final String OFFSET = "OFFSET";
    public static final String PII_PRINCIPAL_ID = "PII_PRINCIPAL_ID";
    public static final String SP_TENANT_DOMAIN = "SP_TENANT_DOMAIN";
    public static final String PRINCIPAL_TENANT_DOMAIN = "PRINCIPAL_TENANT_DOMAIN";
    public static final String SERVICE = "SERVICE";
    public static final String STATE = "STATE";
    public static final String RECEIPT_INPUT = "RECEIPT_INPUT";
    public static final String RESULT = "RESULT";
    public static final String GROUP = "GROUP";
    public static final String GROUP_TYPE = "GROUP_TYPE";

    public static final String MY_SQL = "MySQL";
    public static final String POSTGRE_SQL = "PostgreSQL";
    public static final String DB2 = "DB2";
    public static final String MICROSOFT = "Microsoft";
    public static final String S_MICROSOFT = "microsoft";
    public static final String INFORMIX = "Informix";
    public static final String H2 = "H2";
    public static final String PERMISSION_CONSENT_MGT_VIEW = "/permission/admin/manage/identity/consentmgt/view";
    public static final String PERMISSION_CONSENT_MGT_LIST = "/permission/admin/manage/identity/consentmgt/list";
    public static final String PERMISSION_CONSENT_MGT_DELETE = "/permission/admin/manage/identity/consentmgt/delete";
    public static final String PERMISSION_CONSENT_MGT_ADD = "/permission/admin/manage/identity/consentmgt/add";
    public static final String GET_RECEIPT = "GET_RECEIPT";
    public static final String LIST_RECEIPT = "LIST_RECEIPT";
    public static final String REVOKE_RECEIPT = "REVOKE_RECEIPT";

    public enum ErrorMessages {
        ERROR_CODE_DATABASE_CONNECTION("CM_00001", "Error when getting a database connection object from the Consent" +
                " data source."),
        ERROR_CODE_DATABASE_INITIALIZATION("CM_00002", "Error while initializing the consent management data source."),
        ERROR_CODE_DATABASE_QUERY_PERFORMING("CM_00003", "Error in performing Database query: '%s.'"),
        ERROR_CODE_MORE_RECORDS_IN_QUERY("CM_00004", "There are more records than one found for query: '%s.'"),
        ERROR_CODE_AUTO_GENERATED_ID_FAILURE("CM_00005", "Creating the record failed with Auto-Generated ID, no ID " +
                "obtained."),
        ERROR_CODE_BUILDING_CONFIG("CM_00006", "Error occurred while building configuration from consent-mgt-config" +
                ".xml."),
        ERROR_CODE_ADD_PURPOSE("CM_00007", "Error occurred while adding the purpose: %s"),
        ERROR_CODE_SELECT_PURPOSE_BY_ID("CM_00008", "Error occurred while retrieving purpose from DB for the ID: %s."),
        ERROR_CODE_DELETE_PURPOSE("CM_00009", "Error occurred while deleting purpose from DB for the ID: %s."),
        ERROR_CODE_LIST_PURPOSE("CM_00010", "Error occurred while listing purpose from DB for group: %s, groupType: " +
                                            "%s limit: %s and offset: %s."),
        ERROR_CODE_ADD_PII_CATEGORY("CM_00011", "Error occurred while adding the PII category: %s to DB."),
        ERROR_CODE_SELECT_PII_CATEGORY_BY_ID("CM_00012", "Error occurred while retrieving PII category from DB for " +
                "the ID: %s."),
        ERROR_CODE_DELETE_PII_CATEGORY("CM_00013", "Error occurred while deleting PII category from DB for the ID: %s."),
        ERROR_CODE_LIST_PII_CATEGORY("CM_00014", "Error occurred while listing PII category from DB for limit: %s and" +
                " offset: %s."),
        ERROR_CODE_ADD_PURPOSE_CATEGORY("CM_00015", "Error occurred while adding the purpose category: %s to DB."),
        ERROR_CODE_SELECT_PURPOSE_CATEGORY_BY_ID("CM_00016", "Error occurred while retrieving purpose category from " +
                "DB for the ID: %s."),
        ERROR_CODE_DELETE_PURPOSE_CATEGORY("CM_00017", "Error occurred while deleting purpose category from DB for " +
                "the ID: %s."),
        ERROR_CODE_LIST_PURPOSE_CATEGORY("CM_00018", "Error occurred while listing purpose category from DB for " +
                "limit: %s and offset: %s."),
        ERROR_CODE_PURPOSE_NAME_REQUIRED("CM_00019", "Purpose name is required."),
        ERROR_CODE_PURPOSE_ID_REQUIRED("CM_00020", "Purpose ID is required."),
        ERROR_CODE_SELECT_PURPOSE_BY_NAME("CM_00021", "Error occurred while retrieving purpose from DB for the Name:%s."),
        ERROR_CODE_PURPOSE_ALREADY_EXIST("CM_00022", "Purpose with the name: %s already exists."),
        ERROR_CODE_INVALID_ARGUMENTS_FOR_LIM_OFFSET("CM_00023", "Limit or offset values cannot be negative."),
        ERROR_CODE_PURPOSE_ID_INVALID("CM_00024", "Invalid purpose Id: %s"),
        ERROR_CODE_SELECT_PURPOSE_CATEGORY_BY_NAME("CM_00025", "Error occurred while retrieving purpose category from" +
                "DB for the Name: %s."),
        ERROR_CODE_PURPOSE_CATEGORY_ID_REQUIRED("CM_00026", "Purpose category Id is required."),
        ERROR_CODE_PURPOSE_CATEGORY_ID_INVALID("CM_00027", "Invalid purpose category Id: %s"),
        ERROR_CODE_PURPOSE_CATEGORY_NAME_REQUIRED("CM_00028", "Purpose category name is required."),
        ERROR_CODE_PURPOSE_CATEGORY_ALREADY_EXIST("CM_00029", "Purpose category with the name: %s already exists."),
        ERROR_CODE_UNEXPECTED("CM_00030", "Unexpected Error"),
        ERROR_CODE_PII_CATEGORY_NAME_REQUIRED("CM_00031", "PII Category name is required."),
        ERROR_CODE_PII_CATEGORY_ALREADY_EXIST("CM_00032", "PII Category already exists with the name: %s."),
        ERROR_CODE_SELECT_PII_CATEGORY_BY_NAME("CM_00033", "Error occurred while retrieving PII category from DB for " +
                "the Name: %s."),
        ERROR_CODE_PII_CATEGORY_ID_REQUIRED("CM_00034", "PII Category ID is required."),
        ERROR_CODE_PII_CATEGORY_ID_INVALID("CM_00035", "Invalid PII category Id: %s"),
        ERROR_CODE_PII_PRINCIPAL_ID_REQUIRED("CM_00036", "PII Principal ID is required."),
        ERROR_CODE_PII_COLLECTION_METHOD_REQUIRED("CM_00037", "Collection method is required."),
        ERROR_CODE_AT_LEAST_ONE_SERVICE_REQUIRED("CM_00038", "At least one service is required."),
        ERROR_CODE_SERVICE_NAME_REQUIRED("CM_00039", "Service name is required."),
        ERROR_CODE_AT_LEAST_ONE_PURPOSE_REQUIRED("CM_00040", "At least one purpose is required."),
        ERROR_CODE_PURPOSE_ID_MANDATORY("CM_00041", "Purpose Id is required in the service: %s."),
        ERROR_CODE_CONSENT_TYPE_MANDATORY("CM_00042", "Consent Type is required in the service: %s."),
        ERROR_CODE_AT_LEAST_ONE_CATEGORY_ID_REQUIRED("CM_00043", "At least one purpose category is required for " +
                "the service: %s."),
        ERROR_CODE_AT_LEAST_ONE_PII_CATEGORY_ID_REQUIRED("CM_00044", "At least one PII category is required for the " +
                "service: %s."),
        ERROR_CODE_IS_PRIMARY_PURPOSE_IS_REQUIRED("CM_00045", "primaryPurpose parameter is required in service: %s"),
        ERROR_CODE_TERMINATION_IS_REQUIRED("CM_00046", "Termination parameter is required in service: %s"),
        ERROR_CODE_THIRD_PARTY_DISCLOSURE_IS_REQUIRED("CM_00047", "thirdPartyDisclosure parameter is required in " +
                "service %s"),
        ERROR_CODE_ADD_RECEIPT("CM_00048", "Error occurred while adding the receipt for principal: %s"),
        ERROR_CODE_ADD_RECEIPT_SP_ASSOC("CM_00049", "Error occurred while adding the receipt to SP association for " +
                "service: %s"),
        ERROR_CODE_ADD_SP_TO_PURPOSE_ASSOC("CM_00050", "Error occurred while adding the SP to Purpose association for" +
                "purpose Id: %s"),
        ERROR_CODE_ADD_SP_PURPOSE_TO_PURPOSE_CAT_ASSOC("CM_00051", "Error occurred while adding the SP_Purpose to " +
                "Purpose category association"),
        ERROR_CODE_ADD_SP_PURPOSE_TO_PII_CAT_ASSOC("CM_00052", "Error occurred while adding the SP_Purpose to " +
                "PII category association"),
        ERROR_CODE_ADD_RECEIPT_PROPERTIES("CM_00053", "Error occurred while adding Receipt properties"),
        ERROR_CODE_RETRIEVE_RECEIPT_INFO("CM_000054", "Error occurred while retrieving receipt info from DB for the " +
                "ID: %s."),
        ERROR_CODE_RETRIEVE_PURPOSE_INFO("CM_000055", "Error occurred while retrieving receipt purpose info from DB " +
                "for the  receipt ID: %s."),
        ERROR_CODE_GET_DAO("CM_00056", "No %s are registered."),
        ERROR_CODE_SEARCH_RECEIPTS("CM_00057", "Error while searching receipts."),
        ERROR_CODE_REVOKE_RECEIPT("CM_00058", "Error while revoking receipt: %s."),
        ERROR_CODE_RETRIEVE_TENANT_DOMAIN("CM_000059", "Error occurred while retrieving tenant domain for tenant ID:" +
                                                       " %s."),
        ERROR_CODE_RETRIEVE_TENANT_ID("CM_000060", "Error occurred while retrieving tenant ID for tenant domain %s."),
        ERROR_CODE_INVALID_TENANT_ID("CM_000061", "Invalid tenant ID: %s"),
        ERROR_CODE_INVALID_TENANT_DOMAIN("CM_000062", "Invalid tenant domain: %s"),
        ERROR_CODE_ADD_PURPOSE_PII_ASSOC("CM_00063", "Error occurred while adding Purpose to PII Category " +
                "association for purpose: %s"),
        ERROR_CODE_REVOKE_ACTIVE_RECEIPT("CM_00064", "Error while revoking active receipts or user: %s."),
        ERROR_CODE_PURPOSE_NAME_INVALID("CM_00065", "Invalid Purpose name: %s"),
        ERROR_CODE_PURPOSE_CAT_NAME_INVALID("CM_00066", "Invalid Purpose Category name: %s"),
        ERROR_CODE_PII_CAT_NAME_INVALID("CM_00067", "Invalid PII Category name: %s"),
        ERROR_CODE_RECEIPT_ID_INVALID("CM_00068", "Invalid Receipt Id: %s"),
        ERROR_CODE_CREATE_DB_TABLES("CM_00069", "Error while creating database tables for Consent Management."),
        ERROR_CODE_RUN_SQL_QUERY("CM_00070", "Error while executing SQL query: %s"),
        ERROR_CODE_RUN_SQL_SCRIPT("CM_00071", "Error while executing Consent Management database creation script for " +
                                              "at: %s."),
        ERROR_CODE_UNSUPPORTED_DB("CM_00072", "Unsupported database: %s Database will not be created automatically. " +
                                              "Please create the database using appropriate database scripts for " +
                                              "the database."),
        ERROR_CODE_GET_DB_TYPE("CM_00073", "Error while getting the database connection metadata."),
        ERROR_CODE_NO_SQL_SCRIPT("CM_00074", "Could not find the database script at %s."),
        ERROR_CODE_NO_USER_FOUND("CM_00075", "No authenticated user found to perform the operation: %s."),
        ERROR_CODE_USER_NOT_AUTHORIZED("CM_00076", "User: %s is not authorized to perform this operation."),
        ERROR_CODE_RETRIEVE_RECEIPT_EXISTENCE("CM_000077", "Error occurred while check receipt existence from " +
                "DB for: %s."),
        ERROR_CODE_NO_AUTH_USER_FOUND("CM_00078", "No authenticated user found to perform the operation"),
        ERROR_CODE_PURPOSE_IS_ASSOCIATED("CM_00079", "Purpose Id: %s is associated with one or more receipt(s)."),
        ERROR_CODE_RETRIEVE_RECEIPTS_ASSOCIATED_WITH_PURPOSE("CM_00080", "Error occurred while checking usage of " +
                "purpose from DB for the ID: %s."),
        ERROR_CODE_RETRIEVE_SP_PURPOSE_ASSOCIATED_WITH_PIICATERY("CM_00081", "Error occurred while checking usage of " +
                "pii-category from DB for the ID: %s."),
        ERROR_CODE_PII_CATEGORY_IS_ASSOCIATED("CM_00082", "PII Category Id: %s is associated with one or more " +
                "purpose(s) or service(s)."),
        ERROR_CODE_GETTING_PUBLIC_CERT("CM_00083", "Error while getting public cert of tenant: %s."),
        ERROR_CODE_ADD_CONSENT_RECEIPT("CM_00084", "Could not add consent receipt for principal: %s."),

        ERROR_CODE_DELETE_RECEIPT("CM_00085", "Error occurred while deleting receipt from DB for " +
                                                   "the ID: %s."),
        ERROR_CODE_PURPOSE_GROUP_REQUIRED("CM_00086", "Purpose group is required."),
        ERROR_CODE_PURPOSE_GROUP_TYPE_REQUIRED("CM_00087", "Purpose group type is required."),
        ERROR_CODE_PURPOSE_PII_CONSTRAINT_REQUIRED("CM_00088", "Purpose PII category should be specified mandatory or" +
                                                               " not for PII category ID: %s."),
        ERROR_CODE_LIST_PURPOSE_BY_ID("CM_00089", "Error occurred while listing purposes by ID: %s."),
        ERROR_CODE_UPDATE_PURPOSE("CM_00090", "Error occurred while updating the purposes: %s."),
        ERROR_CODE_GET_PURPOSE_VERSION("CM_00091", "Error occurred while retrieving latest version of purpose: %s."),
        ERROR_CODE_UPDATE_PURPOSE_PII_ASSOC("CM_00092", "Error occurred while updating Purpose to PII Category " +
                                                 "association for purpose: %s");
        private final String code;
        private final String message;

        ErrorMessages(String code, String message) {

            this.code = code;
            this.message = message;
        }

        public String getCode() {

            return code;
        }

        public String getMessage() {

            return message;
        }

        @Override
        public String toString() {

            return code + " : " + message;
        }
    }

    /**
     * PII Controller related constants.
     */
    public static class PIIControllerElements {

        public static final String COUNTRY_ELEMENT = "PIIController.Address.Country";
        public static final String LOCALITY_ELEMENT = "PIIController.Address.Locality";
        public static final String REGION_ELEMENT = "PIIController.Address.Region";
        public static final String POST_OFFICE_BOX_NUMBER_ELEMENT = "PIIController.Address.PostOfficeBoxNumber";
        public static final String POST_CODE_ELEMENT = "PIIController.Address.PostalCode";
        public static final String STREET_ADDRESS_ELEMENT = "PIIController.Address.StreetAddress";
        public static final String PII_CONTROLLER_NAME_ELEMENT = "PIIController.PiiController";
        public static final String PII_CONTROLLER_CONTACT_ELEMENT = "PIIController.Contact";
        public static final String PII_CONTROLLER_PHONE_ELEMENT = "PIIController.Phone";
        public static final String PII_CONTROLLER_EMAIL_ELEMENT = "PIIController.Email";
        public static final String PII_CONTROLLER_ON_BEHALF_ELEMENT = "PIIController.OnBehalf";
        public static final String PII_CONTROLLER_URL_ELEMENT = "PIIController.PiiControllerUrl";

        public static final String PII_CONTROLLER_NAME = "piiController";
        public static final String ON_BEHALF = "onBehalf";
        public static final String CONTACT = "contact";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String PII_CONTROLLER_URL = "piiControllerUrl";
        public static final String PUBLIC_KEY = "publicKey";
        public static final String ADDRESS_COUNTRY = "addressCountry";
        public static final String ADDRESS_LOCALITY = "addressLocality";
        public static final String ADDRESS_REGION = "addressRegion";
        public static final String POST_OFFICE_BOX_NUMBER = "postOfficeBoxNumber";
        public static final String POSTAL_CODE = "postalCode";
        public static final String STREET_ADDRESS = "streetAddress";
        public static final String ADDRESS = "Address";
    }

    /**
     * Consent Interceptor related constants.
     */
    public static class InterceptorConstants {

        public static final String PRE_ADD_PURPOSE = "PRE_ADD_PURPOSE";
        public static final String POST_ADD_PURPOSE = "POST_ADD_PURPOSE";
        public static final String PRE_UPDATE_PURPOSE = "PRE_UPDATE_PURPOSE";
        public static final String POST_UPDATE_PURPOSE = "POST_UPDATE_PURPOSE";
        public static final String PRE_GET_PURPOSE = "PRE_GET_PURPOSE";
        public static final String POST_GET_PURPOSE = "POST_GET_PURPOSE";
        public static final String PRE_GET_PURPOSE_BY_ID = "PRE_GET_PURPOSE_BY_ID";
        public static final String POST_GET_PURPOSE_BY_ID = "POST_GET_PURPOSE_BY_ID";
        public static final String PRE_GET_PURPOSE_BY_UNIQUE_ID = "PRE_GET_PURPOSE_BY_UNIQUE_ID";
        public static final String POST_GET_PURPOSE_BY_UNIQUE_ID = "POST_GET_PURPOSE_BY_UNIQUE_ID";
        public static final String PRE_GET_PURPOSE_BY_NAME = "PRE_GET_PURPOSE_BY_NAME";
        public static final String POST_GET_PURPOSE_BY_NAME = "POST_GET_PURPOSE_BY_NAME";
        public static final String PRE_GET_PURPOSE_LIST = "PRE_GET_PURPOSE_LIST";
        public static final String POST_GET_PURPOSE_LIST = "POST_GET_PURPOSE_LIST";
        public static final String PRE_GET_PURPOSE_LIST_BY_ID = "PRE_GET_PURPOSE_LIST_BY_ID";
        public static final String POST_GET_PURPOSE_LIST_BY_ID = "POST_GET_PURPOSE_LIST_BY_ID";
        public static final String PRE_DELETE_PURPOSE = "PRE_DELETE_PURPOSE";
        public static final String POST_DELETE_PURPOSE = "POST_DELETE_PURPOSE";
        public static final String PRE_IS_PURPOSE_EXIST = "PRE_IS_PURPOSE_EXIST";
        public static final String POST_IS_PURPOSE_EXIST = "POST_IS_PURPOSE_EXIST";
        public static final String PRE_IS_PURPOSE_VERSION_EXIST = "PRE_IS_PURPOSE_VERSION_EXIST";
        public static final String POST_IS_PURPOSE_VERSION_EXIST = "POST_IS_PURPOSE_VERSION_EXIST";

        public static final String PRE_ADD_PURPOSE_CATEGORY = "PRE_ADD_PURPOSE_CATEGORY";
        public static final String POST_ADD_PURPOSE_CATEGORY = "POST_ADD_PURPOSE_CATEGORY";
        public static final String PRE_GET_PURPOSE_CATEGORY = "PRE_GET_PURPOSE_CATEGORY";
        public static final String POST_GET_PURPOSE_CATEGORY = "POST_GET_PURPOSE_CATEGORY";
        public static final String PRE_GET_PURPOSE_CATEGORY_BY_NAME = "PRE_GET_PURPOSE_CATEGORY_BY_NAME";
        public static final String POST_GET_PURPOSE_CATEGORY_BY_NAME = "POST_GET_PURPOSE_CATEGORY_BY_NAME";
        public static final String PRE_GET_PURPOSE_CATEGORY_LIST = "PRE_GET_PURPOSE_CATEGORY_LIST";
        public static final String POST_GET_PURPOSE_CATEGORY_LIST = "POST_GET_PURPOSE_CATEGORY_LIST";
        public static final String PRE_DELETE_PURPOSE_CATEGORY = "PRE_DELETE_PURPOSE_CATEGORY";
        public static final String POST_DELETE_PURPOSE_CATEGORY = "POST_DELETE_PURPOSE_CATEGORY";
        public static final String PRE_IS_PURPOSE_CATEGORY_EXIST = "PRE_IS_PURPOSE_CATEGORY_EXIST";
        public static final String POST_IS_PURPOSE_CATEGORY_EXIST = "POST_IS_PURPOSE_CATEGORY_EXIST";

        public static final String PRE_ADD_PII_CATEGORY = "PRE_ADD_PII_CATEGORY";
        public static final String POST_ADD_PII_CATEGORY = "POST_ADD_PII_CATEGORY";
        public static final String PRE_GET_PII_CATEGORY = "PRE_GET_PII_CATEGORY";
        public static final String POST_GET_PII_CATEGORY = "POST_GET_PII_CATEGORY";
        public static final String PRE_GET_PII_CATEGORY_BY_NAME = "PRE_GET_PII_CATEGORY_BY_NAME";
        public static final String POST_GET_PII_CATEGORY_BY_NAME = "POST_GET_PII_CATEGORY_BY_NAME";
        public static final String PRE_GET_PII_CATEGORY_LIST = "PRE_GET_PII_CATEGORY_LIST";
        public static final String POST_GET_PII_CATEGORY_LIST = "POST_GET_PII_CATEGORY_LIST";
        public static final String PRE_DELETE_PII_CATEGORY = "PRE_DELETE_PII_CATEGORY";
        public static final String POST_DELETE_PII_CATEGORY = "POST_DELETE_PII_CATEGORY";
        public static final String PRE_IS_PII_CATEGORY_EXIST = "PRE_IS_PII_CATEGORY_EXIST";
        public static final String POST_IS_PII_CATEGORY_EXIST = "POST_IS_PII_CATEGORY_EXIST";

        public static final String PRE_ADD_RECEIPT = "PRE_ADD_RECEIPT";
        public static final String POST_ADD_RECEIPT = "POST_ADD_RECEIPT";
        public static final String PRE_GET_RECEIPT = "PRE_GET_RECEIPT";
        public static final String POST_GET_RECEIPT = "POST_GET_RECEIPT";
        public static final String PRE_REVOKE_RECEIPT = "PRE_REVOKE_RECEIPT";
        public static final String POST_REVOKE_RECEIPT = "POST_REVOKE_RECEIPT";
        public static final String PRE_DELETE_RECEIPT = "PRE_DELETE_RECEIPT";
        public static final String POST_DELETE_RECEIPT = "POST_DELETE_RECEIPT";
        public static final String PRE_LIST_RECEIPTS = "PRE_LIST_RECEIPTS";
        public static final String POST_LIST_RECEIPTS = "POST_LIST_RECEIPTS";
    }
}
