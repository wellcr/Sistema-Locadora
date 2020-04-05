package br.com.foursys.locadora.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Valida {
	public static Boolean validaCpf(String cpf) throws NoSuchMethodException,
	FileNotFoundException, ScriptException {

	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");
	Invocable invocable = (Invocable) engine;

	engine.eval(new FileReader("C:/Workspace/Sistema Locadora/WebContent/js/validacoes.js"));
	Boolean resultado = (Boolean) invocable.invokeFunction("testaCPF", cpf);

	return resultado;
	}
	
	public static Boolean validaRg(String rg) throws NoSuchMethodException,
	FileNotFoundException, ScriptException {

	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");
	Invocable invocable = (Invocable) engine;

	engine.eval(new FileReader("C:/Workspace/Sistema Locadora/WebContent/js/validacoes.js"));
	Boolean resultado = (Boolean) invocable.invokeFunction("testaRg", rg);

	return resultado;
	}
	
	public static Boolean validaData(String data) throws NoSuchMethodException,
	FileNotFoundException, ScriptException {

	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");
	Invocable invocable = (Invocable) engine;

	engine.eval(new FileReader("C:/Workspace/Sistema Locadora/WebContent/js/validacoes.js"));
	Boolean resultado = (Boolean) invocable.invokeFunction("testaData", data);

	return resultado;
	}
	
	
}
