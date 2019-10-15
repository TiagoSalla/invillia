#### This is a simple bank project with intent of implment the leknowledge in JPA/Hibernate joining multiple tables.


CREATE TABLE client (
    id bigserial PRIMARY KEY,
    name varchar(255) NOT NULL,
    cpf varchar(11) NOT NULL,
    rg varchar(9) NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL
);


CREATE TABLE account (
    id bigserial PRIMARY KEY,
    number bigint NOT NULL,
    agency bigint NOT NULL,
    type varchar(255) NOT NULL,
    balance double precision NOT NULL,
    special_limit double precision NOT NULL,
    available_special_limit double precision NOT NULL,
    client_id bigint REFERENCES client(id) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL
);
