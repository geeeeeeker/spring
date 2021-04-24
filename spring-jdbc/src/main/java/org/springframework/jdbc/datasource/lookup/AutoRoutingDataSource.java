package org.springframework.jdbc.datasource.lookup;

import java.util.Map;
import javax.sql.DataSource;

public class AutoRoutingDataSource extends AbstractRoutingDataSource {

	private DataSource masterDataSource;

	private Map<Object, Object> targetDataSources;

	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		this.targetDataSources = targetDataSources;
		super.setTargetDataSources(targetDataSources);
	}

	@Override
	public void setDefaultTargetDataSource(Object masterDataSource) {
		this.masterDataSource = (DataSource) masterDataSource;
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return null;
	}




}
