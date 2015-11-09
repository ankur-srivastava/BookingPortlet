create table JPB_Agency (
	agencyId LONG not null primary key,
	agencyName VARCHAR(75) null,
	owner VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table JPB_BookingStatus (
	bsId LONG not null primary key,
	userId LONG,
	brtId LONG,
	status VARCHAR(75) null,
	tripStatus VARCHAR(75) null,
	createDate DATE null
);

create table JPB_Bus (
	busId LONG not null primary key,
	busName VARCHAR(75) null,
	agency LONG,
	driver LONG,
	conductor LONG,
	helper LONG,
	plateNumber VARCHAR(75) null,
	color VARCHAR(75) null,
	make VARCHAR(75) null,
	model VARCHAR(75) null,
	year VARCHAR(75) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table JPB_BusAvailability (
	baId LONG not null primary key,
	brtId LONG,
	total LONG,
	available LONG,
	price LONG,
	createDate DATE null
);

create table JPB_BusEmployee (
	beId LONG not null primary key,
	beName VARCHAR(75) null,
	agency LONG,
	contactNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	licenseNumber VARCHAR(75) null,
	alternateIdNumber VARCHAR(75) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table JPB_BusReservation (
	brId LONG not null primary key,
	baId LONG,
	userId LONG,
	paymentReceived BOOLEAN,
	bookingDate DATE null
);

create table JPB_BusRoute (
	brId LONG not null primary key,
	busId LONG,
	startLocation LONG,
	endLocation LONG,
	midLocation1 LONG,
	midLocation2 LONG,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table JPB_BusRouteTimings (
	brtId LONG not null primary key,
	brId LONG,
	busDetails VARCHAR(75) null,
	travelDate VARCHAR(75) null,
	travelTime VARCHAR(75) null,
	total LONG,
	available LONG,
	price LONG,
	active_ BOOLEAN,
	completed VARCHAR(75) null,
	createDate DATE null
);

create table JPB_Coupon (
	couponId LONG not null primary key,
	couponName VARCHAR(75) null,
	price LONG,
	validTill DATE null,
	audience BOOLEAN,
	createDate DATE null
);

create table JPB_Location (
	locationId LONG not null primary key,
	locationName VARCHAR(75) null,
	streetAddress1 VARCHAR(75) null,
	streetAddress2 VARCHAR(75) null,
	locationZip VARCHAR(75) null,
	locationCityName VARCHAR(75) null,
	locationStateName VARCHAR(75) null,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	comments VARCHAR(75) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table JPB_UserCoupon (
	ucId LONG not null primary key,
	userId LONG,
	couponId LONG,
	claimed BOOLEAN,
	createDate DATE null
);