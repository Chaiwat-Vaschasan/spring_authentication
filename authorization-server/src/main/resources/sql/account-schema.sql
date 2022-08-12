CREATE TABLE public.account (
	account_id uuid NOT NULL,
	username varchar(1000) NOT NULL,
	"password" varchar(1000) NOT NULL,
	email varchar(200) NULL,
	create_date timestamp NULL,
	create_by varchar(1000) NULL,
	update_date timestamp NULL,
	update_by varchar(1000) NULL,
	is_active bool NOT NULL DEFAULT true,
	CONSTRAINT account_pk PRIMARY KEY (account_id)
);
CREATE INDEX account_username_idx ON public.account USING btree (username);