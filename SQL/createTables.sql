create table if not exists smartdcu.noise_level (
	measurementDate date not null,
    measurementTime time not null,
    measurementLocation varchar(255) not null,
    building varchar(255) not null, -- Replace with enum() as is a dropdown in HTML ? couldnt find options in github -Conor
    area varchar (255) not null,
    deviceID varchar(255) not null,
    noiseLevel float not null,
    measurementType varchar(255) not null, -- enum() ? -Conor
    operatorID varchar(255) not null, -- Should all ID's be sent to SQL as int or string? left as string for now -Conor
    weatherConditions varchar(255) not null,
    eventCheck bool default '0', -- default to false as html wont return any value if box is not ticked -Conor
    eventType varchar(255),
    classSchedule varchar(255) not null, -- enum() -Conor
    notes mediumtext
    );
    
create table if not exists smartdcu.air_quality (
	measurmentDate date not null,
    measurementTime time not null,
    measurementLocation varchar(255) not null,
    concentrationPM2_5 float not null,
    concentrationPM10 float not null,
    concentrationO3 float not null,
    concentrationSO2 float not null,
    temperature float not null,
    humidity float not null,
    operatorID varchar(255) not null,
    notes mediumtext
    );
    
create table if not exists smartdcu.room_occupancy (
	recordedDate date not null,
    timeOccupied time not null, -- Calculate server side -Conor
    roomNo varchar(10) not null, -- Review data type? take as number in HTML form / cast to int serverside? -Conor
    occupantName varchar(255) not null,
    occupantID varchar(255) not null, -- same as roomNo -Conor
    usagePurpose varchar(255) not null,
    occupantContact varchar(255),
    notes mediumtext
    );
    
create table if not exists smartdcu.campus_occupancy (
	recordedDate date not null,
    timeOccupied time not null,
    location varchar(255) not null,
    -- I have left out room, occupantName, and occupantID. Is there not a lot of occupants per measurement as its the whole campus? -Conor
    -- same for usage and purpose?
    notes mediumtext
    );
    
create table if not exists smartdcu.parking_management (
	recordedDate date not null,
    timeOccupied time not null, -- Calculate server side -Conor
    parkingLot varchar(255) not null,
    parkingSpace varchar(255) not null, -- Review data type? -Conor
    vehicleNumberPlate varchar(255) not null,
    vehicleType varchar(255) not null,
    occupantName varchar(255) not null,
    occupantID varchar(255) not null,
    occupantContact varchar(255),
    notes mediumtext
    );
    
    
    