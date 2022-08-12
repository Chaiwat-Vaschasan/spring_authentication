CREATE TABLE public."role" (
	role_id int4 NOT NULL,
	account_id uuid NOT NULL,
	CONSTRAINT role_pk PRIMARY KEY (role_id, account_id)
);