CREATE SEQUENCE public.role_group_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE public.role_group (
	role_id int4 NOT NULL DEFAULT nextval('role_group_seq'::regclass),
	role_name varchar(200) NOT NULL,
	create_date timestamp NULL,
	create_by varchar(1000) NULL,
	update_date timestamp NULL,
	update_by varchar(1000) NULL,
	CONSTRAINT role_group_pk PRIMARY KEY (role_id)
);