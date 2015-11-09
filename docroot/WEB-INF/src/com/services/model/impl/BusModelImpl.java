/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.services.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.services.model.Bus;
import com.services.model.BusModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Bus service. Represents a row in the &quot;JPB_Bus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.services.model.BusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BusImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusImpl
 * @see com.services.model.Bus
 * @see com.services.model.BusModel
 * @generated
 */
public class BusModelImpl extends BaseModelImpl<Bus> implements BusModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bus model instance should use the {@link com.services.model.Bus} interface instead.
	 */
	public static final String TABLE_NAME = "JPB_Bus";
	public static final Object[][] TABLE_COLUMNS = {
			{ "busId", Types.BIGINT },
			{ "busName", Types.VARCHAR },
			{ "agency", Types.BIGINT },
			{ "driver", Types.BIGINT },
			{ "conductor", Types.BIGINT },
			{ "helper", Types.BIGINT },
			{ "plateNumber", Types.VARCHAR },
			{ "color", Types.VARCHAR },
			{ "make", Types.VARCHAR },
			{ "model", Types.VARCHAR },
			{ "year", Types.VARCHAR },
			{ "active_", Types.BOOLEAN },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table JPB_Bus (busId LONG not null primary key,busName VARCHAR(75) null,agency LONG,driver LONG,conductor LONG,helper LONG,plateNumber VARCHAR(75) null,color VARCHAR(75) null,make VARCHAR(75) null,model VARCHAR(75) null,year VARCHAR(75) null,active_ BOOLEAN,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table JPB_Bus";
	public static final String ORDER_BY_JPQL = " ORDER BY bus.busName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JPB_Bus.busName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.services.model.Bus"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.services.model.Bus"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.services.model.Bus"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long BUSNAME_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.services.model.Bus"));

	public BusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _busId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _busId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Bus.class;
	}

	@Override
	public String getModelClassName() {
		return Bus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("busId", getBusId());
		attributes.put("busName", getBusName());
		attributes.put("agency", getAgency());
		attributes.put("driver", getDriver());
		attributes.put("conductor", getConductor());
		attributes.put("helper", getHelper());
		attributes.put("plateNumber", getPlateNumber());
		attributes.put("color", getColor());
		attributes.put("make", getMake());
		attributes.put("model", getModel());
		attributes.put("year", getYear());
		attributes.put("active", getActive());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long busId = (Long)attributes.get("busId");

		if (busId != null) {
			setBusId(busId);
		}

		String busName = (String)attributes.get("busName");

		if (busName != null) {
			setBusName(busName);
		}

		Long agency = (Long)attributes.get("agency");

		if (agency != null) {
			setAgency(agency);
		}

		Long driver = (Long)attributes.get("driver");

		if (driver != null) {
			setDriver(driver);
		}

		Long conductor = (Long)attributes.get("conductor");

		if (conductor != null) {
			setConductor(conductor);
		}

		Long helper = (Long)attributes.get("helper");

		if (helper != null) {
			setHelper(helper);
		}

		String plateNumber = (String)attributes.get("plateNumber");

		if (plateNumber != null) {
			setPlateNumber(plateNumber);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		String make = (String)attributes.get("make");

		if (make != null) {
			setMake(make);
		}

		String model = (String)attributes.get("model");

		if (model != null) {
			setModel(model);
		}

		String year = (String)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getBusId() {
		return _busId;
	}

	@Override
	public void setBusId(long busId) {
		_busId = busId;
	}

	@Override
	public String getBusName() {
		if (_busName == null) {
			return StringPool.BLANK;
		}
		else {
			return _busName;
		}
	}

	@Override
	public void setBusName(String busName) {
		_columnBitmask = -1L;

		_busName = busName;
	}

	@Override
	public long getAgency() {
		return _agency;
	}

	@Override
	public void setAgency(long agency) {
		_agency = agency;
	}

	@Override
	public long getDriver() {
		return _driver;
	}

	@Override
	public void setDriver(long driver) {
		_driver = driver;
	}

	@Override
	public long getConductor() {
		return _conductor;
	}

	@Override
	public void setConductor(long conductor) {
		_conductor = conductor;
	}

	@Override
	public long getHelper() {
		return _helper;
	}

	@Override
	public void setHelper(long helper) {
		_helper = helper;
	}

	@Override
	public String getPlateNumber() {
		if (_plateNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _plateNumber;
		}
	}

	@Override
	public void setPlateNumber(String plateNumber) {
		_plateNumber = plateNumber;
	}

	@Override
	public String getColor() {
		if (_color == null) {
			return StringPool.BLANK;
		}
		else {
			return _color;
		}
	}

	@Override
	public void setColor(String color) {
		_color = color;
	}

	@Override
	public String getMake() {
		if (_make == null) {
			return StringPool.BLANK;
		}
		else {
			return _make;
		}
	}

	@Override
	public void setMake(String make) {
		_make = make;
	}

	@Override
	public String getModel() {
		if (_model == null) {
			return StringPool.BLANK;
		}
		else {
			return _model;
		}
	}

	@Override
	public void setModel(String model) {
		_model = model;
	}

	@Override
	public String getYear() {
		if (_year == null) {
			return StringPool.BLANK;
		}
		else {
			return _year;
		}
	}

	@Override
	public void setYear(String year) {
		_year = year;
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Bus.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Bus toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Bus)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BusImpl busImpl = new BusImpl();

		busImpl.setBusId(getBusId());
		busImpl.setBusName(getBusName());
		busImpl.setAgency(getAgency());
		busImpl.setDriver(getDriver());
		busImpl.setConductor(getConductor());
		busImpl.setHelper(getHelper());
		busImpl.setPlateNumber(getPlateNumber());
		busImpl.setColor(getColor());
		busImpl.setMake(getMake());
		busImpl.setModel(getModel());
		busImpl.setYear(getYear());
		busImpl.setActive(getActive());
		busImpl.setCreateDate(getCreateDate());
		busImpl.setModifiedDate(getModifiedDate());

		busImpl.resetOriginalValues();

		return busImpl;
	}

	@Override
	public int compareTo(Bus bus) {
		int value = 0;

		value = getBusName().compareTo(bus.getBusName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Bus)) {
			return false;
		}

		Bus bus = (Bus)obj;

		long primaryKey = bus.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		BusModelImpl busModelImpl = this;

		busModelImpl._originalActive = busModelImpl._active;

		busModelImpl._setOriginalActive = false;

		busModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Bus> toCacheModel() {
		BusCacheModel busCacheModel = new BusCacheModel();

		busCacheModel.busId = getBusId();

		busCacheModel.busName = getBusName();

		String busName = busCacheModel.busName;

		if ((busName != null) && (busName.length() == 0)) {
			busCacheModel.busName = null;
		}

		busCacheModel.agency = getAgency();

		busCacheModel.driver = getDriver();

		busCacheModel.conductor = getConductor();

		busCacheModel.helper = getHelper();

		busCacheModel.plateNumber = getPlateNumber();

		String plateNumber = busCacheModel.plateNumber;

		if ((plateNumber != null) && (plateNumber.length() == 0)) {
			busCacheModel.plateNumber = null;
		}

		busCacheModel.color = getColor();

		String color = busCacheModel.color;

		if ((color != null) && (color.length() == 0)) {
			busCacheModel.color = null;
		}

		busCacheModel.make = getMake();

		String make = busCacheModel.make;

		if ((make != null) && (make.length() == 0)) {
			busCacheModel.make = null;
		}

		busCacheModel.model = getModel();

		String model = busCacheModel.model;

		if ((model != null) && (model.length() == 0)) {
			busCacheModel.model = null;
		}

		busCacheModel.year = getYear();

		String year = busCacheModel.year;

		if ((year != null) && (year.length() == 0)) {
			busCacheModel.year = null;
		}

		busCacheModel.active = getActive();

		Date createDate = getCreateDate();

		if (createDate != null) {
			busCacheModel.createDate = createDate.getTime();
		}
		else {
			busCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			busCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			busCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return busCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{busId=");
		sb.append(getBusId());
		sb.append(", busName=");
		sb.append(getBusName());
		sb.append(", agency=");
		sb.append(getAgency());
		sb.append(", driver=");
		sb.append(getDriver());
		sb.append(", conductor=");
		sb.append(getConductor());
		sb.append(", helper=");
		sb.append(getHelper());
		sb.append(", plateNumber=");
		sb.append(getPlateNumber());
		sb.append(", color=");
		sb.append(getColor());
		sb.append(", make=");
		sb.append(getMake());
		sb.append(", model=");
		sb.append(getModel());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.services.model.Bus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>busId</column-name><column-value><![CDATA[");
		sb.append(getBusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>busName</column-name><column-value><![CDATA[");
		sb.append(getBusName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agency</column-name><column-value><![CDATA[");
		sb.append(getAgency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>driver</column-name><column-value><![CDATA[");
		sb.append(getDriver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conductor</column-name><column-value><![CDATA[");
		sb.append(getConductor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>helper</column-name><column-value><![CDATA[");
		sb.append(getHelper());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plateNumber</column-name><column-value><![CDATA[");
		sb.append(getPlateNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>make</column-name><column-value><![CDATA[");
		sb.append(getMake());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>model</column-name><column-value><![CDATA[");
		sb.append(getModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Bus.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Bus.class };
	private long _busId;
	private String _busName;
	private long _agency;
	private long _driver;
	private long _conductor;
	private long _helper;
	private String _plateNumber;
	private String _color;
	private String _make;
	private String _model;
	private String _year;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private Bus _escapedModel;
}