# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table guest (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  invitation_sent           boolean,
  rsvp                      boolean,
  constraint pk_guest primary key (id))
;

create table todo_item (
  id                        bigint not null,
  label                     varchar(255),
  constraint pk_todo_item primary key (id))
;

create table account (
  username                  varchar(255) not null,
  password                  varchar(255),
  constraint pk_account primary key (username))
;

create sequence guest_seq;

create sequence todo_item_seq;

create sequence account_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists guest;

drop table if exists todo_item;

drop table if exists account;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists guest_seq;

drop sequence if exists todo_item_seq;

drop sequence if exists account_seq;

