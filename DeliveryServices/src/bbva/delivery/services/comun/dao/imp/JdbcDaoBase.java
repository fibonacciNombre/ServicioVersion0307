package bbva.delivery.services.comun.dao.imp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoBase extends JdbcDaoSupport {
	
	@Autowired
	public void loadDatasource(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
}
