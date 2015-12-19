CREATE TABLE
    weeklyreport.wr_user
    (
        id BIGINT NOT NULL AUTO_INCREMENT,
        loginname VARCHAR(50) NOT NULL,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(32) NOT NULL,
        status INT NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=gbk;