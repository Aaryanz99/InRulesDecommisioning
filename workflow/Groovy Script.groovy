import org.json.JSONObject
import org.json.JSONArray
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


// Declare method before use
boolean namesMatch(JSONObject r1, JSONObject r2) {
    return r1.optString("PersonFirstName").equalsIgnoreCase(r2.optString("PersonFirstName")) &&
           r1.optString("PersonLastName").equalsIgnoreCase(r2.optString("PersonLastName")) &&
           r1.optString("PersonMiddleName").equalsIgnoreCase(r2.optString("PersonMiddleName"))
}

List<Map<String, Object>> result = new ArrayList<>()
Map<String, Object> resultMap = new LinkedHashMap<>()

try {
    JSONObject request = new JSONObject(Request)
    JSONArray policies = request.optJSONArray("Policies")

    JSONObject policy = (policies != null && policies.length() > 0) ? policies.getJSONObject(0) : new JSONObject()

    String docType = policy.optString("DocType", "")
    resultMap.put("DocType", docType.toUpperCase())
    resultMap.put("ProviderServiceCode", policy.optString("ProviderServiceCode", ""))
    resultMap.put("CompanyCode", policy.optString("ProviderServiceCode", ""))
    resultMap.put("SourceCode", policy.optString("SourceCode", ""))

    JSONObject product = policy.optJSONObject("Product")
    resultMap.put("COREProductID", product != null ? String.valueOf(product.optInt("SourceProductID", 0)) : "")
    resultMap.put("ProductName", product != null ? product.optString("SourceProductName", "").toUpperCase() : "")
    resultMap.put("BDExternalID", policy.optString("BDExternalID", ""))
    resultMap.put("DistributionChannel", policy.optString("DistributionChannelName", "DEFAULT").toUpperCase())

    String loaDateStr = policy.optString("LOAGeneratedDate", "")
    int daysDiff = 2000
    try {
        if (!loaDateStr.isEmpty() && !loaDateStr.startsWith("1999-01-01")) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(loaDateStr, formatter);
        LocalDate loaDate = offsetDateTime.toLocalDate();
        LocalDate today = LocalDate.now();
        long diff = ChronoUnit.DAYS.between(loaDate, today);
        daysDiff = (int) Math.min(2000, diff);
        }
    } catch (Exception ex) {
        daysDiff = 2000
    }
    resultMap.put("LOAGenerateDatedays", daysDiff)
    String loaDateCategory=""
    if (daysDiff == 2000) {
        loaDateCategory = "DEFAULT";
    }
    else if (daysDiff <= 1) {
        loaDateCategory = "LESS THAN EQUAL TO 1";
    } else if (daysDiff < 5) {
        loaDateCategory = "LESS THAN 5";
    } else if (daysDiff <= 5) {
        loaDateCategory = "LESS THAN EQUAL TO 5";
    } else if (daysDiff >= 13) {
        loaDateCategory = "GREATER THAN EQUAL TO 13";
    } else if (daysDiff >= 5) {
        loaDateCategory = "GREATER THAN EQUAL TO 5";
    } else {
        loaDateCategory = "DEFAULT";
    }

    resultMap.put("LOAGenerateDate", loaDateCategory)
    resultMap.put("OrganisationName", "")
    resultMap.put("Add days to interval", "0")

    resultMap.put("OwnerExists", "")
    resultMap.put("AnnuitantExists", "")
    resultMap.put("OwnerAnnuitantMatch", "")
    resultMap.put("OwnerJointAnnuitantMatch", "")
    resultMap.put("JointOwnerAnnuitantMatch", "")
    resultMap.put("JointOwnerJointAnnuitantMatch", "")
    resultMap.put("InternalRoutingTaskDocType", "")

    if ("Return Mail".equalsIgnoreCase(docType)) {
        JSONObject primOwner = null, primPart = null, jointOwner = null, annuitant = null, jointAnnuitant = null

        JSONArray roles = policy.optJSONArray("Roles")
        if (roles != null) {
            for (int i = 0; i < roles.length(); i++) {
                JSONObject role = roles.getJSONObject(i)
                String roleType = role.optString("PartyRoleType", "")
                switch (roleType) {
                    case "PRIM OWNER":
                        if (primOwner == null) primOwner = role
                        break
                    case "PRIM PART":
                        if (primPart == null) primPart = role
                        break
                    case "JT OWNER":
                        if (jointOwner == null) jointOwner = role
                        break
                    case "Annuitant":
                        if (annuitant == null) annuitant = role
                        break
                    case "Joint Annuitant":
                        if (jointAnnuitant == null) jointAnnuitant = role
                        break
                }
            }
        }

        JSONObject finalOwner = (primOwner != null) ? primOwner : primPart
        boolean ownerExists = (finalOwner != null)
        boolean annuitantExists = (annuitant != null)

        resultMap.put("OwnerExists", ownerExists ? "True" : "False")
        resultMap.put("AnnuitantExists", annuitantExists ? "True" : "False")

        resultMap.put("OwnerAnnuitantMatch", (finalOwner != null && annuitant != null && namesMatch(finalOwner, annuitant)) ? "True" : "False")
        resultMap.put("OwnerJointAnnuitantMatch", (finalOwner != null && jointAnnuitant != null && namesMatch(finalOwner, jointAnnuitant)) ? "True" : "False")
        resultMap.put("JointOwnerAnnuitantMatch", (jointOwner != null && annuitant != null && namesMatch(jointOwner, annuitant)) ? "True" : "False")
        resultMap.put("JointOwnerJointAnnuitantMatch", (jointOwner != null && jointAnnuitant != null && namesMatch(jointOwner, jointAnnuitant)) ? "True" : "False")
    }

} catch (Exception e) {
    resultMap.put("ScriptError", "Groovy error: " + e.getMessage())

    String[] keys = [
        "DocType", "ProviderServiceCode", "SourceCode", "COREProductID", "ProductName", "BDExternalID",
        "DistributionChannel", "LOAGenerateDate", "OrganisationName", "Add days to interval", "CompanyCode",
        "OwnerExists", "AnnuitantExists", "OwnerAnnuitantMatch", "OwnerJointAnnuitantMatch",
        "JointOwnerAnnuitantMatch", "JointOwnerJointAnnuitantMatch", "InternalRoutingTaskDocType"
    ]
    for (String key : keys) {
        resultMap.putIfAbsent(key, "")
    }
}

result.add(resultMap)
return result
