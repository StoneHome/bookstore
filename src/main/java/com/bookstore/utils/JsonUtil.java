package com.bookstore.utils;

import com.google.gson.Gson;

public class JsonUtil {

	public static String getResponse(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	/*

	public static ObjectNode getNoManagerResponse() {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 0);
		ObjectNode response = createObjectNode();
		response.put("actions", createArrayNode());
		objectNode.put("response", response);
		return objectNode;
	}

	public static ObjectNode getSizeAndListObjectNode(long count, List<?> list,
			Integer pageSize) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		response.put("size", (count - 1) / pageSize + 1);
		response.put("total", count);
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	public static ObjectNode getSizeAndListObjectNodeWithTotal(long count,
			List<?> list, int pageSize) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		response.put("size", (count - 1) / pageSize + 1);
		response.put("total", count);
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	*//***
	 * 分页实现的转
	 * 
	 * @param pageNum
	 * @param count
	 * @param list
	 * @param pageSize
	 * @return
	 *//*
	public static ObjectNode getPageListObjectNode(int pageNum, long count,
			List<?> list, Integer pageSize, String condition) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		response.put("maxPage", (count - 1) / pageSize + 1);
		response.put("pageNum", pageNum);
		response.put("condition", condition);
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	public static ObjectNode getSizeAndListObjectNode(long count,
			ArrayNode list, Integer pageSize) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("size", (count - 1) / pageSize + 1);
		ObjectNode response = createObjectNode();
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	public static ObjectNode getListObjectNode(Collection<?> list) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	public static ObjectNode warpStringResponse(String json)
			throws JsonProcessingException, IOException {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		response.put("response", JsonUtil.StringToJsonNode(json));
		return objectNode;
	}

	public static ObjectNode warpObjectResponse(Object obj) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		objectNode.put("response", obj.toString());
		return objectNode;
	}
	
	public static ObjectNode warpBooleanResponse(boolean obj) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		objectNode.put("response", obj);
		return objectNode;
	}
	
	public static ObjectNode warpBooleanResponse(boolean obj, String info) {
        ObjectNode objectNode = createObjectNode();
        objectNode.put("code", 1);
        objectNode.put("response", obj);
        objectNode.put("info", info);
        return objectNode;
    }

	public static ObjectNode warpSystemErrorResponse(Object obj) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", -1);
		objectNode.put("reason", obj.toString());
		return objectNode;
	}

	public static ObjectNode wrapJsonNodeResponse(JsonNode obj) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		objectNode.put("response", obj);
		return objectNode;
	}

	public static ObjectNode warpReturn(boolean succ) {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", succ);
		return returnV;
	}
	
	public static ObjectNode warpReturnString(String str) {
		ObjectNode returnV = createObjectNode();
		returnV.put("str", str);
		return returnV;
	}

	public static ObjectNode entityExistError() {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", -1);
		ObjectNode response = createObjectNode();
		response.put("reason", "entity exist");
		returnV.put("response", response);
		return returnV;
	}

	public static ObjectNode accountExistError() {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", -1);
		ObjectNode response = createObjectNode();
		response.put("reason", "account exist");
		returnV.put("response", response);
		return returnV;
	}

	public static String notLoginResponse() {
	    return "{\"code\":-100, \"response\":{\"reason\":\"not login\"}}";
	}

	public static ObjectNode notEnoughAuthorizationResponse() {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", -4);
		ObjectNode response = createObjectNode();
		response.put("reason", "no enough authorization");
		returnV.put("response", response);
		return returnV;
	}

	public static ObjectNode invalidPWResponse() {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", -3);
		ObjectNode response = createObjectNode();
		response.put("reason", "invalid password");
		returnV.put("response", response);
		return returnV;
	}

	public static ObjectNode tokenExpiredResponse() {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", -2);
		ObjectNode response = createObjectNode();
		response.put("reason", "token expired");
		returnV.put("response", response);
		return returnV;
	}

	public static ObjectNode invalidUMResponse() {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", -1);
		ObjectNode response = createObjectNode();
		response.put("reason", "invalid username or password");
		returnV.put("response", response);
		return returnV;
	}

	public static ObjectNode modifyResponse(int code, String reason) {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", code);
		ObjectNode response = createObjectNode();
		response.put("reason", reason);
		returnV.put("response", response);
		return returnV;
	}

	public static ObjectNode warpFailJsonNodeResponse(int failCode, JsonNode obj) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", failCode);
		objectNode.put("response", obj);
		return objectNode;
	}
	
	public static ObjectNode warpFailStringResponse(int failCode, String str) {
        ObjectNode objectNode = createObjectNode();
        objectNode.put("code", failCode);
        objectNode.put("response", str);
        return objectNode;
    }

	public static ObjectNode failResponse(int code, String reason) {
		ObjectNode returnV = createObjectNode();
		returnV.put("code", code);
		ObjectNode response = createObjectNode();
		response.put("reason", reason);
		returnV.put("response", response);
		return returnV;
	}
	

	
	 * public static ObjectNode getStatusObjectNode(Object obj,Integer status){
	 * ObjectNode objectNode=createObjectNode(); objectNode.put("status",
	 * status); objectNode.put("object", JsonUtil.objectToJsonNode(obj)); return
	 * objectNode; }
	 

	public static <T> List<T> StringToObjectList(String str,
			TypeReference<?> type) {
		try {
			if (str == null || str.isEmpty() || type == null) {
				// TODO
				return null;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(str, type);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T StringToObject(String str, TypeReference<T> type) {
		try {
			if (str == null || str.isEmpty() || type == null) {
				// TODO
				return null;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return objectMapper.readValue(str, type);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T StringToObject(String content, Class<T> valueType) {
		if (StringUtils.isEmpty(content) ) {
			return null;
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return  objectMapper.readValue(content, valueType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public static String ObjectToString(Object obj) {
		try {
			if (obj == null) {
				// TODO
				return null;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static JsonNode StringToJsonNode(String json)
			throws JsonProcessingException, IOException {
		if (StringUtils.isEmpty(json))
			json = "{}";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		return jsonNode;
	}

	public static JsonNode objectToJsonNode(Object obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String objJson = objectMapper.writeValueAsString(obj);
			JsonNode jsonNode = objectMapper.readTree(objJson);
			return jsonNode;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ObjectNode createObjectNode() {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode ObjectNode = objectMapper.createObjectNode();
		return ObjectNode;
	}

	public static ArrayNode createArrayNode() {
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.createArrayNode();
		return arrayNode;
	}

	public static String ObjectToStringByReflect(Object obj, String extra) {
		StringBuilder sbf = new StringBuilder();
		try {

			Class<?> clz = obj.getClass();
			Field[] fields = clz.getDeclaredFields();
			Field.setAccessible(fields, true);
			int size = fields.length;
			sbf.append("{");
			boolean bool = false;
			for (int i = 0; i < size; i++) {
				String fieldName = fields[i].getName();
				if ("serialVersionUID".equals(fieldName)) {
					continue;
				}
				sbf.append("\"");
				sbf.append(fieldName);
				sbf.append("\"");
				sbf.append(":");
				Object value = fields[i].get(obj);
				if ((fields[i].getType().equals(String.class) || fields[i]
						.getType().equals(Date.class))
						&& value != null
						&& !fieldName.equals("common_cate")) {
					bool = true;
					sbf.append("\"");
				} else {
					bool = false;
				}
				sbf.append(value);
				if (bool) {
					sbf.append("\"");
				}
				if (i != size - 1) {
					sbf.append(",");
				}

			}
			if (extra != null || !"".equals(extra)) {
				sbf.append(",");
				sbf.append(extra);
			}
			sbf.append("}");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return sbf.toString();
	}

	public static String addChannelAttribute(String json, String childUrl,
			String url, String parament) throws JsonProcessingException,
			IOException {
		ArrayNode arrayNode = (ArrayNode) StringToJsonNode(json);

		if (arrayNode != null) {
			int size = arrayNode.size();
			ObjectNode objectNode = null;
			for (int i = 0; i < size; i++) {
				objectNode = (ObjectNode) arrayNode.get(i);
				objectNode.put("childUrl", childUrl + parament + "="
						+ objectNode.get(parament));
				objectNode.put("url", url);
			}
			return arrayNode.toString();
		}
		return json;
	}

	public static String optString(ObjectNode node, String key,
			String defaultValue) {
		JsonNode jsonNode = node.get(key);
		if (jsonNode == null)
			return defaultValue;
		else
			return jsonNode.asText();
	}


	*//**
	 * 
	 * @param jsonStrings
	 *            map<dateTime,jsonContent>
	 * @param pageNum
	 * @param key
	 * @return
	 *//*
	public static String getDateListJsonResponse(List<String> jsonStrings,
			int pageNum, int pageSize, String key, long totalNumber) {
		// ObjectNode objectNode = createObjectNode();
		// ObjectNode response = createObjectNode();
		List<JsonNode> list = new ArrayList<JsonNode>();
		try {
			for (String item : jsonStrings)
				list.add(StringToJsonNode(item));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getSizeAndListStatObjectNode(pageNum, list, pageSize, key,
				totalNumber).toString();
	}

	public static ObjectNode getSizeAndListStatObjectNode(Integer pageNum,
			List<?> list, Integer pageSize, String key, long totalNumber) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		response.put("pageNum", pageNum);
		response.put("pageSize", pageSize);
		response.put(key, totalNumber);
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	public static Object getSizeAndListObjectNode(List<?> list) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	public static Object getListAndResponseObjectNode(int code, String reason, List<?> list) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", code);
		ObjectNode response = createObjectNode();
		response.put("reason", reason);
		response.put("list", JsonUtil.objectToJsonNode(list));
		objectNode.put("response", response);
		return objectNode;
	}

	public static ObjectNode getMapListObjectNode(Map<String, Object> datas) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		for (String key : datas.keySet())
			response.put(key, JsonUtil.objectToJsonNode(datas.get(key)));
		objectNode.put("response", response);
		return objectNode;
	}
	
	public static ObjectNode getMapListToObjectNode(Map<String, List<Object>> datas) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		ObjectNode response = createObjectNode();
		for (String key : datas.keySet())
			response.put(key, JsonUtil.objectToJsonNode(datas.get(key)));
		objectNode.put("response", response);
		return objectNode;
	}
	

	public static ObjectNode getObjectResponse(Object obj) {
		ObjectNode objectNode = createObjectNode();
		objectNode.put("code", 1);
		objectNode.put("response", JsonUtil.objectToJsonNode(obj));
		return objectNode;
	}

    public static ObjectNode getMapObjectNode(Map map){
        ObjectNode objectNode=createObjectNode();
        objectNode.put("code", 1);
        ObjectNode response=createObjectNode();
        response.put("map", JsonUtil.objectToJsonNode(map));
        objectNode.put("response", response);
        return objectNode;
    }

    public static <T> T getAttr(JsonNode node, String attr, Class<T> clz, T defaultValue){
        JsonNode o = node.get(attr);
        if (o == null){
            return defaultValue;
        } else {
            if (clz.equals(String.class)) {
                return (T)o.textValue();
            } else if (clz.equals(Integer.class)) {
                return (T)new Integer(o.intValue());
            } else {
                return (T)o.textValue();
            }
        }
    }

    public static <T> List<T> StringToObjectList(String str, Class<T> beanClz) {
        try {
            if (str == null || str.isEmpty() || beanClz == null) {
                // TODO
                return null;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JavaType javaType = getCollectionType(objectMapper, ArrayList.class, beanClz); 
            return objectMapper.readValue(str, javaType); 
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static JavaType getCollectionType(ObjectMapper mapper, Class<?> collectionClass, Class<?>... elementClasses) {   
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
    }
    
    public static Object nodeToObject(JsonNode node){
        if (node == null)
            return "";
        if (node instanceof DoubleNode){
            return node.asDouble();
        } else if (node instanceof TextNode){
            return node.asText();
        } else if (node instanceof BooleanNode){
            return node.asBoolean();
        } else if (node instanceof LongNode){
            return node.asLong();
        } else if (node instanceof IntNode){
            return node.asInt();
        }
        return node.asText();
    }
    
    public static JsonNode getByJPath(JsonNode node, String jpath){
        if (!jpath.contains("."))
            return node.get(jpath);
        String[] paths = jpath.split("\\.");
        JsonNode temp = node;
        for (String path : paths){
            if (temp != null)
                temp = temp.get(path);
        }
        return temp;
    }
    
    public static JsonNode warpDoubleInteger(boolean succ,long num1,long num2,int isRepeat){
		ObjectNode response = createObjectNode();
		ObjectNode returnV = createObjectNode();
		returnV.put("code", succ);
		response.put("num1", num1);
		response.put("num2", num2);
		response.put("isRepeat", isRepeat);
		returnV.put("response", response);
		return returnV;
    }
    
    public static ObjectNode getMapObjectNodeWithObject(Map<String, Object> map){
        ObjectNode objectNode=createObjectNode();
        objectNode.put("code", 1);
        ObjectNode response=createObjectNode();
        response.put("map", JsonUtil.objectToJsonNode(map));
        objectNode.put("response", response);
        return objectNode;
    }
*/}
