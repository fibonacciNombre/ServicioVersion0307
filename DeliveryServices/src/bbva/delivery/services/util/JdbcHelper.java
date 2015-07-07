package bbva.delivery.services.util;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class JdbcHelper {
	
	public static void setInParameter(SimpleJdbcCall call, MapSqlParameterSource in, String paramName, int sqlType, Object value){				
		call.addDeclaredParameter(new SqlParameter(paramName, sqlType));		
		in.addValue(paramName, value);
	}

	public static void setOutParameter(SimpleJdbcCall call, String paramName, int sqlType){				
		call.addDeclaredParameter(new SqlOutParameter(paramName, sqlType));	
	}

	public static <T> void setOutParameter(SimpleJdbcCall call, String paramName, int sqlType, Class<T> clase){				
		call.addDeclaredParameter(new SqlOutParameter(paramName, sqlType, new BeanPropertyRowMapper<T>(clase)));	
	}
	
	public static void setInOutParameter(SimpleJdbcCall call, MapSqlParameterSource in, String paramName, int sqlType, Object value){				
		call.addDeclaredParameter(new SqlInOutParameter(paramName, sqlType));		
		in.addValue(paramName, value);
	}
	
	public static SimpleJdbcCall initializeSimpleJdbcCallProcedure(JdbcTemplate jdbcTemplate, String schemaName, String packageName, String procedureName){
		SimpleJdbcCall call = null;
		call = new SimpleJdbcCall(jdbcTemplate)
			.withSchemaName(schemaName)
			.withCatalogName(packageName)
			.withProcedureName(procedureName)
			.withoutProcedureColumnMetaDataAccess();		
		
		return call;
	}

	public static SimpleJdbcCall initializeSimpleJdbcCallFunction(JdbcTemplate jdbcTemplate, String schemaName, String packageName, String functionName){
		SimpleJdbcCall call = null;
		call = new SimpleJdbcCall(jdbcTemplate)
			.withSchemaName(schemaName)
			.withCatalogName(packageName)
			.withFunctionName(functionName)
			.withoutProcedureColumnMetaDataAccess();		
		
		return call;
	}
	
	public static <T> void setResultSet(SimpleJdbcCall call, String paramName, Class<T> clase){
		
		call.returningResultSet(paramName, new BeanPropertyRowMapper<T>(clase));
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getListResultSet(Map<String, Object> out, String paramName, Class<T> clase) {
		
		return (List<T>) out.get(paramName);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getOutResult(Map<String, Object> out, String paramName, Class<T> clase) {
		
		return (T) out.get(paramName);
	}

}
