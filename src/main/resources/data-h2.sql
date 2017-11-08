INSERT INTO users (username, firstname, lastname, pass, active, role) VALUES ('admin', 'Administration', '', 'admin', TRUE , 'ADMIN');

INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('1', 'Carlos', 'Camacho', '8092613358', 'Santiago');
INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('2', 'Federico', 'Perez', '8094523674', 'Santiago');
INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('3', 'Julio', 'Boneti', '8091238524', 'Santiago');
INSERT INTO client (identification_number, firstname, lastname, telephone, address) VALUES ('4', 'Roberto', 'Angel', '8097419632', 'Santo Domingo');

INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NFECK', 'Muebles');
INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NFRDK', 'Maquinaria');
INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-NARDK', 'Dispositivos');
INSERT INTO family (fkey, fname) VALUES ('PUCMM-FA-N87yHHDK', 'Vehiculos');

INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVYIB', 'Mesas', 'PUCMM-FA-NFECK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JV975YIB', 'Sillas', 'PUCMM-FA-NFECK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JAYIB', 'Motores', 'PUCMM-FA-NFRDK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVAIB', 'Computadoras', 'PUCMM-FA-NARDK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JVANIB', 'Vans', 'PUCMM-FA-N87yHHDK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JCAMIONIB', 'Camionetas', 'PUCMM-FA-N87yHHDK');
INSERT INTO subfamily (skey, sname, family_fkey) VALUES ('PUCMM-SFA-JMOTOB', 'Motos', 'PUCMM-FA-N87yHHDK');

INSERT INTO equipment (equipment_id, equipment_name, stock, sub_family_skey) VALUES ('PUCMM-E-87YJVGH', 'Desktop', 50, 'PUCMM-SFA-JVAIB');
INSERT INTO equipment (equipment_id, equipment_name, stock, sub_family_skey) VALUES ('PUCMM-E-8765VGH', 'Laptop', 1, 'PUCMM-SFA-JVAIB');
INSERT INTO equipment (equipment_id, equipment_name, stock, sub_family_skey) VALUES ('PUCMM-E-8766VGH', 'MotoYamaha', 3, 'PUCMM-SFA-JMOTOB');
INSERT INTO equipment (equipment_id, equipment_name, stock, sub_family_skey) VALUES ('PUCMM-E-8767VGH', 'CamionSuburu', 5, 'PUCMM-SFA-JCAMIONIB');
INSERT INTO equipment (equipment_id, equipment_name, stock, sub_family_skey) VALUES ('PUCMM-E-8768VGH', 'Sukzuki4X4', 1, 'PUCMM-SFA-JVANIB');

INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c3ecwc', true, 100.54, '2016-11-20', '2016-10-09', '3', 'PUCMM-E-8765VGH');
INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c4rcwc', true, 100.54, '2016-10-09', '2016-10-01', '4', 'PUCMM-E-8765VGH');
INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c5ecwc', true, 500.54, '2016-10-14', '2016-10-09', '2', 'PUCMM-E-8766VGH');
INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c6rcwc', true, 1000.54, '2016-10-12', '2016-09-20', '4', 'PUCMM-E-8767VGH');
INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c7ecwc', true, 1000.54, '2016-11-20', '2016-10-12', '3', 'PUCMM-E-8767VGH');
INSERT INTO rent (rent_id, active, price_rate, promised_date, start_date, borrower_identification_number, equipment_equipment_id) VALUES ('PUCMM-T-ni3c8rcwc', true, 700.54, '2016-10-09', '2016-10-01', '1', 'PUCMM-E-8768VGH');