import org.json.JSONObject;
import org.json.JSONArray;
import java.util.*;

List<Map<String, Object>> result = new ArrayList<>();
        
        Map<String, Object> resultMap = new LinkedHashMap<>();
        
        try {
            JSONObject request = new JSONObject(Request);

            JSONArray policies = request.getJSONArray("Policies");
            JSONObject firstPolicy = policies.getJSONObject(0);
            JSONArray transactions = firstPolicy.getJSONArray("Transactions");

            String transactionTypeDesc = transactions.getJSONObject(0).getString("TransactionTypeDesc");
            String transactionType = transactions.getJSONObject(0).getString("Type");
            String processingCoAbbr = firstPolicy.getJSONObject("Product").getString("ProcessingCoAbbr");
            String contractStateCode = firstPolicy.getString("ContractStateCode");

            JSONArray roles = firstPolicy.getJSONArray("Roles");
            JSONObject role = roles.getJSONObject(0);

            String residenceStateCode = role.getString("ResidenceStateCode");
            Integer sourceProductID = firstPolicy.getJSONObject("Product").getInt("SourceProductID");
            String nameType = role.getString("NameType");
            String roleOption = role.getString("RoleOption");
            String partyRoleTypeCode = role.getString("PartyRoleTypeCode");

            resultMap.put("TransactionTypeDesc", transactionTypeDesc);
            resultMap.put("TransactionType", transactionType);
            resultMap.put("ProcessingCoAbbr", processingCoAbbr);
            resultMap.put("ResidenceStateCode", residenceStateCode);
            resultMap.put("SourceProductID", sourceProductID);
            resultMap.put("NameType", nameType);
            resultMap.put("RoleOption", roleOption);
            resultMap.put("ContractStateCode", contractStateCode);
            resultMap.put("PartyRoleTypeCode", partyRoleTypeCode);
            
        } catch (Exception e) {
            // Handle any exceptions (e.g., malformed JSON, missing keys, etc.)
        }
        
        result.add(resultMap);
        
        return result;
        