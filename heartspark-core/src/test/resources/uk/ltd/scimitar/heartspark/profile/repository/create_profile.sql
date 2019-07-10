INSERT INTO profile (id, gender, matched_gender, date_of_birth, created_at, updated_at) VALUES (1, 'MALE', 'FEMALE', '1940-11-27', NOW(), NOW());
INSERT INTO profile (id, gender, matched_gender, date_of_birth, created_at, updated_at) VALUES (2, 'FEMALE', 'MALE', '1945-03-19', NOW(), NOW());
INSERT INTO profile (id, gender, matched_gender, date_of_birth, created_at, updated_at) VALUES (3, 'FEMALE', 'MALE', '1960-10-13', NOW(), NOW());

INSERT INTO tag(id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (1, 1, 'Matched', 1, 'MATCHED', NOW(), NOW());
INSERT INTO tag(id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (2, 1, 'Like', 1, 'LIKE', NOW(), NOW());
INSERT INTO tag(id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (3, 2, 'Matched', 1, 'MATCHED', NOW(), NOW());
INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (1, 2);
INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (2, 2);
INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (2, 3);
INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (3, 1);
