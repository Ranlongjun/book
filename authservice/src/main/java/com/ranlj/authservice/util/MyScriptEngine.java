package com.ranlj.authservice.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
* @ClassName: MyScriptEngine  
* @Description: js脚本校验  
* @author pyh  
* @date 2018年10月18日  
*
 */
public class MyScriptEngine {

	private static final ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	
	private static final String functionReg = "^\\s*(|\\/\\*+[^\\*\\/]*\\*+\\/)\\s*function\\s+\\w+\\(\\s*\\w*\\s*\\)\\{[\\s\\S]*\\}\\s*$";
	
	private static final String functionNameReg = "function\\s+(\\w+)";
	
	/**
	 * 
	* @Title: validateScriptContent 
	* @Description: 校验js内容是否正确  
	* @param @param scriptContent
	* @param @return    参数  
	* @return boolean    返回类型  
	* @throws
	 */
	public static boolean validateScriptContent(String scriptContent){
		return scriptContent.matches(functionReg);
	}
	/**
	 * 
	* @Title: getScriptEngine  
	* @Description: 获取js引擎,评估js内容  
	* @param @param scriptContent
	* @param @return
	* @param @throws ScriptException    参数  
	* @return ScriptEngine    返回类型  
	* @throws
	 */
	public static ScriptEngine getScriptEngine(String scriptContent) throws ScriptException {
		ScriptEngine engine = scriptEngineManager.getEngineByName("javascript");
		engine.eval(scriptContent);
		return engine;
	}
	/**
	 * 
	* @Title: getFunctionName  
	* @Description: 获取js的方法名 
	* @param @param scriptContent
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	public static String getFunctionName(String scriptContent){
		Matcher matcher = Pattern.compile(functionNameReg).matcher(scriptContent);
		while(matcher.find()){
			return matcher.group(1);
		}
		return null;
	}
	
}
