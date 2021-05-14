insert INTO users(user_name, password, role) VALUES 
('ysz951', '$2a$10$TtzW94LrVNjOWnIkRBjJN.MU8ugGttJjtJQzVDTPkxh69qFMX06Y.', 'ROLE_USER')
on conflict (user_name) do nothing;