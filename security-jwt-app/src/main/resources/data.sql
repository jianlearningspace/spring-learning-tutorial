INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (12, '添加资源', '/sys/resource/save', 'sys.resource.save', 1, 1);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (13, '删除资源', '/sys/resource/delete', 'sys.resource.delete', 1, 2);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (14, '查看资源', '/sys/resource/query', 'sys.resource.query', 1, 3);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (15, '添加权限', '/sys/permission/save', 'sys.permission.save', 1, 4);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (16, '删除权限', '/sys/permission/delete', 'sys.permission.delete', 1, 5);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (17, '查看权限', '/sys/permission/query', 'sys.permission.query', 1, 6);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (18, '添加角色', '/sys/role/insert', 'sys.role.insert', 1, 7);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (19, '修改角色', '/sys/role/update', 'sys.role.update', 1, 8);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (20, '删除角色', '/sys/role/delete', 'sys.role.delete', 1, 9);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (21, '查询当前角色', '/sys/role/findOne', 'sys.role.findOne', 1, 10);
INSERT INTO sys_resource(resource_id,resource_name,resource_url,resource_operation,resource_type,order_by) VALUES (22, '查询角色', '/sys/role/findAll', 'sys.role.findAll', 1, 11);

INSERT INTO sys_role(role_id,role_name,role_type,order_by) VALUES (12, 'ADMIN', 0, 1);
INSERT INTO sys_role(role_id,role_name,role_type,order_by) VALUES (13, 'USER', 1, 2);

INSERT INTO sys_user(user_id,username,password,department_id,post_id,order_by) VALUES (12, 'admin', '$2a$10$uasT4Zvy0BrcSKxPGVOdeuMohuspzDRZXqgd58n.2LpzG6t8DoW62', 0, 0, 0);
INSERT INTO sys_user(user_id,username,password,department_id,post_id,order_by) VALUES (13, 'user', '$2a$10$fIk0t6E3izAL1ODh5YLCSe5etuTUJsv9a9ew3.lxslpVCOaBkwoI6', 0, 0, 1);

INSERT INTO sys_user_role(user_id,role_id) VALUES (12, 12);
INSERT INTO sys_user_role(user_id,role_id) VALUES (13, 13);

INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (12, 12, 1, 1);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (13, 12, 1, 2);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (14, 12, 1, 3);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (15, 12, 1, 4);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (16, 12, 1, 5);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (17, 12, 1, 6);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (18, 12, 1, 7);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (19, 12, 1, 8);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (20, 12, 1, 9);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (21, 12, 1, 10);
INSERT INTO sys_permission(resource_id,role_id,permission_status,order_by) VALUES (22, 12, 1, 11);