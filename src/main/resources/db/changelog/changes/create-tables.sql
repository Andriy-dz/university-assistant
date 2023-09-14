-- Create table lectors
CREATE TABLE public.lectors
(
    salary     DOUBLE PRECISION,
    id         bigserial PRIMARY KEY,
    degree     VARCHAR(255) CHECK (degree IN ('ASSISTANT', 'ASSISTANT_PROFESSOR', 'PROFESSOR')),
    first_name varchar(255),
    last_name  varchar(255)
);

ALTER TABLE public.lectors
    owner TO university;

CREATE INDEX lectors_first_name
    ON public.lectors (first_name);

CREATE INDEX lectors_last_name
    ON public.lectors (last_name);

-- Create table departments
CREATE TABLE public.departments
(
    head_of_department_id bigint,
    id                    bigserial PRIMARY KEY,
    name                  VARCHAR(255) UNIQUE
);

ALTER TABLE public.departments
    owner TO university;

CREATE INDEX departments_name
    ON public.departments (name);

-- Create Table departments_lectors
CREATE TABLE public.departments_lectors
(
    department_id bigint NOT NULL
        CONSTRAINT fka96v7ax2suq0c4y6s2kv0x7pl REFERENCES public.departments,
    lector_id     bigint NOT NULL
        CONSTRAINT fk1xgankxbb4ev44nnspjg90eoq REFERENCES public.lectors
);

ALTER TABLE public.departments_lectors
    owner TO university;
