package dataaccess.dao;

import java.util.HashMap;
import java.util.Map;

public class ParameterMapper {
	private Map<Integer, Object> parameters;
	
	public ParameterMapper() {
		parameters = new HashMap<>();
	}
	
	public void addParameter(int index, Object value) {
		parameters.put(index, value);
	}
	
	public Object getParameter(int index) {
		return parameters.get(index);
	}
	
	public Map<Integer, Object> getParameters() {
		return this.parameters;
	}
}