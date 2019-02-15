insert into tb_store(id, store_name, store_address) values (10000, 'Store One', '36, Avenue - Cass');
insert into tb_store(id, store_name, store_address) values (10001, 'Store Two', 'Av Austin 1223');

insert into tb_order(id, order_address, order_status, order_confirmation_date) values (100, 'Rua Antonio de Moraes, 1283', 'OPEN', {ts '2019-09-17 18:47:52.69'});
insert into tb_order(id, order_address, order_status, order_confirmation_date) values (101, 'Ave 7 de Setembro, 776', 'OPEN', {ts '2019-09-17 18:47:52.69'});
insert into tb_order_item(id, order_item_description, order_item_quantity, order_item_price, order_id) values (200, 'Order 200', 1209, 1225.09, 100);
insert into tb_order_item(id, order_item_description, order_item_quantity, order_item_price, order_id) values (201, 'Order 201', 201, 166.57, 100);
insert into tb_order_item(id, order_item_description, order_item_quantity, order_item_price, order_id) values (202, 'Order 202', 202, 61.75, 100);
insert into tb_order_item(id, order_item_description, order_item_quantity, order_item_price, order_id) values (203, 'Order 203', 203, 6.50, 101);
insert into tb_order_item(id, order_item_description, order_item_quantity, order_item_price, order_id) values (204, 'Order 204', 204, 1.67, 101);