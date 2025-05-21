// import org.json.JSONObject;
// import org.json.JSONArray;
// import java.util.*;

// List<Map<String, Object>> result = new ArrayList<>();
// Map<String, Object> resultMap = new LinkedHashMap<>();
// Map<String, Object> contextMap = new LinkedHashMap<>();

// try {
//         JSONObject request = new JSONObject(Request)
//     boolean isSubTypeValid = true;
//     JSONArray processingInstructions = request.optJSONArray("ProcessingInstructions");
//     if (processingInstructions != null) {
//         for (int i = 0; i < processingInstructions.length(); i++) {
//             String subType = processingInstructions.getJSONObject(i).optString("SubType", "");
//             if (!("Submit New Business Application".equals(subType))) {
//                 isSubTypeValid = false;
//                 break;
//             }
//         }
//     }
//     if(isSubTypeValid){
//     resultMap.put("SubType", isSubTypeValid);}
//     else{
//         return;
        
//     }

//     JSONObject application = request.optJSONObject("Application");
//     boolean hasApplication = application != null && application.length() > 0;
//     if(hasApplication){
//     resultMap.put("Application", hasApplication);}
//     else{
//         return;
//     }

//     if (hasApplication && isSubTypeValid) {
        
//         // resultMap.put("SourceCodeDesc", application.optString("SourceCodeDesc", ""));
//         // resultMap.put("PlanCode", application.optString("PlanCode", ""));
        
//         String sourceCodeDesc = application.optString("SourceCodeDesc", "")
//         String planCode = application.optString("PlanCode", "")
//         JSONArray featuresArray = request.optJSONArray("Features");
//         Map<String, String> rider_map = new HashMap<String, String>();
//         Map<String, String> death_rider_map = new HashMap<String, String>();
//         if(featuresArray != null && sourceCodeDesc == "NASU"){
            
//             for(int j=0;j<featuresArray.length();j++){
//                 JSONObject featureObject = featuresArray.getJSONObject(j);
//                 if(featureObject.has("SpecCode") && featureObject.has("VariationGroupID")){
//                     String specCode = featureObject.getString("SpecCode");
//                     String variationGroupID = featureObject.getString("VariationGroupID");
//                     if(specCode != "133"){
//                         rider_map.put(specCode, variationGroupID);
//                     }
//                 }
                
//                 if(planCode == "865" && specCode == "133"){
//                     if(variationGroupID == "1" || variationGroupID == "6" || variationGroupID == "7" || variationGroupID == "8" || variationGroupID == "9"){
//                         death_rider_map.put("31", "1")
//                     }else if(variationGroupID == "2" || variationGroupID == "3"){
//                         death_rider_map.put("31", "2")
//                     }else if(variationGroupID == "4" || variationGroupID == "5"){
//                         death_rider_map.put("31", "3")
//                     }else if(variationGroupID == "10" || variationGroupID == "11"){
//                         death_rider_map.put("31", "4")
//                     }else if(variationGroupID == "12" || variationGroupID == "13"){
//                         death_rider_map.put("31", "5")
//                     }
//                 }
//             }
            
//         }
//         Boolean matchedInd = false
//         for(Map.Entry<String, String> entry1 : rider_map.entrySet()){
//             String key1 = entry1.getKey();
// 	        String value1 = entry1.getValue();
// 	        for(Map.Entry<String, String> entry2 : death_rider_map.entrySet()){
// 	            String key2 = entry2.getKey();
// 		        String value2 = entry2.getValue();
		
// 		        if(key1 == key2 && value1 == value2){
// 		            matchedInd = true
// 		            break
// 		        }
//     }
// }
//     resultMap.put("MatchedInd", matchedInd)

//         //JSONObject feature = (features != null && features.length()>0) ? features.getJSONObject(0) : new JSONObject();
//         // def inputMap = [
//         //     "IncomeSpecCode": IncomeSpecCode,
//         //     "IncomeVariationGroupID": IncomeVariationGroupID
//         // ]
//         // def decisionResult = dmnDecisionService.evaluateDecisionByKey("ValidateMatchedRiderReq").variables(inputMap).evaluate()
//         // def death_benefit_rider_specCode = decisionResult.getSingleEntryMap().get("DeathSpecCode")
//         // def death_benefit_rider_variationGroupID = decisionResult.getSingleEntryMap().get("DeathVariationGroupID")
        
        
//         resultMap.put("CheckAppplicationDate_Application", !application.optString("ApplicationDate", "").trim().isEmpty());
//         resultMap.put("CheckContractNbr_Application", !application.optString("ContractNbr", "").trim().isEmpty());
//         resultMap.put("CheckEffectiveDate_Application", !application.optString("EffectiveDate", "").trim().isEmpty());
//         JSONObject initialPurchase = application.optJSONObject("InitialPurchase");
//         if (initialPurchase != null) {
//             String initialPurchase = policyValues.optString("InitialPurchase", null);
//             resultMap.put("CheckInitialPurchase_GrossAmount_Application", initialPurchase != null && !initialPurchase.trim().isEmpty());
//         } else {
//             resultMap.put("CheckInitialPurchase_GrossAmount_Application", false);
//         }
//         resultMap.put("CheckPlanCode_Application", !application.optString("PlanCode", "").trim().isEmpty());
//         resultMap.put("CheckPolicyDate_Application", !application.optString("PolicyDate", "").trim().isEmpty());
//         // 3. Check ContribType and GrossAmount
//         JSONObject policyValues = application.optJSONObject("PolicyValues");
//         if (policyValues != null) {
//             String contribType = policyValues.optString("ContribType", null);
//             resultMap.put("CheckPolicyValues_ContribType_Application", contribType != null && !contribType.trim().isEmpty());
//         } else {
//             resultMap.put("CheckPolicyValues_ContribType_Application", false);
//         }
//         resultMap.put("CheckProcessingCoID_Application", !application.optString("ProcessingCompanyID", "").trim().isEmpty());
//         resultMap.put("CheckQualificationFlag_Application", !application.optString("QualificationFlag", "").trim().isEmpty());
//         Map<String, Boolean> featureMap = new HashMap<String, Boolean>();
//         if(featuresArray != null){
//             for(int j=0;j<featuresArray.length();j++){
//                 JSONObject featureObject = featuresArray.getJSONObject(j)
//                 featureMap.put("CheckPackageID", !featureObject.optString("PackageID", "").trim().isEmpty());
//                 featureMap.put("CheckSpecCode", !featureObject.optString("SpecCode", "").trim().isEmpty());
//                 featureMap.put("CheckVariationGroupID", !featureObject.optString("VariationGroupID", "").trim().isEmpty());
//                 if(featureMap.getValue("CheckPackageID") == false || featureMap.getValue("CheckSpecCode") == false || featureMap.getValue("CheckVariationGroupID") == false){break;}
//             }
//             resultMap.put("CheckPackageID", featureMap.getValue("CheckPackageID"))
//             resultMap.put("CheckSpecCode", featureMap.getValue("CheckSpecCode"));
//             resultMap.put("CheckVariationGroupID", featureMap.getValue("CheckVariationGroupID"));
//         }
//         JSONArray rolesArray = application.optJSONArray("Roles");
//         String concat_nametype = "";
//         String concat_roletype = "";
//         String concat_roleoption = "";
//         if(rolesArray!=null){ 
//             for(int j=0;j<rolesArray.length();j++){
//                 JSONObject roleJSONObject = rolesArray.getJSONObject(j)
//                 String nameType = roleJSONObject.optString("NameType", "")
//                 String roleType = roleJSONObject.optString("RoleType", "")
//                 String roleOption = roleJSONObject.optString("RoleOption", "")
//                 concat_nametype = concat_nametype + nameType + "|";
//                 concat_roletype = concat_roletype + roleType + "|";
//                 concat_roleoption = concat_roleoption + roleOption + "|";
//             }
//             context_map.put("CheckNameType", concat_nametype)
//             context_map.put("CheckRoleType", concat_roletype)
//             context_map.put("CheckRoleOption", concat_roleoption)
//         }
//         resultMap.add(context_map)
//         String nameType  = ""
//         String roleTypeOption = ""
//         String sex = ""
//         String dob = ""
//         String eid = ""
//         String fn = ""
//         String ln = ""
//         String per = ""
//         String rel = ""
//         String ssn = ""
//         String ha = ""
//         String tt = ""
//         String bid = ""
//         String email = ""
//         String relch = ""
//         String percent = ""
//         if (rolesArray != null) {
//     for (int j = 0; j < rolesArray.length(); j++) {
//         JSONObject roleJsonObject = rolesArray.getJSONObject(j);
//         if (roleJsonObject.has("RoleType") && roleJsonObject.has("RoleOption")) {
//             String roleType = roleJsonObject.getString("RoleType");
//             String roleOption = roleJsonObject.getString("RoleOption");
//             roleOptionType = roleOptionType+"T"+roleOption + "O"+ roleType +"|";
//             nameType = nameType+"T"+ roleOption + "O"+ roleType +":NT="+roleJsonObject.getString("NameType")+"|";
//             if(!(roleJsonObject.has("Percent"))){
//                 percent = percent+"T"+ roleOption + "O"+ roleType +":P="+"N"+"|"
                
//             }
//              if((roleJsonObject.has("Percent"))){
//                  if(roleOptionType.contains("T0O-2") || roleOptionType.contains("T1O-2") || roleOptionType.contains("T0O36") || roleOptionType.contains("T0O-12")){
//                 percent = percent+"T"+ roleOption + "O"+ roleType +":P="+roleJsonObject.getString("Percent")+"|"
//                 }
//             }
//             if(!(roleJsonObject.has("Sex"))){
//                 sex = sex+"T"+ roleOption + "O"+ roleType +":S="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("DOB"))){
//                 dob = dob+"T"+ roleOption + "O"+ roleType +":DOB="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("ExternalID"))){
//                 eid = eid +"T"+ roleOption + "O"+ roleType +":EID="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("First Name"))){
//                 fn = fn +"T"+ roleOption + "O"+ roleType +":FN="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("Last Name"))){
//                 ln = ln +"T"+ roleOption + "O"+ roleType +":LN="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("Percentage"))){
//                 per = per +"T"+ roleOption + "O"+ roleType +":P="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("Relationship"))){
//                 rel = rel +"T"+ roleOption + "O"+ roleType +":R="+roleJsonObject.getString("Relationship")+"|";
//             }
//             if(!(roleJsonObject.has("SSN"))){
//                 ssn = ssn +"T"+ roleOption + "O"+ roleType +":SSN="+"N"+"|";
//             }
//             JSONArray addressArray = roleJsonObject.optJSONArray("Addresses")
//             if(!(addressArray.length()>0)){
//                 ha = ha +"T"+ roleOption + "O"+ roleType +":HA="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("TrustType"))){
//                 tt = tt +"T"+ roleOption + "O"+ roleType +":TT="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("BeneficiaryID"))){
//                 bid = bid +"T"+ roleOption + "O"+ roleType +":BID="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("Email"))){
//                 email = email +"T"+ roleOption + "O"+ roleType +":E="+"N"+"|";
//             }
//             if(!(roleJsonObject.has("Relationship"))){
//                 relch = relch +"T"+ roleOption + "O"+ roleType +":R="+"N"+"|"; // doubt
//             }
            
//         }
//     }
   
//   resultMap.put("RoleTypeOption", roleTypeOption);
//   resultMap.put("NameType", nameType);
//   resultMap.put("CheckSex", sex);
//   resultMap.put("CheckDOB", dob);
//   resultMap.put("CheckExternalID", eid);
//   resultMap.put("CheckFirstName", fn);
//   resultMap.put("CheckLastName", ln);
//   resultMap.put("CheckPercentage", per);
//   resultMap.put("CheckRelationship", rel);
//   resultMap.put("CheckSSN", ssn);
//   resultMap.put("CheckHomeAddress", ha);
//   resultMap.put("CheckTrustType", tt);
//   resultMap.put("CheckBeneficiaryID", bid);
//   resultMap.put("CheckEmail", email);
//   resultMap.put("Relationship", relch) //
//   resultMap.put("CheckPercentage", percent)
// }
//     }

// } catch (Exception e) {
//     resultMap.put("Error", "Exception occurred: " + e.getMessage());
    
//     String[] keys = [
//         "SubType", "Application", "SourceCodeDesc", "PlanCode", "IncomeSpecCode", "IncomeVariationGroupID", "CheckAppplicationDate_Application",
//         "CheckContractNbr_Application", "CheckEffectiveDate_Application", "CheckInitialPurchase_GrossAmount_Application", "CheckPlanCode_Application",
//         "CheckPolicyDate_Application", "CheckPolicyValues_ContribType_Application", "CheckProcessingCoID_Application", "CheckQualificationFlag_Application",
//         "CheckPackageID", "CheckSpecCode", "CheckVariationGroupID", "CheckNameType", "CheckRoleType", "CheckRoleOption", "RoleTypeOption", "NameType",
//         "CheckSex", "CheckDOB", "CheckExternalID", "CheckFirstName", "CheckLastName", "CheckPercentage", "CheckRelationship", "CheckSSN", "CheckHomeAddress",
//         "CheckTrustType", "CheckBeneficiaryID", "CheckEmail", "Relationship", "CheckPercentage"
//     ]
    
//     for (String key : keys){
//         resultMap.putIfAbsent(key, "");
//     }
// }

// result.add(resultMap);
// return result;

import org.json.JSONObject
import org.json.JSONArray

List<Map<String, Object>> result = new ArrayList<>()
Map<String, Object> resultMap = new LinkedHashMap<>()
Map<String, Object> context = new LinkedHashMap<>()

try {
    JSONObject request = new JSONObject(Request)
    boolean isSubTypeValid = true
    JSONArray processingInstructions = request.optJSONArray("ProcessingInstructions")
    
    if (processingInstructions != null) {
        for (int i = 0; i < processingInstructions.length(); i++) {
            String subType = processingInstructions.getJSONObject(i).optString("SubType", "")
            if (!"Submit New Business Application".equals(subType)) {
                isSubTypeValid = false
                break
            }
        }
    }
    if (isSubTypeValid) {
        resultMap.put("SubType", isSubTypeValid)
    } else {
        return result
    }

    JSONObject application = request.optJSONObject("Application")
    boolean hasApplication = application != null && application.length() > 0
    if (hasApplication) {
        resultMap.put("Application", hasApplication)
    } else {
        return result
    }

    String sourceCodeDesc = application.optString("SourceCdDesc", "")
    String planCode = application.optString("PlanCode", "")

    JSONArray featuresArray = application.optJSONArray("Features")
    Map<String, String> rider_map = new HashMap<>()
    Map<String, String> death_rider_map = new HashMap<>()
    if(hasApplication && isSubTypeValid){
    if (featuresArray != null && "NASU".equals(sourceCodeDesc)) {
        for (int j = 0; j < featuresArray.length(); j++) {
            JSONObject featureObject = featuresArray.getJSONObject(j)
            String specCode = featureObject.optString("SpecCode", "")
            String variationGroupID = featureObject.optString("VariationGroupID", "")
            
            if (!"133".equals(specCode)) {
                rider_map.put(specCode, variationGroupID)
            }

            if ("865".equals(planCode) && "133".equals(specCode)) {
                switch (variationGroupID) {
                    case ["1", "6", "7", "8", "9"]:
                        death_rider_map.put("31", "1"); break
                    case ["2", "3"]:
                        death_rider_map.put("31", "2"); break
                    case ["4", "5"]:
                        death_rider_map.put("31", "3"); break
                    case ["10", "11"]:
                        death_rider_map.put("31", "4"); break
                    case ["12", "13"]:
                        death_rider_map.put("31", "5"); break
                }
            }
        }
    }

    boolean matchedInd = false
    for (entry1 in rider_map.entrySet()) {
        for (entry2 in death_rider_map.entrySet()) {
            if (entry1.key == entry2.key && entry1.value == entry2.value) {
                matchedInd = true
                break
            }
        }
    }
    resultMap.put("MatchedInd", matchedInd)

    resultMap.put("CheckAppplicationDate_Application", !application.optString("ApplicationDate", "").trim().isEmpty())
    resultMap.put("CheckContractNbr_Application", !application.optString("ContractNbr", "").trim().isEmpty())
    resultMap.put("CheckEffectiveDate_Application", !application.optString("EffectiveDate", "").trim().isEmpty())

    JSONObject policyValues = application.getJSONObject("PolicyValues")
    if (policyValues != null) {
        //String initialPurchase = policyValues.optString("InitialPurchase", null)
        //resultMap.put("CheckInitialPurchase_GrossAmount_Application", initialPurchase != null && !initialPurchase.trim().isEmpty())
        String contribType = policyValues.optString("ContribType", "")
        resultMap.put("CheckPolicyValues_ContribType_Application", contribType != null && !contribType.trim().isEmpty())
    } else {
        //resultMap.put("CheckInitialPurchase_GrossAmount_Application", false)
        resultMap.put("CheckPolicyValues_ContribType_Application", false)
    }
    // JSONObject initialPurchase = application.optJSONObject("InitialPurchase")
    // if(initialPurchase != null) {
    //     Long grossAmount = initialPurchase.optLong("GrossAmount", null)
    //     resultMap.put("CheckInitialPurchase_GrossAmount_Application", grossAmount != null)
    // }else{
    //     resultMap.put("CheckInitialPurchase_GrossAmount_Application", false)
    // }
    
        JSONObject initialPurchase = application.getJSONObject("InitialPurchase")
    if (initialPurchase != null && initialPurchase.has("GrossAmount") && !initialPurchase.isNull("GrossAmount")) {
        Long grossAmount = initialPurchase.getLong("GrossAmount")
        resultMap.put("CheckInitialPurchase_GrossAmount_Application", true)
    } else {
        resultMap.put("CheckInitialPurchase_GrossAmount_Application", false)
    }

    resultMap.put("CheckPlanCode_Application", !planCode.trim().isEmpty())
    resultMap.put("CheckPolicyDate_Application", !application.optString("PolicyDate", "").trim().isEmpty())
    resultMap.put("CheckProcessingCoID_Application", !application.optString("ProcessingCompanyID", "").trim().isEmpty())
    resultMap.put("CheckQualificationFlag_Application", !application.optString("QualificationFlag", "").trim().isEmpty())

    // if (featuresArray != null) {
    //     boolean checkPackageID = true, checkSpecCode = true, checkVariationGroupID = true
    //     for (int j = 0; j < featuresArray.length(); j++) {
    //         JSONObject featureObject = featuresArray.getJSONObject(j)
    //         checkPackageID &= !featureObject.optString("PackageID", "").trim().isEmpty()
    //         checkSpecCode &= !featureObject.optString("SpecCode", "").trim().isEmpty()
    //         checkVariationGroupID &= !featureObject.optString("VariationGroupID", "").trim().isEmpty()
    //     }
    //     resultMap.put("CheckPackageID", checkPackageID)
    //     resultMap.put("CheckSpecCode", checkSpecCode)
    //     resultMap.put("CheckVariationGroupID", checkVariationGroupID)
    // }
    
//     if (featuresArray != null) {
//     Boolean packageIDFlag = true
//     Boolean specCodeFlag = true
//     Boolean variationGroupIDFlag = true

//     for (int j = 0; j < featuresArray.length(); j++) {
//         JSONObject featureObject = featuresArray.getJSONObject(j)
//         Boolean checkPackageID = !featureObject.optString("PackageID", "").trim().isEmpty()
//         Boolean checkSpecCode = !featureObject.optString("SpecCode", "").trim().isEmpty()
//         Boolean checkVariationGroupID = !featureObject.optString("VariationGroupID", "").trim().isEmpty()

//         if (!checkPackageID || !checkSpecCode || !checkVariationGroupID) {
//             packageIDFlag = checkPackageID
//             specCodeFlag = checkSpecCode
//             variationGroupIDFlag = checkVariationGroupID
//             break
//         }
//     }

//     resultMap.put("CheckPackageID", packageIDFlag)
//     resultMap.put("CheckSpecCode", specCodeFlag)
//     resultMap.put("CheckVariationGroupID", variationGroupIDFlag)
// }else {
//     resultMap.put("CheckPackageID", false)
//     resultMap.put("CheckSpecCode", false)
//     resultMap.put("CheckVariationGroupID", false)
// } 
    if (featuresArray != null) {
    Boolean packageIDFlag = true
    Boolean specCodeFlag = true
    Boolean variationGroupIDFlag = true

    for (int j = 0; j < featuresArray.length(); j++) {
        JSONObject featureObject = featuresArray.getJSONObject(j);

        if (featureObject.optString("PackageID", "").trim().isEmpty()) {
            packageIDFlag = false
            break
        }

        if (featureObject.optString("SpecCode", "").trim().isEmpty()) {
            specCodeFlag = false
            break
        }

        if (featureObject.optString("VariationGroupID", "").trim().isEmpty()) {
            variationGroupIDFlag = false
            break
        }
    }

    resultMap.put("CheckPackageID", packageIDFlag)
    resultMap.put("CheckSpecCode", specCodeFlag)
    resultMap.put("CheckVariationGroupID", variationGroupIDFlag)
} else {
    resultMap.put("CheckPackageID", false)
    resultMap.put("CheckSpecCode", false)
    resultMap.put("CheckVariationGroupID", false)
}

//     if (featuresArray != null) {
//     Boolean packageIDFlag = true;
//     Boolean specCodeFlag = true;
//     Boolean variationGroupIDFlag = true;

//     for (int j = 0; j < featuresArray.length(); j++) {
//         JSONObject featureObject = featuresArray.getJSONObject(j);

//         String packageIdVal = String.valueOf(featureObject.opt("PackageID")).trim();
//         String specCodeVal = String.valueOf(featureObject.opt("SpecCode")).trim();
//         String variationGroupIdVal = String.valueOf(featureObject.opt("VariationGroupID")).trim();

//         System.out.println("Feature " + j + ":");
//         System.out.println("PackageID: [" + packageIdVal + "]");
//         System.out.println("SpecCode: [" + specCodeVal + "]");
//         System.out.println("VariationGroupID: [" + variationGroupIdVal + "]");

//         if (packageIdVal.isEmpty()) {
//             packageIDFlag = false;
//             break;
//         }

//         if (specCodeVal.isEmpty()) {
//             specCodeFlag = false;
//             break;
//         }

//         if (variationGroupIdVal.isEmpty()) {
//             variationGroupIDFlag = false;
//             break;
//         }
//     }

//     resultMap.put("CheckPackageID", packageIDFlag);
//     resultMap.put("CheckSpecCode", specCodeFlag);
//     resultMap.put("CheckVariationGroupID", variationGroupIDFlag);
// } else {
//     resultMap.put("CheckPackageID", false);
//     resultMap.put("CheckSpecCode", false);
//     resultMap.put("CheckVariationGroupID", false);
// }
    


    JSONArray rolesArray = application.getJSONArray("Roles")
    String concat_nametype = "", concat_roletype = "", concat_roleoption = ""
    String roleOptionType = ""
    String nameType = "", sex = "", dob = "", eid = "", fn = "", ln = "", per = ""
    String rel = "", ssn = "", ha = "", tt = "", bid = "", email = "", relch = "", percent = ""
    
//     Map<String, Integer> mp = new LinkedHashMap<>()
// if (rolesArray != null) {
//     for (int j = 0; j < rolesArray.length(); j++) {
//         JSONObject role = rolesArray.getJSONObject(j)
//         String roleType = role.optString("RoleType", "")
//         String roleOption = role.optString("RoleOption", "")
//         int percent = role.optInt("Percent", 0) // safer fallback

//         if ("0".equals(roleOption) && "36".equals(roleType)) {
//             mp.put("Agent", mp.getOrDefault("Agent", 0) + percent)
//         }

//         if ("0".equals(roleOption) && "-12".equals(roleType)) {
//             mp.put("Servicing Agent", mp.getOrDefault("Servicing Agent", 0) + percent)
//         }

//         if ("0".equals(roleOption) && "-2".equals(roleType)) {
//             mp.put("Primary Beneficiary", mp.getOrDefault("Primary Beneficiary", 0) + percent)
//         }

//         if ("1".equals(roleOption) && "-2".equals(roleType)) {
//             mp.put("Contingent Beneficiary", mp.getOrDefault("Contingent Beneficiary", 0) + percent)
//         }
//     }
// }
    
    // Map<String, Integer> mp = new LinkedHashMap<>();
        
    //     if (rolesArray != null) {
    //         for (int j = 0; j < rolesArray.length(); j++) {
    //             JSONObject role = rolesArray.getJSONObject(j);
    //             String roleType = role.optString("RoleType", "");
    //             String roleOption = role.optString("RoleOption", "");
    //             String percentStr = role.optString("Percent", "0").trim();
    //             String roKey = "T${roleOption}O${roleType}"
    //             int percent = 0;
    //             try {
    //                 percent = Integer.parseInt(percentStr);
    //             } catch (NumberFormatException e) {
    //                 System.out.println("Invalid percent value at index " + j + ": " + percentStr);
    //             }
                
    //             if(role.has("RoleOption") && role.has("RoleType")){
    //                 mp.put(roKey, mp.getOrDefault(roKey, 0) + percent);
    //             }
        
    //             // if ("0".equals(roleOption) && "36".equals(roleType)) {
    //             //     mp.put(roKey, mp.getOrDefault(roKey, 0) + percent);
    //             // }
        
    //             // if ("0".equals(roleOption) && "-12".equals(roleType)) {
    //             //     mp.put(roKey, mp.getOrDefault(roKey, 0) + percent);
    //             // }
        
    //             // if ("0".equals(roleOption) && "-2".equals(roleType)) {
    //             //     mp.put(roKey, mp.getOrDefault(roKey, 0) + percent);
    //             // }
        
    //             // if ("1".equals(roleOption) && "-2".equals(roleType)) {
    //             //     mp.put(roKey, mp.getOrDefault(roKey, 0) + percent);
    //             // }
    //         }
            
    //     }
    // **
    Map<String, Integer> mp = new LinkedHashMap<>()

    if (rolesArray != null) {
        for (int j = 0; j < rolesArray.length(); j++) {
            JSONObject role = rolesArray.getJSONObject(j)
            String roleType = role.optString("RoleType", "")
            String roleOption = role.optString("RoleOption", "")
            Integer percentStr = Integer.parseInt(role.optString("Percent", "0"))
            String roKey = "T" + roleOption + "O" + roleType + ":";
            //String roKey = "T${roleOption}O${roleType}"
    
            //percent = 0
            //Integer numberObj = Integer.valueOf(str)
            //Integer percent = Integer.parseInt(percentStr)
            //Integer percent = percentStr.isInteger() ? percentStr.toInteger() : 0
            
            if (role.has("RoleOption") && role.has("RoleType")) {
                mp.put(roKey, mp.getOrDefault(roKey, 0) + percentStr);
            }
        }
    }
    resultMap.put("CheckMap", mp)
    if (rolesArray != null) {
        for (int j = 0; j < rolesArray.length(); j++) {
            JSONObject role = rolesArray.getJSONObject(j)
            String nameTypeVal = role.optString("NameType", "")
            String roleType = role.optString("RoleType", "")
            String roleOption = role.optString("RoleOption", "")
            if("".equals(nameTypeVal)){
                concat_nametype += "CNT=N" + "|"
            }else{
                concat_nametype += nameTypeVal + "|"
            }
            if("".equals(roleType)){
                concat_roleType += "CRT=N" + "|"
            }else{
                concat_roletype += roleType + "|"
            }
            if("".equals(roleOption)){
                concat_roleOption += "CRO=N" + "|"
            }else{
                concat_roleoption += roleOption + "|"
            }
            
            
            

            String roKey = "T${roleOption}O${roleType}|"
            roleOptionType += roKey
            //roleOptionType = roleOptionType+"T"+roleOption + "O"+ roleType +"|";
            String newroKey = "T${roleOption}O${roleType}:"
            nameType += newroKey + "NT=" + nameTypeVal + "|"

            // percent += role.has("Percent") ? newroKey + "P=" + role.optString("Percent") + "|" : newroKey + "P=N|"
            // sex += role.has("Sex") ? "" : newroKey + "S=N|"
            // dob += role.has("DOB") ? "" : newroKey + "DOB=N|"
            // eid += role.has("ExternalID") ? "" : newroKey + "EID=N|"
            // fn += role.has("First Name") ? "" : newroKey + "FN=N|"
            // ln += role.has("Last Name") ? "" : newroKey + "LN=N|"
            // per += role.has("Percentage") ? "" : newroKey + "P=N|"
            // rel += role.has("Relationship") ? newroKey + "R=" + role.optString("Relationship") + "|" : newroKey + "R=N|"
            // ssn += role.has("SSN") ? "" : newroKey + "SSN=N|"
            // tt += role.has("TrustType") ? "" : newroKey + "TT=N|"
            // bid += role.has("BeneficiaryID") ? "" : newroKey + "BID=N|"
            // email += role.has("Email") ? "" : newroKey + "E=N|"
            // relch += role.has("Relationship") ? "" : newroKey + "R=N|"
            //String per = role.optString("Percent", "")
            
           //percent += role.has("Percent") ? newroKey + "P=" + role.optString("Percent", "") + "|" : newroKey + "P=N|"
            
            // if (role.has("Percent") && (!"100".equals(role.optString("Percent", "")) && mp.getOrDefault(rokey, 0) == 100)) {
            //     percent += newroKey + "P=" + "100" + "|"
            // }
            // else if (role.has("Percent") && ("100".equals(per) ) {
            // percent += newroKey + "P=" + role.optString("Percent", "") + "|"
            
            // }
            // else {
            //     percent += newroKey + "P=N|"
            // }
            
            // if (role.has("Percent") && (!"100".equals(role.optString("Percent", "")) && mp.getOrDefault(roKey, 0) == 100)) {
            //     percent += "${newroKey}P=100|"
            // } else if (role.has("Percent") && "100".equals(role.optString("Percent", ""))) {
            //     percent += "${newroKey}P=${role.optString("Percent", "")}|"
            // } else {
            //     percent += "${newroKey}P=N|"
            // }
            
            // **
            if (role.has("Percent") && (mp.getOrDefault(newroKey, 0) == 100)) {
            
                percent += newroKey + "P=100|";
            
            } else if (role.has("Percent") && "100".equals(role.optString("Percent", ""))) {
            
                percent += newroKey + "P=" + role.optString("Percent", "") + "|";
            
            } else if(!(role.has("Percent"))){
            
                percent += newroKey + "P=N|";
            
            }
            
            // if(!(role.has("Percent"))){
            //     percent += newroKey + "P=N|"
            // }else{
            //     percent += newroKey + "P=" + mp.getValue()
            // }
            sex += role.has("Sex") ? newroKey + "S=" + role.optString("Sex") + "|" : newroKey + "S=N|"
            dob += role.has("DOB") ? newroKey + "DOB=" + role.optString("DOB") + "|" : newroKey + "DOB=N|"
            eid += role.has("ExternalID") ? newroKey + "EID=" + role.optString("ExternalID") + "|" : newroKey + "EID=N|"
            fn += role.has("FirstName") ? newroKey + "FN=" + role.optString("FirstName").toLowerCase() + "|" : newroKey + "FN=N|"
            ln += role.has("LastName") ? newroKey + "LN=" + role.optString("LastName").toLowerCase() + "|" : newroKey + "LN=N|"
            per += role.has("Percent") ? newroKey + "P=" + role.optString("Percent") + "|" : newroKey + "P=N|"
            rel += role.has("Relationship") ? newroKey + "R=" + role.optString("Relationship") + "|" : newroKey + "R=N|"
            ssn += role.has("SSN") ? newroKey + "SSN=" + role.optString("SSN") + "|" : newroKey + "SSN=N|"
            tt += role.has("TrustType") ? newroKey + "TT=" + role.optString("TrustType") + "|" : newroKey + "TT=N|"
            // bid += role.has("BeneficiaryID") ? newroKey + "BID=" + role.optString("BeneficiaryID") + "|" : newroKey + "BID=N|"
            //bid += role.has("SSN") && role.has("DOB") ? newrokey + "SSN=" + role.optString("SSN", "") + "DOB=" + role.optString("DOB", "") + "|" : newroKey + "SSN=N " + "DOB=N|"
            // **
            if (role.has("SSN") && role.has("DOB")) {
                bid += newroKey + "SSN=" + role.optString("SSN", "") + "DOB=" + role.optString("DOB", "") + "|";
            } else {
                bid += newroKey + "SSN=N DOB=N|";
            }

            email += role.has("Email") ? newroKey + "E=" + role.optString("Email") + "|" : newroKey + "E=N|"
            relch += role.has("Relationship") ? newroKey + "R=" + role.optString("Relationship") + "|" : newroKey + "R=N|"


            // JSONArray addresses = role.optJSONArray("Addresses")
            // ha += (addresses != null && addresses.length() > 0) ? "" : newroKey + "HA=N|"
            
            JSONArray addresses = role.optJSONArray("Addresses")
            ha += (addresses != null && addresses.length() > 0) ? newroKey + "HA=" + addresses.toString() + "|" : newroKey + "HA=N|"

        }

        context.put("CheckNameType", concat_nametype)
        context.put("CheckRoleType", concat_roletype)
        context.put("CheckRoleOption", concat_roleoption)
        context.put("RoleOptionType", roleOptionType)
        context.put("NameType", nameType)
        context.put("CheckSex", sex)
        context.put("CheckDOB", dob)
        context.put("CheckExternalID", eid)
        context.put("CheckFirstName", fn)
        context.put("CheckLastName", ln)
        context.put("CheckPercentage", per)
        context.put("CheckRelationship", rel)
        context.put("CheckSSN", ssn)
        context.put("CheckHomeAddress", ha)
        context.put("CheckTrustType", tt)
        context.put("CheckBeneficiaryIdentifier", bid)
        context.put("CheckEmail", email)
        context.put("Relationship", relch)
        context.put("CheckPercentage", percent)
        resultMap.put("context", context)
    }else{resultMap.put("context", context)}

    // resultMap.put("context", context)
    for (entry in context.entrySet()) {
    resultMap.put(entry.getKey(), entry.getValue())
}

}
} catch (Exception e) {
    resultMap.put("Error", "Exception occurred: " + e.getMessage())
}

result.add(resultMap)
return result

