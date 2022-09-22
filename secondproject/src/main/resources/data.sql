Insert into article(id, title, content) values(1, 'aaaa', '111111');
Insert into article(id, title, content) values(2, 'bbbb', '22222');
Insert into article(id, title, content) values(3, 'cccc', '33333');

--Article Dummy Data 생성
Insert into article(id, title, content) values(4, '당신의 인생 영화는', '댓글 ㄱ');
Insert into article(id, title, content) values(5, '당신의 소울 푸드는', '댓글 ㄱㄱ');
Insert into article(id, title, content) values(6, '당신의 취미는', '댓글 ㄱㄱㄱ');

--Comment Dummy Data 생성
--4번 게시글 댓글
Insert into Comment(id, article_id, nickname, body) values(1,4, 'Park', '굿 윌 헌팅');
Insert into Comment(id, article_id, nickname, body) values(2,4, 'Kim', '아이엠 샘');
Insert into Comment(id, article_id, nickname, body) values(3,4, 'Choi', '쇼생크 탈출');

--5번 게시글 댓글
Insert into Comment(id, article_id, nickname, body) values(4,5, 'Park', '치킨');
Insert into Comment(id, article_id, nickname, body) values(5,5, 'Kim', '샤브샤브');
Insert into Comment(id, article_id, nickname, body) values(6,5, 'Choi', '초밥');

--5번 게시글 댓글
Insert into Comment(id, article_id, nickname, body) values(7,6, 'Park', '조깅');
Insert into Comment(id, article_id, nickname, body) values(8,6, 'Kim', '유투브');
Insert into Comment(id, article_id, nickname, body) values(9,6, 'Choi', '독서');