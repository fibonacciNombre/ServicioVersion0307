package bbva.delivery.services.dao;

import java.util.List;

import bbva.delivery.services.bean.ArchivoGenerado;
import bbva.delivery.services.bean.ArchivoPDF;
import bbva.delivery.services.bean.Courier;
import bbva.delivery.services.bean.Delivery;
import bbva.delivery.services.bean.RequestChangeEstadoRegistro;
import bbva.delivery.services.bean.RequestGetVisitasUsuario;
import bbva.delivery.services.bean.RequestInformarActivacionBBVA;
import bbva.delivery.services.bean.RequestInformarEntregaCourier;
import bbva.delivery.services.bean.RequestTransferirArchivo;
import bbva.delivery.services.bean.RequestValidarCourier;
import bbva.delivery.services.bean.Usuario;
import bbva.delivery.services.bean.ValidarCourier;
import bbva.delivery.services.bean.VisitasUsuario;

public interface DeliveryDao{
	void test();
	
	public void validarUsuarioToken(Usuario usuario);
	
	public List<Delivery> lstDelivery(Delivery param);
	
	public boolean validarUsuario(Usuario usuario) throws Exception;
	
	public List<Courier> obtenerListaCourier();
	
	public Usuario addUsuario(Usuario usuario);
	
	public Usuario getUsuario(Usuario usuario);
	
	public Usuario obtUsuario(Integer id);
	
	public List<VisitasUsuario> getVisitasUsuario( RequestGetVisitasUsuario requestGetVisitasUsuario, String fecha);
	
	public List<ValidarCourier> validarDNICourier( RequestValidarCourier requestValidarCourier);
	
	public RequestChangeEstadoRegistro changeEstadoRegistro( RequestChangeEstadoRegistro requestChangeEstadoRegistro);
	
	public List<Delivery> informarEntregaCourier( RequestInformarEntregaCourier requestInformarEntregaCourier);
	
	public List<Delivery> informarActivacionBBVA( RequestInformarActivacionBBVA requestInformarActivacionBBVA);
	
	public ArchivoGenerado transferirArchivo( RequestTransferirArchivo requestTransferirArchivo);
	
	public List<ArchivoPDF> getArchivoPDF( ArchivoPDF archivoPDF);
}
