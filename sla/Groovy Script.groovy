import org.json.JSONObject
import org.json.JSONArray

List<Map<String, Object>> result = []
Map<String, Object> resultMap = [:]

try {
    JSONObject request = new JSONObject(Request)
    JSONArray policies = request.optJSONArray("Policies")

    JSONObject policy = (policies != null && policies.length() > 0) ? policies.getJSONObject(0) : new JSONObject()

    resultMap["DistributionChannelName"] = policy.optString("DistributionChannelName", "").toUpperCase()
    resultMap["DistributionChannelID"]   = policy.optString("DistributionChannelID","").toUpperCase()
    resultMap["ProviderServiceCode"]     = policy.optString("ProviderServiceCode", "").toUpperCase()
    resultMap["DocType"]                 = policy.optString("DocType", "").toUpperCase()

    JSONObject product = policy.optJSONObject("Product")
    resultMap["ProductCategory"] = (product != null) ? product.optString("ProductCategory", "").toUpperCase() : ""

} catch (Exception e) {
   
}

["DistributionChannelName", "DistributionChannelID", "ProviderServiceCode", "DocType", "ProductCategory"].each {
    resultMap.putIfAbsent(it, "")
}

result.add(resultMap)
return result
