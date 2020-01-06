drop table if exists credit_transaction;
create table credit_transaction
(
	id long AUTO_INCREMENT PRIMARY KEY,
	user_id long,
	channel_id long,
	event_id long,
	credit int,
	created_time TIMESTAMP
);

