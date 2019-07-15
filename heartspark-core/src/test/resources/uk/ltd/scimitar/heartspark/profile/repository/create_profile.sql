INSERT INTO profile (id, gender, matched_gender, date_of_birth, profile_name, profile_message, tag_line, body_type, eye_colour, hair_colour, weight, height, ethnicity, religion, education, salary, smoker, driving_licence, alcohol_drinker, children, young_children, employed, created_at, updated_at) VALUES (1, 'MALE', 'FEMALE', '1940-11-27', 'Bruce', 'Welcome', 'Tag line', 'MUSCULAR', 'BROWN', 'BROWN', 62, 175, 'ASIAN', 'BUDDHIST', 'UNIVERSITY', 'OVER_50K', 2, 1, 1, 1, 2, 1, NOW(), NOW());
INSERT INTO profile (id, gender, matched_gender, date_of_birth, profile_name, profile_message, tag_line, body_type, eye_colour, hair_colour, weight, height, ethnicity, religion, education, salary, smoker, driving_licence, alcohol_drinker, children, young_children, employed, created_at, updated_at) VALUES (2, 'FEMALE', 'MALE', '1945-03-19', 'Linda', 'Welcome', 'Tag line', 'SLIM', 'BLUE', 'BLOND', 58, 168, 'CAUCASIAN', 'BUDDHIST', 'UNIVERSITY', 'OVER_50K', 2, 1, 1, 1, 2, 1, NOW(), NOW());
INSERT INTO profile (id, gender, matched_gender, date_of_birth, profile_name, profile_message, tag_line, body_type, eye_colour, hair_colour, weight, height, ethnicity, religion, education, salary, smoker, driving_licence, alcohol_drinker, children, young_children, employed, created_at, updated_at) VALUES (3, 'FEMALE', 'MALE', '1960-10-13', 'China', 'Welcome', 'Tag line', 'SLIM', 'BLUE', 'BLACK', 60, 155, 'CAUCASIAN', 'CHRISTIAN', 'UNIVERSITY', 'OVER_50K', 1, 1, 1, 1, 0, 1, NOW(), NOW());

INSERT INTO tag(id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (1, 1, 'Matched', 1, 'MATCHED', NOW(), NOW());
INSERT INTO tag(id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (2, 1, 'Like', 1, 'LIKE', NOW(), NOW());
INSERT INTO tag(id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (3, 2, 'Matched', 1, 'MATCHED', NOW(), NOW());

INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (1, 2);
INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (2, 2);
INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (2, 3);
INSERT INTO tag_profile_map(tag_id, profile_id) VALUES (3, 1);
