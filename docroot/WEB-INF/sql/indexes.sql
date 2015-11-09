create index IX_706C3AFB on JPB_Agency (active_);
create index IX_AC2C915 on JPB_Agency (owner);

create index IX_DAA3A581 on JPB_BookingStatus (brtId);
create index IX_AB8C28F4 on JPB_BookingStatus (status);
create index IX_41B06439 on JPB_BookingStatus (tripStatus);
create index IX_4D0B4248 on JPB_BookingStatus (userId);
create index IX_F226B92E on JPB_BookingStatus (userId, status);
create index IX_9BB44773 on JPB_BookingStatus (userId, tripStatus);

create index IX_D65E686 on JPB_Bus (active_);

create index IX_CADFBA5B on JPB_BusAvailability (available);
create index IX_EDFB8071 on JPB_BusAvailability (brtId);

create index IX_1AB23BF8 on JPB_BusEmployee (active_);
create index IX_ECA72B6A on JPB_BusEmployee (agency);

create index IX_1BC047A3 on JPB_BusReservation (baId);
create index IX_CB4F8F6F on JPB_BusReservation (userId);

create index IX_2B758197 on JPB_BusRoute (active_);
create index IX_3283D9B9 on JPB_BusRoute (busId);
create index IX_AE10F16E on JPB_BusRoute (endLocation);
create index IX_887B3D35 on JPB_BusRoute (startLocation);
create index IX_929D76CB on JPB_BusRoute (startLocation, endLocation);

create index IX_4AB2FB06 on JPB_BusRouteTimings (active_);
create index IX_65D693E2 on JPB_BusRouteTimings (brId);
create index IX_17496F3E on JPB_BusRouteTimings (brId, travelDate);
create index IX_E53B353F on JPB_BusRouteTimings (travelDate);

create index IX_97B40B34 on JPB_Coupon (couponName);

create index IX_8D33760B on JPB_Location (active_);
create index IX_9139EDD on JPB_Location (locationCityName);
create index IX_309BA812 on JPB_Location (locationName);
create index IX_8EA1425E on JPB_Location (locationZip);

create index IX_28D04871 on JPB_UserCoupon (claimed);
create index IX_41C64D2F on JPB_UserCoupon (couponId);
create index IX_AFED6D54 on JPB_UserCoupon (userId);
create index IX_2E1AEAE9 on JPB_UserCoupon (userId, couponId);