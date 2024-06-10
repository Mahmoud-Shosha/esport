INSERT INTO request_status(id, code, name, name_ar) VALUES (gen_random_uuid(), 'NEW', 'New', 'جديد');
INSERT INTO request_status(id, code, name, name_ar) VALUES (gen_random_uuid(), 'ACTION_REQUIRED', 'Action Required', 'يحتاج اجراء');
INSERT INTO request_status(id, code, name, name_ar) VALUES (gen_random_uuid(), 'ACTION_TAKEN', 'Action Taken', 'تم اتخاذ اجراء');
INSERT INTO request_status(id, code, name, name_ar) VALUES (gen_random_uuid(), 'APPROVED', 'Approved', 'تمت الموافقه');
INSERT INTO request_status(id, code, name, name_ar) VALUES (gen_random_uuid(), 'CANCELLED', 'Cancelled', 'تم الالغاء');
INSERT INTO request_status(id, code, name, name_ar) VALUES (gen_random_uuid(), 'REJECTED', 'Rejected', 'تم الرفض');
