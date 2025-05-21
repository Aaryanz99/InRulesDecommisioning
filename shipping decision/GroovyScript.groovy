import org.json.JSONObject;
import org.json.JSONArray;
import java.util.*;

List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> resultMap = new LinkedHashMap<>();

        try {
            JSONObject request = new JSONObject(Request); 
            
               JSONArray policies = request.getJSONArray("Policies");
                if (policies != null && policies.length() > 0)
                {
                    JSONObject policy = policies.getJSONObject(0);
                    if (policy.has("Product")) {
                        JSONObject product = policy.getJSONObject("Product");
        
                            if (product.has("ProductCoAbbr")) {
                                resultMap.put("ProductCompanyAbbr", product.getString("ProductCoAbbr"));
                            }
        
                            if (product.has("ProductCategoryCode")) {
                                resultMap.put("ProductCategoryCode", product.getString("ProductCategoryCode"));
                            }
        
                            if (product.has("PlanCode")) {
                                resultMap.put("PlanCode", product.getString("PlanCode"));
                            }
        
                            if (product.has("BudgetCenterNumber")) {
                                resultMap.put("BudgetCenter", product.getInt("BudgetCenterNumber"));
                            }
        
                            if (product.has("ProcessingCoAbbr")) {
                                resultMap.put("ProcessingCompanyAbbr", product.getString("ProcessingCoAbbr"));
                            }
                    }
                }
                
        
        } catch (Exception e) {
            e.getMessage();
        }
        result.add(resultMap);
        return result;
