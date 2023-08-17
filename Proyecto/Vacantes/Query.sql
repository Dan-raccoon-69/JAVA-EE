create database sistemadb;
use sistemadb;
show tables;
select * from vacante;
delete from vacante where id = 12;
select * from vacante order by id desc limit 3;

ALTER DATABASE sistemadb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE usuario CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE vacante CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
SHOW VARIABLES LIKE 'character\_set\_%';

select * from vacante where (descripcion like '%desarrollador%' or nombre like '%desarrollador%') order by id desc;
insert into usuario values(0, 'Daniel Bautista', 'gsutavdoakdu10@gmail.com','danraccoon',md5('54321'),'administrador', 'activo');
select * from usuario;