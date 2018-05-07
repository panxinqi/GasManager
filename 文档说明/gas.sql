/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/12/30 19:20:41                          */
/*==============================================================*/


drop table if exists amount;

drop table if exists gas;

drop table if exists payment;

drop table if exists user;

drop table if exists user_amount;

drop table if exists user_payment;

/*==============================================================*/
/* Table: amount                                                */
/*==============================================================*/
create table amount
(
   amountId             int not null,
   userId               int,
   gasId                int,
   amount               double,
   month                varchar(20),
   enterUserName        varchar(20),
   primary key (amountId)
);

/*==============================================================*/
/* Table: gas                                                   */
/*==============================================================*/
create table gas
(
   gasId                int not null,
   gasName              varchar(20),
   gasPrice             double,
   description          text,
   primary key (gasId)
);

/*==============================================================*/
/* Table: payment                                               */
/*==============================================================*/
create table payment
(
   payId                int not null,
   amountId             int,
   payMoney             double,
   payDate              date,
   payMark              varchar(5) comment '交费单标识符
            1 表示已经缴费
            0 表示没有缴费',
   primary key (payId)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userId               int not null,
   userName             varchar(20),
   userPwd              varchar(32),
   sex                  enum('男','女'),
   phone                varchar(11),
   address              varchar(100),
   role                 varchar(10),
   userMark             varchar(5),
   primary key (userId)
);

/*==============================================================*/
/* Table: user_amount                                           */
/*==============================================================*/
create table user_amount
(
   userAmountId         int not null,
   userId               int not null,
   amountId             int not null,
   primary key (userId, amountId)
);

/*==============================================================*/
/* Table: user_payment                                          */
/*==============================================================*/
create table user_payment
(
   payHisId             int not null,
   userId               int,
   payId                int,
   primary key (payHisId)
);

alter table amount add constraint FK_Reference_6 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table amount add constraint FK_Reference_7 foreign key (gasId)
      references gas (gasId) on delete restrict on update restrict;

alter table payment add constraint FK_Reference_8 foreign key (amountId)
      references amount (amountId) on delete restrict on update restrict;

alter table user_amount add constraint FK_Reference_2 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table user_amount add constraint FK_Reference_4 foreign key (amountId)
      references amount (amountId) on delete restrict on update restrict;

alter table user_payment add constraint FK_Reference_1 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table user_payment add constraint FK_Reference_3 foreign key (payId)
      references payment (payId) on delete restrict on update restrict;

