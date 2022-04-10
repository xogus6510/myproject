package com.example.demo;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//뷰의 요청경로 지정
	@RequestMapping("/helloboot")
	public ModelAndView hello() { //Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("model", "전달할 값2dfsf"); //"변수이름", "변수에 넣을 데이터"
		mv.setViewName("hello"); // 뷰 이름 지정, jsp 이름
		return mv; // jsp 보냄
	}

	private static PythonInterpreter intPre;
	 @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView getTest() {
		ModelAndView mv = new ModelAndView();
        intPre = new PythonInterpreter();
        intPre.execfile("src/main/webapp/WEB-INF/views/test.py");
        intPre.exec("print(testFunc(5,10))");

        PyFunction pyFuntion = (PyFunction) intPre.get("testFunc", PyFunction.class);
        int a = 10, b = 20;
        PyObject pyobj = pyFuntion.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println(pyobj.toString());
        
        mv.addObject("model2", pyobj.toString()); //"변수이름", "변수에 넣을 데이터"
		mv.setViewName("hello"); // 뷰 이름 지정, jsp 이름
		return mv; // jsp 보냄
    }
}
