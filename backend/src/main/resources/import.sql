insert into categoria (categoria_datacadastro, categoria_descricao) values (now(), 'Santa Cruz');
insert into categoria (categoria_datacadastro, categoria_descricao) values (now(), 'Servimed');
insert into categoria (categoria_datacadastro, categoria_descricao) values (now(), 'nova forma');
insert into categoria (categoria_datacadastro, categoria_descricao) values (now(), 'DCenter');

insert into subcategoria (subcategoria_datacadastro, categoria_id, subcategoria_descricao) value (now(), 1, 'Santa Cruz');
insert into subcategoria (subcategoria_datacadastro, categoria_id, subcategoria_descricao) value (now(), 2, 'servimed');
insert into subcategoria (subcategoria_datacadastro, categoria_id, subcategoria_descricao) value (now(), 1, 'NOVAS PROMOCOES');
insert into subcategoria (subcategoria_datacadastro, categoria_id, subcategoria_descricao) value (now(), 1, 'LISTAS DE PREÇOS');
insert into subcategoria (subcategoria_datacadastro, categoria_id, subcategoria_descricao) value (now(), 4, 'nova lista');

insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (2 , now(),'filial03@natusfarma.com.br', 'FILIAL 03', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (3 , now(),'filial04@natusfarma.com.br', 'FILIAL 04', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (4 , now(),'filial05@natusfarma.com.br', 'FILIAL 05', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (5 , now(),'filial06@natusfarma.com.br', 'FILIAL 06', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (6 , now(),'filial07@natusfarma.com.br', 'FILIAL 07', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (9 , now(),'filial10@natusfarma.com.br', 'FILIAL 10', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (7 , now(),'filial08@natusfarma.com.br', 'FILIAL 08', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (8 , now(),'filial09@natusfarma.com.br', 'FILIAL 09', '123456', '0',NULL);
insert into cliente (cliente_id, cliente_datacadastro,cliente_email, cliente_nome, cliente_senha, cliente_status, perfil_id) values (1 , now(),'filial02@natusfarma.com.br', 'FILIAL 02', '123456', '0',NULL);

insert into tarefa(tarefa_id , tarefa_datacadastro, subcategoria_id, tarefa_data_tarefa, tarefa_descricao, tarefa_titulo, tarefa_horalimite) values (1, now(), 1, '2023-03-21', 'ponto de gondula', 'tarefa semanal', '23:59:59');
insert into tarefa(tarefa_id , tarefa_datacadastro, subcategoria_id, tarefa_data_tarefa, tarefa_descricao, tarefa_titulo, tarefa_horalimite) values (2, now(), 2, '2023-03-25', 'promocao do mês', 'tarefa mensal', '23:59:59');

insert into tarefa_cliente (tarcli_id, tarefa_id , cliente_id, tarcli_dataenvio, tarcli_obs, tarcli_status) values (1, 1, 2, now(), 'alguma observacao 1', 'PENDENTE');
insert into tarefa_cliente (tarcli_id, tarefa_id , cliente_id, tarcli_dataenvio, tarcli_obs, tarcli_status) values (2, 2, 3, now(), 'alguma observacao 2', 'PENDENTE');
insert into tarefa_cliente (tarcli_id, tarefa_id , cliente_id, tarcli_dataenvio, tarcli_obs, tarcli_status) values (3, 2, 1, now(), 'alguma observacao 3', 'PENDENTE');

insert into grupo (grupo_id, grupo_descricao) values (1, 'ADMINISTRADOR');
insert into grupo (grupo_id, grupo_descricao) values (2, 'LOJA');
insert into grupo (grupo_id, grupo_descricao, categoria_id) values (3, 'FORNECEDOR', 1);

insert into cliente_grupo (cliente_id, grupo_id) values (1,1);
insert into cliente_grupo (cliente_id, grupo_id) values (2,2);
insert into cliente_grupo (cliente_id, grupo_id) values (3,3);
insert into cliente_grupo (cliente_id, grupo_id) values (4,2);
