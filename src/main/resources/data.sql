insert into app_user (firstname, lastname, email, password, role)
values ('Dawid','Bossek','boss@email.pl','$2a$10$OnhzwxNuiIFizqrgl5ovxOuS56E./DNo2XsFFfzEEARYg3Lu.KJ46','ADMIN'),
       ('Szymon','Userowicz','user@email.pl','$2a$10$H6.GZZkJUzWegCIE0hElPu0HP4.TeXdx.OVBneoZ/bX4vJY8KMyZq','USER'),
       ('Szymon','Klonowicz','klon1@email.pl','$2a$10$H6.GZZkJUzWegCIE0hElPu0HP4.TeXdx.OVBneoZ/bX4vJY8KMyZq','USER'),
       ('Szymon','Klonowicz','klon2@email.pl','$2a$10$H6.GZZkJUzWegCIE0hElPu0HP4.TeXdx.OVBneoZ/bX4vJY8KMyZq','USER'),
       ('Szymon','Klonowicz','klon3@email.pl','$2a$10$H6.GZZkJUzWegCIE0hElPu0HP4.TeXdx.OVBneoZ/bX4vJY8KMyZq','USER'),
       ('Szymon','Klonowicz','klon3@email.pl','$2a$10$H6.GZZkJUzWegCIE0hElPu0HP4.TeXdx.OVBneoZ/bX4vJY8KMyZq','USER'),
       ('Dawid','Klonowicz','klonboss1@email.pl','$2a$10$H6.GZZkJUzWegCIE0hElPu0HP4.TeXdx.OVBneoZ/bX4vJY8KMyZq','USER');

insert into announcement (title,body,created_by_id)
values  ('Owocowy czwartek','Jutro będzie owocowy czwartek. Bedę sprawdzał owoce Waszej pracy. Przygotujcie się i pokażcie jak dobrze idzie Wam uprawianie kodu.',1);

insert into announcement (title,body,created_by_id)
values  ('Pilne wezwanie','Proszę stawić się do bióra o godzinie 9:00. Omówimy zasady pracy klona.',1);

insert into announcement_show_to (announcement_id,show_to_id)
values (1,2),(2,3),(2,4),(2,5),(2,6);