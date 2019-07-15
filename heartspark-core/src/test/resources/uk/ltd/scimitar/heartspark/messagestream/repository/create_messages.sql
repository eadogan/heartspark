INSERT INTO profile (id, gender, matched_gender, date_of_birth, profile_name, profile_message, tag_line, body_type, eye_colour, hair_colour, weight, height, ethnicity, religion, education, salary, smoker, driving_licence, alcohol_drinker, children, young_children, employed, created_at, updated_at) VALUES (1, 'MALE', 'FEMALE', '1940-11-27', 'Bruce', 'Welcome', 'Tag line', 'MUSCULAR', 'BROWN', 'BROWN', 62, 175, 'ASIAN', 'BUDDHIST', 'UNIVERSITY', 'OVER_50K', 2, 1, 1, 1, 2, 1, NOW(), NOW());
INSERT INTO profile (id, gender, matched_gender, date_of_birth, profile_name, profile_message, tag_line, body_type, eye_colour, hair_colour, weight, height, ethnicity, religion, education, salary, smoker, driving_licence, alcohol_drinker, children, young_children, employed, created_at, updated_at) VALUES (2, 'FEMALE', 'MALE', '1945-03-19', 'Linda', 'Welcome', 'Tag line', 'SLIM', 'BLUE', 'BLOND', 58, 168, 'CAUCASIAN', 'BUDDHIST', 'UNIVERSITY', 'OVER_50K', 2, 1, 1, 1, 2, 1, NOW(), NOW());
INSERT INTO profile (id, gender, matched_gender, date_of_birth, profile_name, profile_message, tag_line, body_type, eye_colour, hair_colour, weight, height, ethnicity, religion, education, salary, smoker, driving_licence, alcohol_drinker, children, young_children, employed, created_at, updated_at) VALUES (3, 'FEMALE', 'MALE', '1960-10-13', 'China', 'Welcome', 'Tag line', 'SLIM', 'BLUE', 'BLACK', 60, 155, 'CAUCASIAN', 'CHRISTIAN', 'UNIVERSITY', 'OVER_50K', 1, 1, 1, 1, 0, 1, NOW(), NOW());

INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (1, 1, 2, 'From bruce to linda 1', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (2, 1, 2, 'From bruce to linda 2', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (3, 1, 2, 'From bruce to linda 3', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (4, 1, 2, 'From bruce to linda 4', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (5, 1, 2, 'From bruce to linda 5', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (6, 1, 2, 'From bruce to linda 6', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (7, 1, 2, 'From bruce to linda 7', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (8, 1, 2, 'From bruce to linda 8', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (9, 1, 2, 'From bruce to linda 9', NOW(), NOW());

INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (10, 2, 1, 'From linda to bruce 1', NOW(), NOW());
INSERT INTO message (id, source_profile_id, dest_profile_id, content, created_at, updated_at) VALUES (11, 2, 1, 'From linda to bruce 2', NOW(), NOW());
