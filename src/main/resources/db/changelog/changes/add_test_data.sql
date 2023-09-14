-- add lectors
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (500, 1, 'ASSISTANT', 'Olga', 'Kobylyanska');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (600, 2, 'ASSISTANT', 'Ivan', 'Mazepa');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (700, 3, 'ASSISTANT', 'Vasyl', 'Holoborodko');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (800, 4, 'ASSISTANT_PROFESSOR', 'Vasyl', 'Stus');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (900, 5, 'ASSISTANT_PROFESSOR', 'Vasyl', 'Simonenko');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (1000, 6, 'ASSISTANT_PROFESSOR', 'Lina', 'Kostenko');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (1100, 7, 'PROFESSOR', 'Taras', 'Shevchenko');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (1200, 8, 'PROFESSOR', 'Ivan', 'Franko');
INSERT INTO public.lectors (salary, id, degree, first_name, last_name) VALUES (1300, 9, 'PROFESSOR', 'Lesya', 'Ukrainka');

-- add departments
INSERT INTO public.departments (head_of_department_id, id, name) VALUES (7, 1, 'first_department');
INSERT INTO public.departments (head_of_department_id, id, name) VALUES (8, 2, 'second_department');
INSERT INTO public.departments (head_of_department_id, id, name) VALUES (9, 3, 'third_department');

-- add departments_lectors
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (1, 1);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (2, 2);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (3, 3);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (1, 4);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (2, 5);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (3, 6);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (1, 7);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (2, 8);
INSERT INTO public.departments_lectors (department_id, lector_id) VALUES (3, 9);