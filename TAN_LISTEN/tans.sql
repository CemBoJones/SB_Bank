CREATE TABLE `tans` (
  `idtans` int(11) NOT NULL AUTO_INCREMENT,
  `tan` varchar(45) NOT NULL DEFAULT '',
  `usable` tinyint(4) NOT NULL DEFAULT '1',
  `groupname` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idtans`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8;
