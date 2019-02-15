insert into tb_store(id, store_name, store_address) values (10000, 'Store One', '36, Avenue - Cass');
insert into tb_store(id, store_name, store_address) values (10001, 'Store Two', 'Av Austin 1223');

insert into tb_order(id, order_address, order_status, order_confirmation_date) values (100, 'Rua Antonio de Moraes, 1283', 'OPEN', {ts '2019-09-17 18:47:52.69'});
insert into tb_order_item(id, order_item_description, order_item_quantity, order_item_price, order_id) values (200, 'Order 200', 1209, 1225.09, 100);