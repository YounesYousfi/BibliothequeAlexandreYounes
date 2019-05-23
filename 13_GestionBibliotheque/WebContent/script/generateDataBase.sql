create database bibliothequeya;
use bibliothequeya;
create table livres(id int auto_increment primary key,titre varchar(100),auteur varchar(50),prix float);
insert into livres(titre, auteur,prix) values(un livre génial, Henry Thierry,60.3);
insert into livres(titre, auteur,prix) values(un livre rouge, Luc,9.99);
insert into livres(titre, auteur,prix) values(une histoire fantastique, Gégé,15);
