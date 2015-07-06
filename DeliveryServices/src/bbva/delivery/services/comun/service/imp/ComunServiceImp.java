package bbva.delivery.services.comun.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bbva.delivery.services.commons.Constants;
import bbva.delivery.services.comun.bean.ArchivoBlob;
import bbva.delivery.services.comun.bean.Atributo;
import bbva.delivery.services.comun.bean.CboDepartamento;
import bbva.delivery.services.comun.bean.CboDistrito;
import bbva.delivery.services.comun.bean.CboPais;
import bbva.delivery.services.comun.bean.CboProvincia;
import bbva.delivery.services.comun.bean.Constante;
import bbva.delivery.services.comun.bean.Parametro;
import bbva.delivery.services.comun.bean.Valor;
import bbva.delivery.services.comun.dao.ComunDao;
import bbva.delivery.services.comun.service.ComunService;

@Service("comunService")
@Transactional(propagation=Propagation.SUPPORTS)
public class ComunServiceImp implements ComunService {

	@Autowired private ComunDao comunDao;
	

	public Constante obtenerConstante(String ideConstante) {
		return comunDao.obtenerConstante(ideConstante);
	}
	

	public Parametro obtenerParametro(Parametro parametro){
		return comunDao.obtenerParametro(parametro);
	}


	public List<Parametro> listarParametro(Parametro parametro) {
		return comunDao.listarParametro(parametro);
	}


	
	public void obtenerListaParametros(Parametro param) {
		comunDao.obtenerListaParametros(param);		
	}

	public String obtenerEstadoPlan(BigDecimal ideplan) {
		return comunDao.obtenerEstadoPlan(ideplan);
	}
	

	public String obtenerSinMonedaPlan(BigDecimal ideplan){
		return comunDao.obtenerSinMonedaPlan(ideplan);
	}
	

	public List<Valor> listarValoresxAtributoHijo(Atributo param) {
		return comunDao.listarValoresxAtributoHijo(param);
	}
	

	public List<Valor> listarValoresxAtributo(Atributo param) {
		return comunDao.listarValoresxAtributo(param);
	}

	
	public void mntArchivoblob(ArchivoBlob param) {
		comunDao.mntArchivoblob(param);		
	}

	
	public void actArchivoblob(ArchivoBlob param) {
		comunDao.actArchivoblob(param);
	}
	
	public List<CboDepartamento> cboDepartamento(CboPais param){
		List<CboDepartamento> lstdepartamentos = new ArrayList<CboDepartamento>();
		List<CboDepartamento> depTemp =comunDao.cboDepartamento(param);
		
		for (CboDepartamento cboDepartamento : depTemp) {
			if (!cboDepartamento.getDscdepartamento().equals(Constants.IND_NO_DETERMINADO)){
				lstdepartamentos.add(cboDepartamento);
			}
		}
		return lstdepartamentos;
	}
	
	

	public List<CboProvincia> cboProvincia(CboDepartamento param){
		List<CboProvincia> lstprovincias = new ArrayList<CboProvincia>();
		List<CboProvincia> provTemp =comunDao.cboProvincia(param);
		
		for (CboProvincia cboProvincia : provTemp) {
			if (!cboProvincia.getDscprovincia().equals(Constants.IND_NO_DETERMINADO)){
				lstprovincias.add(cboProvincia);
			}
		}
		return lstprovincias;
	}

	

	public List<CboDistrito> cboDistrito(CboProvincia param){
		List<CboDistrito> lstdistrito = new ArrayList<CboDistrito>();
		List<CboDistrito> distTemp = comunDao.cboDistrito(param);
		
		for (CboDistrito cboDistrito : distTemp) {
			if (!cboDistrito.getDscdistrito().equals(Constants.IND_NO_DETERMINADO)){
				lstdistrito.add(cboDistrito);
			}
		}
		return lstdistrito;
	}
}