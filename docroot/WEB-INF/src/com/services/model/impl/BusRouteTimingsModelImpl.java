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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.services.model.BusRouteTimings;
import com.services.model.BusRouteTimingsModel;
import com.services.model.BusRouteTimingsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the BusRouteTimings service. Represents a row in the &quot;JPB_BusRouteTimings&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.services.model.BusRouteTimingsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BusRouteTimingsImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see BusRouteTimingsImpl
 * @see com.services.model.BusRouteTimings
 * @see com.services.model.BusRouteTimingsModel
 * @generated
 */
@JSON(strict = true)
public class BusRouteTimingsModelImpl extends BaseModelImpl<BusRouteTimings>
	implements BusRouteTimingsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bus route timings model instance should use the {@link com.services.model.BusRouteTimings} interface instead.
	 */
	public static final String TABLE_NAME = "JPB_BusRouteTimings";
	public static final Object[][] TABLE_COLUMNS = {
			{ "brtId", Types.BIGINT },
			{ "brId", Types.BIGINT },
			{ "busDetails", Types.VARCHAR },
			{ "travelDate", Types.VARCHAR },
			{ "travelTime", Types.VARCHAR },
			{ "total", Types.BIGINT },
			{ "available", Types.BIGINT },
			{ "price", Types.BIGINT },
			{ "active_", Types.BOOLEAN },
			{ "completed", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table JPB_BusRouteTimings (brtId LONG not null primary key,brId LONG,busDetails VARCHAR(75) null,travelDate VARCHAR(75) null,travelTime VARCHAR(75) null,total LONG,available LONG,price LONG,active_ BOOLEAN,completed VARCHAR(75) null,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table JPB_BusRouteTimings";
	public static final String ORDER_BY_JPQL = " ORDER BY busRouteTimings.travelDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JPB_BusRouteTimings.travelDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.services.model.BusRouteTimings"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.services.model.BusRouteTimings"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.services.model.BusRouteTimings"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long BRID_COLUMN_BITMASK = 2L;
	public static long TRAVELDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static BusRouteTimings toModel(BusRouteTimingsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		BusRouteTimings model = new BusRouteTimingsImpl();

		model.setBrtId(soapModel.getBrtId());
		model.setBrId(soapModel.getBrId());
		model.setBusDetails(soapModel.getBusDetails());
		model.setTravelDate(soapModel.getTravelDate());
		model.setTravelTime(soapModel.getTravelTime());
		model.setTotal(soapModel.getTotal());
		model.setAvailable(soapModel.getAvailable());
		model.setPrice(soapModel.getPrice());
		model.setActive(soapModel.getActive());
		model.setCompleted(soapModel.getCompleted());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<BusRouteTimings> toModels(
		BusRouteTimingsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<BusRouteTimings> models = new ArrayList<BusRouteTimings>(soapModels.length);

		for (BusRouteTimingsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.services.model.BusRouteTimings"));

	public BusRouteTimingsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _brtId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBrtId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _brtId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BusRouteTimings.class;
	}

	@Override
	public String getModelClassName() {
		return BusRouteTimings.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brtId", getBrtId());
		attributes.put("brId", getBrId());
		attributes.put("busDetails", getBusDetails());
		attributes.put("travelDate", getTravelDate());
		attributes.put("travelTime", getTravelTime());
		attributes.put("total", getTotal());
		attributes.put("available", getAvailable());
		attributes.put("price", getPrice());
		attributes.put("active", getActive());
		attributes.put("completed", getCompleted());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brtId = (Long)attributes.get("brtId");

		if (brtId != null) {
			setBrtId(brtId);
		}

		Long brId = (Long)attributes.get("brId");

		if (brId != null) {
			setBrId(brId);
		}

		String busDetails = (String)attributes.get("busDetails");

		if (busDetails != null) {
			setBusDetails(busDetails);
		}

		String travelDate = (String)attributes.get("travelDate");

		if (travelDate != null) {
			setTravelDate(travelDate);
		}

		String travelTime = (String)attributes.get("travelTime");

		if (travelTime != null) {
			setTravelTime(travelTime);
		}

		Long total = (Long)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		Long available = (Long)attributes.get("available");

		if (available != null) {
			setAvailable(available);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String completed = (String)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@JSON
	@Override
	public long getBrtId() {
		return _brtId;
	}

	@Override
	public void setBrtId(long brtId) {
		_brtId = brtId;
	}

	@JSON
	@Override
	public long getBrId() {
		return _brId;
	}

	@Override
	public void setBrId(long brId) {
		_columnBitmask |= BRID_COLUMN_BITMASK;

		if (!_setOriginalBrId) {
			_setOriginalBrId = true;

			_originalBrId = _brId;
		}

		_brId = brId;
	}

	public long getOriginalBrId() {
		return _originalBrId;
	}

	@JSON
	@Override
	public String getBusDetails() {
		if (_busDetails == null) {
			return StringPool.BLANK;
		}
		else {
			return _busDetails;
		}
	}

	@Override
	public void setBusDetails(String busDetails) {
		_busDetails = busDetails;
	}

	@JSON
	@Override
	public String getTravelDate() {
		if (_travelDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _travelDate;
		}
	}

	@Override
	public void setTravelDate(String travelDate) {
		_columnBitmask = -1L;

		if (_originalTravelDate == null) {
			_originalTravelDate = _travelDate;
		}

		_travelDate = travelDate;
	}

	public String getOriginalTravelDate() {
		return GetterUtil.getString(_originalTravelDate);
	}

	@JSON
	@Override
	public String getTravelTime() {
		if (_travelTime == null) {
			return StringPool.BLANK;
		}
		else {
			return _travelTime;
		}
	}

	@Override
	public void setTravelTime(String travelTime) {
		_travelTime = travelTime;
	}

	@JSON
	@Override
	public long getTotal() {
		return _total;
	}

	@Override
	public void setTotal(long total) {
		_total = total;
	}

	@JSON
	@Override
	public long getAvailable() {
		return _available;
	}

	@Override
	public void setAvailable(long available) {
		_available = available;
	}

	@JSON
	@Override
	public long getPrice() {
		return _price;
	}

	@Override
	public void setPrice(long price) {
		_price = price;
	}

	@JSON
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

	@JSON
	@Override
	public String getCompleted() {
		if (_completed == null) {
			return StringPool.BLANK;
		}
		else {
			return _completed;
		}
	}

	@Override
	public void setCompleted(String completed) {
		_completed = completed;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BusRouteTimings.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BusRouteTimings toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BusRouteTimings)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BusRouteTimingsImpl busRouteTimingsImpl = new BusRouteTimingsImpl();

		busRouteTimingsImpl.setBrtId(getBrtId());
		busRouteTimingsImpl.setBrId(getBrId());
		busRouteTimingsImpl.setBusDetails(getBusDetails());
		busRouteTimingsImpl.setTravelDate(getTravelDate());
		busRouteTimingsImpl.setTravelTime(getTravelTime());
		busRouteTimingsImpl.setTotal(getTotal());
		busRouteTimingsImpl.setAvailable(getAvailable());
		busRouteTimingsImpl.setPrice(getPrice());
		busRouteTimingsImpl.setActive(getActive());
		busRouteTimingsImpl.setCompleted(getCompleted());
		busRouteTimingsImpl.setCreateDate(getCreateDate());

		busRouteTimingsImpl.resetOriginalValues();

		return busRouteTimingsImpl;
	}

	@Override
	public int compareTo(BusRouteTimings busRouteTimings) {
		int value = 0;

		value = getTravelDate().compareTo(busRouteTimings.getTravelDate());

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

		if (!(obj instanceof BusRouteTimings)) {
			return false;
		}

		BusRouteTimings busRouteTimings = (BusRouteTimings)obj;

		long primaryKey = busRouteTimings.getPrimaryKey();

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
		BusRouteTimingsModelImpl busRouteTimingsModelImpl = this;

		busRouteTimingsModelImpl._originalBrId = busRouteTimingsModelImpl._brId;

		busRouteTimingsModelImpl._setOriginalBrId = false;

		busRouteTimingsModelImpl._originalTravelDate = busRouteTimingsModelImpl._travelDate;

		busRouteTimingsModelImpl._originalActive = busRouteTimingsModelImpl._active;

		busRouteTimingsModelImpl._setOriginalActive = false;

		busRouteTimingsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BusRouteTimings> toCacheModel() {
		BusRouteTimingsCacheModel busRouteTimingsCacheModel = new BusRouteTimingsCacheModel();

		busRouteTimingsCacheModel.brtId = getBrtId();

		busRouteTimingsCacheModel.brId = getBrId();

		busRouteTimingsCacheModel.busDetails = getBusDetails();

		String busDetails = busRouteTimingsCacheModel.busDetails;

		if ((busDetails != null) && (busDetails.length() == 0)) {
			busRouteTimingsCacheModel.busDetails = null;
		}

		busRouteTimingsCacheModel.travelDate = getTravelDate();

		String travelDate = busRouteTimingsCacheModel.travelDate;

		if ((travelDate != null) && (travelDate.length() == 0)) {
			busRouteTimingsCacheModel.travelDate = null;
		}

		busRouteTimingsCacheModel.travelTime = getTravelTime();

		String travelTime = busRouteTimingsCacheModel.travelTime;

		if ((travelTime != null) && (travelTime.length() == 0)) {
			busRouteTimingsCacheModel.travelTime = null;
		}

		busRouteTimingsCacheModel.total = getTotal();

		busRouteTimingsCacheModel.available = getAvailable();

		busRouteTimingsCacheModel.price = getPrice();

		busRouteTimingsCacheModel.active = getActive();

		busRouteTimingsCacheModel.completed = getCompleted();

		String completed = busRouteTimingsCacheModel.completed;

		if ((completed != null) && (completed.length() == 0)) {
			busRouteTimingsCacheModel.completed = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			busRouteTimingsCacheModel.createDate = createDate.getTime();
		}
		else {
			busRouteTimingsCacheModel.createDate = Long.MIN_VALUE;
		}

		return busRouteTimingsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{brtId=");
		sb.append(getBrtId());
		sb.append(", brId=");
		sb.append(getBrId());
		sb.append(", busDetails=");
		sb.append(getBusDetails());
		sb.append(", travelDate=");
		sb.append(getTravelDate());
		sb.append(", travelTime=");
		sb.append(getTravelTime());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append(", available=");
		sb.append(getAvailable());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", completed=");
		sb.append(getCompleted());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.services.model.BusRouteTimings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>brtId</column-name><column-value><![CDATA[");
		sb.append(getBrtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brId</column-name><column-value><![CDATA[");
		sb.append(getBrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>busDetails</column-name><column-value><![CDATA[");
		sb.append(getBusDetails());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>travelDate</column-name><column-value><![CDATA[");
		sb.append(getTravelDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>travelTime</column-name><column-value><![CDATA[");
		sb.append(getTravelTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total</column-name><column-value><![CDATA[");
		sb.append(getTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>available</column-name><column-value><![CDATA[");
		sb.append(getAvailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completed</column-name><column-value><![CDATA[");
		sb.append(getCompleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BusRouteTimings.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BusRouteTimings.class
		};
	private long _brtId;
	private long _brId;
	private long _originalBrId;
	private boolean _setOriginalBrId;
	private String _busDetails;
	private String _travelDate;
	private String _originalTravelDate;
	private String _travelTime;
	private long _total;
	private long _available;
	private long _price;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private String _completed;
	private Date _createDate;
	private long _columnBitmask;
	private BusRouteTimings _escapedModel;
}