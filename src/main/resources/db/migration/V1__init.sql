create table purchase (
	id bigint not null auto_increment,
	subscriber_id bigint not null,
	timestamp bigint not null,
	created_at datetime(6),
	updated_at datetime(6),
	primary key (id)
) engine=InnoDB;

create table subscriber (
	id bigint not null auto_increment,
	msisdn bigint not null,
	created_at datetime(6),
	updated_at datetime(6),
	primary key (id)
) engine=InnoDB;

create table subscription (
	id bigint not null auto_increment,
	subscriber_id bigint not null,
	timestamp bigint not null,
	created_at datetime(6),
	updated_at datetime(6),
	primary key (id)
) engine=InnoDB;

alter table subscriber add constraint msisdn_unique unique (msisdn);
alter table purchase add constraint fk_purchase_subscriber foreign key (subscriber_id) references subscriber (id);
alter table subscription add constraint fk_subscription_subscriber foreign key (subscriber_id) references subscriber (id);
