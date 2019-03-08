

\








-- 게시물 첨부파일 테이블 생성
 create table x_board_file (
    board_file_id int not null primary key auto_increment,
    file_path varchar(255) not null,
    board_id int not null,
    constraint)