use donateme;

create table patient(id int NOT NULL AUTO_INCREMENT, fname varchar(20) , lname varchar(20), DOB datetime,gender_id int,contact_detail_id int, address_id int, bank_detail_id int, relationship_with_patient varchar(20), primary key (id), FOREIGN KEY (gender_id) REFERENCES gender(gender_id), FOREIGN KEY (contact_detail_id) REFERENCES contact_detail(contact_detail_id), FOREIGN KEY (address_id) REFERENCES address(address_id), FOREIGN KEY (bank_detail_id) REFERENCES bank_detail(bank_detail_id));
