-- 图片表
CREATE TABLE photo_table (
    id VARCHAR(100) NOT NULL  PRIMARY KEY,
    photo MEDIUMBLOB  COMMENT '照片'
);
-- word表
CREATE TABLE word_table(
   id VARCHAR(100) NOT NULL  PRIMARY KEY,
   word   MEDIUMTEXT   COMMENT'Word文档字符串形式'
);

DROP TABLE word_table

SELECT * FROM photo_table;
SELECT photo FROM photo WHERE id = "cbd52323-7933-4f7e-89d1-bf0e9389ffa9"

SELECT * FROM word_table;