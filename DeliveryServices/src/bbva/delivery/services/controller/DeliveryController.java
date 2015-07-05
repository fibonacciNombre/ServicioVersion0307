package bbva.delivery.services.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import bbva.delivery.services.anotaciones.AdviceController;
import bbva.delivery.services.comun.bean.ListaParametroCursor;
import bbva.delivery.services.comun.bean.Parametro;
import bbva.delivery.services.comun.service.ComunService;

import commons.framework.BaseController;

@AdviceController
public class DeliveryController extends BaseController{
	 
	public static final String COOKIE_USUARIO_SAS 			= "SAS_CODUSUARIO_COOKIE";
	
	public static final String WEBAPP_SAS 					= "/" ;
	
	public static final String token 						= "F2DA2A4571F9A6BF8B85BB6452CAFAFF";
	
	
	@Autowired
	private ComunService comunService;
	
	@SuppressWarnings("unused")
	private void setupCookies(HttpServletRequest request, HttpServletResponse response){
		System.out.println("request.getParameter(usuario)	: "+ request.getParameter("usuario"));
		Cookie usrCookie = new Cookie(COOKIE_USUARIO_SAS, request.getParameter("usuario"));
		usrCookie.setPath(WEBAPP_SAS);
		response.addCookie(usrCookie);		
	}
	
	@Override 
	public ModelAndView buscar(HttpServletRequest request,HttpServletResponse response) {return null;}

	@Override
	public ModelAndView open(HttpServletRequest request,HttpServletResponse response) {return null;}

	@Override
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response) {return null;}

	public ModelAndView comboParametro(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html; charset=UTF-8");
		Parametro parametro = new Parametro();
		String result;
		
		parametro.setIdeTipPar(request.getParameter("tipo"));
		comunService.obtenerListaParametros(parametro);
		
		result = commons.web.UtilWeb.listaToArrayJavaScript(parametro.getCursor(), null, ListaParametroCursor.class.getName());
		
		this.escribirTextoSalida(response, result);
		
		
		return new ModelAndView();
	}
	
	public String goHomePage(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		System.out.println("login	-->		inicio");
		return "inicio"; 
	}

	
	public void redireccionInicio(HttpServletRequest request,
			HttpServletResponse response){
		
		String a = request.getContextPath()+"/jsp/inicio.jsp";
		
		this.escribirTextoSalida(response, a);
	}
	
	public void redireccionInicio2(HttpServletRequest request,
			HttpServletResponse response){
		
		String a = request.getContextPath()+"/jsp/inicio.jsp";
		
		try {
			response.sendRedirect(a);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
