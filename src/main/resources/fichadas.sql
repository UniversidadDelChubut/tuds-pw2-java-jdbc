ROLLBACK;
BEGIN;

create schema fichadas;

create table fichadas.empleado(
	id serial,
	documento int4 not null,
	apellido text,
	nombre text,
	primary key(id),
	unique(documento)
);

insert into fichadas.empleado(documento, apellido, nombre)
values
	(12312312, 'ARGENTO', 'JOSE'),
	(23423423, 'FUSENECO', 'DARDO'),
	(34534534, 'MANTEROLA', 'PAOLA')
;

create table fichadas.movimiento (
	id serial,
	empleado_id int4 not null,
	tipo_movimiento char(1) not null CHECK (tipo_movimiento in('E','S')),
	fecha_hora timestamp not null,
	
	primary key(id),
	foreign key(empleado_id) references fichadas.empleado(id)
);

insert into fichadas.movimiento(empleado_id, tipo_movimiento, fecha_hora)
values
(1, 'E', now() - interval '3 hour'),
(1, 'S', now() - interval '3 hour'),
(2, 'E', now() - interval '2 hour')
;

commit;
