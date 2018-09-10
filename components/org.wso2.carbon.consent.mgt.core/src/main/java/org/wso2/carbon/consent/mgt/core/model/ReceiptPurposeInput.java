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

package org.wso2.carbon.consent.mgt.core.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptPurposeInput {

    private Integer uniqueId;
    private String purposeName;
    private List<Integer> purposeCategoryId;
    private String consentType;
    private List<PIICategoryValidity> piiCategory;
    private Boolean primaryPurpose;
    private String termination;
    private Boolean thirdPartyDisclosure;
    private String thirdPartyName;

    public Integer getUniqueId() {

        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {

        this.uniqueId = uniqueId;
    }

    public List<Integer> getPurposeCategoryId() {

        return purposeCategoryId;
    }

    public void setPurposeCategoryId(List<Integer> purposeCategoryId) {

        this.purposeCategoryId = purposeCategoryId;
    }

    public String getConsentType() {

        return consentType;
    }

    public void setConsentType(String consentType) {

        this.consentType = consentType;
    }

    public List<PIICategoryValidity> getPiiCategory() {

        if (piiCategory == null) {
            return new ArrayList<>();
        }
        return piiCategory;
    }

    public void setPiiCategory(List<PIICategoryValidity> piiCategory) {

        this.piiCategory = piiCategory;
    }

    public Boolean isPrimaryPurpose() {

        return primaryPurpose;
    }

    public void setPrimaryPurpose(Boolean primaryPurpose) {

        this.primaryPurpose = primaryPurpose;
    }

    public String getTermination() {

        return termination;
    }

    public void setTermination(String termination) {

        this.termination = termination;
    }

    public Boolean isThirdPartyDisclosure() {

        return thirdPartyDisclosure;
    }

    public void setThirdPartyDisclosure(Boolean thirdPartyDisclosure) {

        this.thirdPartyDisclosure = thirdPartyDisclosure;
    }

    public String getThirdPartyName() {

        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {

        this.thirdPartyName = thirdPartyName;
    }

    public String getPurposeName() {

        return purposeName;
    }

    public void setPurposeName(String purposeName) {

        this.purposeName = purposeName;
    }
}
