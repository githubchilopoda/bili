package com.crawl.acfun.main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.tools.ant.util.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsMain {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("F:\\develop\\acfun\\acfun-main\\src\\main\\resources\\uid_1484578.html");
		Reader reader = new InputStreamReader(in, "utf-8");
		
		String contents = FileUtils.safeReadFully(reader);
		FileUtils.close(reader);
		//System.out.println(contents);
		
		Document doc = Jsoup.parse(contents);
		
		Elements elements = doc.select("#main > script");
		Element jsElement = elements.get(0);
		//System.out.println(jsElement.childNodes().size());
		String js = jsElement.childNodes().get(0).outerHtml();
		//System.out.println();
		ScriptEngineManager mgr = new ScriptEngineManager();  
        ScriptEngine engine = mgr.getEngineByExtension("js"); 
        
        engine.eval(js);
        Object obj = engine.eval("JSON.stringify(UPUser)");
        Object obj2 = engine.eval("UPUser.toString()");
        //Object obj = (ScriptObjectMirror)engine.get("UPUser");
        System.out.println(obj);
	}

}
