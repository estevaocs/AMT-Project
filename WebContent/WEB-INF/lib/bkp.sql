--
-- PostgreSQL database cluster dump
--

-- Started on 2017-02-19 23:01:10

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION PASSWORD 'md53175bce1d3201d16594cebf9d7eb3f9d';






--
-- Database creation
--

REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.20
-- Dumped by pg_dump version 9.2.20
-- Started on 2017-02-19 23:01:11

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2009 (class 1262 OID 12002)
-- Dependencies: 2008
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2012 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2013 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 16401)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE admin (
    id_user integer NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    dt_birth date NOT NULL,
    tel character(16),
    email character varying(60) NOT NULL,
    sex character varying(6),
    permission_lvl integer NOT NULL
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16411)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE aluno (
    id_user integer NOT NULL,
    login character varying(60) NOT NULL,
    password character varying(100) NOT NULL,
    first_name character varying(60),
    last_name character varying(60) NOT NULL,
    dt_birth date NOT NULL,
    tel character(16),
    email character varying(60) NOT NULL,
    sex character varying(6) NOT NULL,
    permission_lvl integer NOT NULL,
    area character varying(60),
    id_turma integer NOT NULL
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16530)
-- Name: celula; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE celula (
    id_celula integer NOT NULL,
    nome character varying(50),
    descricao character varying(140)
);


ALTER TABLE public.celula OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16490)
-- Name: dia_semana; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dia_semana (
    id_dia integer NOT NULL,
    id_mt1 integer,
    id_mt2 integer,
    id_mt3 integer,
    id_vp1 integer,
    id_vp2 integer,
    id_vp3 integer
);


ALTER TABLE public.dia_semana OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16465)
-- Name: horario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE horario (
    id_horario integer NOT NULL,
    id_seg integer,
    id_ter integer,
    id_qua integer,
    id_qui integer,
    id_sex integer,
    id_sab integer,
    id_dom integer
);


ALTER TABLE public.horario OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16408)
-- Name: instrutor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE instrutor (
    id_user integer NOT NULL,
    id_horario integer NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    first_name character varying(60) NOT NULL,
    last_name character varying(60) NOT NULL,
    dt_birth date NOT NULL,
    tel character(16),
    email character varying(60) NOT NULL,
    sex character varying(6) NOT NULL,
    permission_lvl integer NOT NULL,
    area character varying(60)
);


ALTER TABLE public.instrutor OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 16680)
-- Name: permission_lvl; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permission_lvl (
    id_permission integer NOT NULL,
    descricao character varying(60) NOT NULL
);


ALTER TABLE public.permission_lvl OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16438)
-- Name: turma; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE turma (
    id_turma integer NOT NULL,
    id_instrutor integer NOT NULL,
    id_horario integer NOT NULL,
    area character varying(60) NOT NULL,
    local character varying(100) NOT NULL,
    periodo character varying(10) NOT NULL
);


ALTER TABLE public.turma OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16394)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id_user integer NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    dt_birth date NOT NULL,
    tel character(16),
    email character(60) NOT NULL,
    sex character varying(6) NOT NULL,
    permission_lvl integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 2015 (class 0 OID 0)
-- Dependencies: 170
-- Name: COLUMN usuario.id_user; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN usuario.id_user IS 'Pry_key';


--
-- TOC entry 1996 (class 0 OID 16401)
-- Dependencies: 171
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY admin (id_user, login, password, first_name, last_name, dt_birth, tel, email, sex, permission_lvl) FROM stdin;
1	admin	21232F297A57A5A743894A0E4A801FC3	Estevão	Cristino	2017-02-19	62993929119     	estevao.silva@itsstecnologia.com.br	homem	1
\.


--
-- TOC entry 1998 (class 0 OID 16411)
-- Dependencies: 173
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY aluno (id_user, login, password, first_name, last_name, dt_birth, tel, email, sex, permission_lvl, area, id_turma) FROM stdin;
\.


--
-- TOC entry 2002 (class 0 OID 16530)
-- Dependencies: 177
-- Data for Name: celula; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY celula (id_celula, nome, descricao) FROM stdin;
\.


--
-- TOC entry 2001 (class 0 OID 16490)
-- Dependencies: 176
-- Data for Name: dia_semana; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dia_semana (id_dia, id_mt1, id_mt2, id_mt3, id_vp1, id_vp2, id_vp3) FROM stdin;
\.


--
-- TOC entry 2000 (class 0 OID 16465)
-- Dependencies: 175
-- Data for Name: horario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY horario (id_horario, id_seg, id_ter, id_qua, id_qui, id_sex, id_sab, id_dom) FROM stdin;
\.


--
-- TOC entry 1997 (class 0 OID 16408)
-- Dependencies: 172
-- Data for Name: instrutor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY instrutor (id_user, id_horario, login, password, first_name, last_name, dt_birth, tel, email, sex, permission_lvl, area) FROM stdin;
\.


--
-- TOC entry 2003 (class 0 OID 16680)
-- Dependencies: 178
-- Data for Name: permission_lvl; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY permission_lvl (id_permission, descricao) FROM stdin;
1	admin
2	instrutor
3	aluno
\.


--
-- TOC entry 1999 (class 0 OID 16438)
-- Dependencies: 174
-- Data for Name: turma; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY turma (id_turma, id_instrutor, id_horario, area, local, periodo) FROM stdin;
\.


--
-- TOC entry 1995 (class 0 OID 16394)
-- Dependencies: 170
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id_user, login, password, first_name, last_name, dt_birth, tel, email, sex, permission_lvl) FROM stdin;
1	admin	74D839D98630E280DF752E8939454A6B	Estevão	Cristino	2017-02-19	62993929119     	estevao.silva@itsstecnologia.com.br                         	homem	1
\.


--
-- TOC entry 1860 (class 2606 OID 16494)
-- Name: DiaSemana_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dia_semana
    ADD CONSTRAINT "DiaSemana_pkey" PRIMARY KEY (id_dia);


--
-- TOC entry 1842 (class 2606 OID 16400)
-- Name: Unicos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT "Unicos" UNIQUE (id_user, login);


--
-- TOC entry 1846 (class 2606 OID 16407)
-- Name: admin_id_user_login_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_id_user_login_email_key UNIQUE (id_user, login, email);


--
-- TOC entry 1852 (class 2606 OID 16417)
-- Name: aluno_id_user_login_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY aluno
    ADD CONSTRAINT aluno_id_user_login_email_key UNIQUE (id_user, login, email);


--
-- TOC entry 1854 (class 2606 OID 16415)
-- Name: aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id_user);


--
-- TOC entry 1862 (class 2606 OID 16534)
-- Name: celula_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY celula
    ADD CONSTRAINT celula_pkey PRIMARY KEY (id_celula);


--
-- TOC entry 1848 (class 2606 OID 16405)
-- Name: chave primaria; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT "chave primaria" PRIMARY KEY (id_user);


--
-- TOC entry 1858 (class 2606 OID 16469)
-- Name: horario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_pkey PRIMARY KEY (id_horario);


--
-- TOC entry 1850 (class 2606 OID 16449)
-- Name: instrutor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY instrutor
    ADD CONSTRAINT instrutor_pkey PRIMARY KEY (id_user);


--
-- TOC entry 1864 (class 2606 OID 16696)
-- Name: permission_lvl_id_permission_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permission_lvl
    ADD CONSTRAINT permission_lvl_id_permission_key UNIQUE (id_permission);


--
-- TOC entry 1866 (class 2606 OID 16694)
-- Name: permission_lvl_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permission_lvl
    ADD CONSTRAINT permission_lvl_pkey PRIMARY KEY (id_permission);


--
-- TOC entry 1856 (class 2606 OID 16442)
-- Name: turma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY turma
    ADD CONSTRAINT turma_pkey PRIMARY KEY (id_turma);


--
-- TOC entry 1844 (class 2606 OID 16398)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_user);


--
-- TOC entry 1868 (class 2606 OID 16727)
-- Name: admin_permission_lvl_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_permission_lvl_fkey FOREIGN KEY (permission_lvl) REFERENCES permission_lvl(id_permission);


--
-- TOC entry 1872 (class 2606 OID 16717)
-- Name: aluno_id_turma_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluno
    ADD CONSTRAINT aluno_id_turma_fkey FOREIGN KEY (id_turma) REFERENCES turma(id_turma);


--
-- TOC entry 1873 (class 2606 OID 16722)
-- Name: aluno_permission_lvl_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluno
    ADD CONSTRAINT aluno_permission_lvl_fkey FOREIGN KEY (permission_lvl) REFERENCES permission_lvl(id_permission);


--
-- TOC entry 1883 (class 2606 OID 16650)
-- Name: dia_semana_id_mt1_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dia_semana
    ADD CONSTRAINT dia_semana_id_mt1_fkey FOREIGN KEY (id_mt1) REFERENCES celula(id_celula);


--
-- TOC entry 1884 (class 2606 OID 16655)
-- Name: dia_semana_id_mt2_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dia_semana
    ADD CONSTRAINT dia_semana_id_mt2_fkey FOREIGN KEY (id_mt2) REFERENCES admin(id_user);


--
-- TOC entry 1885 (class 2606 OID 16660)
-- Name: dia_semana_id_mt3_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dia_semana
    ADD CONSTRAINT dia_semana_id_mt3_fkey FOREIGN KEY (id_mt3) REFERENCES admin(id_user);


--
-- TOC entry 1886 (class 2606 OID 16665)
-- Name: dia_semana_id_vp1_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dia_semana
    ADD CONSTRAINT dia_semana_id_vp1_fkey FOREIGN KEY (id_vp1) REFERENCES admin(id_user);


--
-- TOC entry 1887 (class 2606 OID 16670)
-- Name: dia_semana_id_vp2_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dia_semana
    ADD CONSTRAINT dia_semana_id_vp2_fkey FOREIGN KEY (id_vp2) REFERENCES admin(id_user);


--
-- TOC entry 1888 (class 2606 OID 16675)
-- Name: dia_semana_id_vp3_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dia_semana
    ADD CONSTRAINT dia_semana_id_vp3_fkey FOREIGN KEY (id_vp3) REFERENCES admin(id_user);


--
-- TOC entry 1876 (class 2606 OID 16615)
-- Name: horario_id_dom_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_id_dom_fkey FOREIGN KEY (id_dom) REFERENCES dia_semana(id_dia);


--
-- TOC entry 1877 (class 2606 OID 16620)
-- Name: horario_id_qua_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_id_qua_fkey FOREIGN KEY (id_qua) REFERENCES dia_semana(id_dia);


--
-- TOC entry 1878 (class 2606 OID 16625)
-- Name: horario_id_qui_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_id_qui_fkey FOREIGN KEY (id_qui) REFERENCES dia_semana(id_dia);


--
-- TOC entry 1879 (class 2606 OID 16630)
-- Name: horario_id_sab_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_id_sab_fkey FOREIGN KEY (id_sab) REFERENCES dia_semana(id_dia);


--
-- TOC entry 1880 (class 2606 OID 16635)
-- Name: horario_id_seg_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_id_seg_fkey FOREIGN KEY (id_seg) REFERENCES dia_semana(id_dia);


--
-- TOC entry 1881 (class 2606 OID 16640)
-- Name: horario_id_sex_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_id_sex_fkey FOREIGN KEY (id_sex) REFERENCES dia_semana(id_dia);


--
-- TOC entry 1882 (class 2606 OID 16645)
-- Name: horario_id_ter_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_id_ter_fkey FOREIGN KEY (id_ter) REFERENCES dia_semana(id_dia);


--
-- TOC entry 1869 (class 2606 OID 16702)
-- Name: instrutor_id_horario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instrutor
    ADD CONSTRAINT instrutor_id_horario_fkey FOREIGN KEY (id_horario) REFERENCES horario(id_horario);


--
-- TOC entry 1870 (class 2606 OID 16707)
-- Name: instrutor_id_user_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instrutor
    ADD CONSTRAINT instrutor_id_user_fkey FOREIGN KEY (id_user) REFERENCES turma(id_turma);


--
-- TOC entry 1871 (class 2606 OID 16712)
-- Name: instrutor_permission_lvl_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instrutor
    ADD CONSTRAINT instrutor_permission_lvl_fkey FOREIGN KEY (permission_lvl) REFERENCES permission_lvl(id_permission);


--
-- TOC entry 1875 (class 2606 OID 16485)
-- Name: turma_id_horario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turma
    ADD CONSTRAINT turma_id_horario_fkey FOREIGN KEY (id_horario) REFERENCES horario(id_horario);


--
-- TOC entry 1874 (class 2606 OID 16480)
-- Name: turma_id_instrutor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turma
    ADD CONSTRAINT turma_id_instrutor_fkey FOREIGN KEY (id_instrutor) REFERENCES admin(id_user) ON UPDATE RESTRICT;


--
-- TOC entry 1867 (class 2606 OID 16697)
-- Name: usuario_permission_lvl_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_permission_lvl_fkey FOREIGN KEY (permission_lvl) REFERENCES permission_lvl(id_permission);


--
-- TOC entry 2011 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 2014 (class 0 OID 0)
-- Dependencies: 178
-- Name: permission_lvl; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE permission_lvl FROM PUBLIC;
REVOKE ALL ON TABLE permission_lvl FROM postgres;
GRANT ALL ON TABLE permission_lvl TO postgres;


-- Completed on 2017-02-19 23:01:11

--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.20
-- Dumped by pg_dump version 9.2.20
-- Started on 2017-02-19 23:01:11

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1915 (class 1262 OID 1)
-- Dependencies: 1914
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 1 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1918 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1917 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-02-19 23:01:11

--
-- PostgreSQL database dump complete
--

-- Completed on 2017-02-19 23:01:11

--
-- PostgreSQL database cluster dump complete
--

